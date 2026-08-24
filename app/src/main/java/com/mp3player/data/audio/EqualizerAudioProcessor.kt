package com.mp3player.data.audio

import android.util.Log
import androidx.media3.common.audio.AudioProcessor
import androidx.media3.common.util.UnstableApi
import com.mp3player.data.model.EqualizerBand
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.tanh

@UnstableApi
class EqualizerAudioProcessor : AudioProcessor {

    private companion object {
        const val SOFT_CLIP_THRESHOLD = 0.98f
    }

    val bandCount = EqualizerBand.BAND_COUNT
    private val filters = Array(bandCount) { BiquadFilter() }
    private val effects = EffectsChain()
    private var filterOutput: FloatArray = FloatArray(0)
    private var limiterOutput: FloatArray = FloatArray(0)
    private var workBuffer: FloatArray = FloatArray(0)

    var preampGainDb: Float = 0f
        private set

    private var sampleRate = 44100
    private var channelCount = 2

    @Volatile
    private var isActiveState = false

    @Volatile
    var enabled = true
        private set

    private var inputEnded = false
    private var outputBuffer: ByteBuffer = ByteBuffer.allocate(0)
    private var cachedOutBuf = ByteBuffer.allocate(0).order(ByteOrder.nativeOrder())

    private var peakLimiter: PeakLimiter? = null
    private var highPassFilter: BiquadFilter? = null

    private val freqs = EqualizerBand.FREQUENCIES

    private var cachedPreampLinear = 1.0f
    private var lastPreampGainDb = 0f
    private var ditherState = 0

    init {
        for (i in 0 until bandCount) {
            filters[i].configure(freqs[i], 0f, sampleRate, EqualizerBand.DEFAULT_Q)
        }
        highPassFilter = BiquadFilter()
        highPassFilter?.configureHighPass(20f, sampleRate, 0.707f)
    }

    fun setEnabled(on: Boolean) {
        enabled = on
        updateActiveState()
    }

    val gainReductionDb: Float
        get() = peakLimiter?.gainReductionDb ?: 0f

    private fun updateActiveState() {
        val anyGain = filters.any { it.isConfigured && kotlin.math.abs(it.gainDb) > 0.001f }
        isActiveState = enabled && (
            kotlin.math.abs(preampGainDb) > 0.001f ||
                anyGain ||
                effects.isActive
            )
    }

    fun setBassBoost(amount: Float) {
        effects.setBassBoost(amount)
        updateActiveState()
    }

    fun setStereoWidth(amount: Float) {
        effects.setStereoWidth(amount)
        updateActiveState()
    }

    fun setReverbMix(amount: Float) {
        effects.setReverbMix(amount)
        updateActiveState()
    }

    fun getBassBoost(): Float = effects.bassBoost
    fun getStereoWidth(): Float = effects.stereoWidth
    fun getReverbMix(): Float = effects.reverbMix

    fun setBandGain(bandId: Int, gainDb: Float) {
        if (bandId in 0 until bandCount) {
            val clampedGain = gainDb.coerceIn(-24f, 24f)
            filters[bandId].configure(freqs[bandId], clampedGain, sampleRate, EqualizerBand.DEFAULT_Q)
            updateActiveState()
        }
    }

    fun setPreampGain(gainDb: Float) {
        preampGainDb = gainDb.coerceIn(-24f, 24f)
        cachedPreampLinear = 10.0.pow(preampGainDb / 20.0).toFloat()
        lastPreampGainDb = preampGainDb
        updateActiveState()
    }

    fun resetAllBands() {
        for (i in 0 until bandCount) {
            filters[i].configure(freqs[i], 0f, sampleRate, EqualizerBand.DEFAULT_Q)
            filters[i].reset()
        }
        preampGainDb = 0f
        cachedPreampLinear = 1.0f
        lastPreampGainDb = 0f
        peakLimiter?.reset()
        highPassFilter?.reset()
        updateActiveState()
    }

    fun applyPreset(gains: FloatArray, preamp: Float = 0f) {
        val maxBands = bandCount.coerceAtMost(gains.size)
        for (i in 0 until maxBands) {
            filters[i].configure(freqs[i], gains[i].coerceIn(-24f, 24f), sampleRate, EqualizerBand.DEFAULT_Q)
        }
        preampGainDb = preamp.coerceIn(-24f, 24f)
        cachedPreampLinear = 10.0.pow(preampGainDb / 20.0).toFloat()
        lastPreampGainDb = preampGainDb
        updateActiveState()
    }

    fun getBandGain(bandId: Int): Float {
        return if (bandId in 0 until bandCount) filters[bandId].gainDb else 0f
    }

    val allGains: FloatArray
        get() = FloatArray(bandCount) { filters[it].gainDb }

    override fun configure(format: AudioProcessor.AudioFormat): AudioProcessor.AudioFormat {
        sampleRate = format.sampleRate
        channelCount = format.channelCount
        inputEnded = false

        for (i in 0 until bandCount) {
            filters[i].configure(freqs[i], filters[i].gainDb, sampleRate, EqualizerBand.DEFAULT_Q)
        }
        // Initialize limiter once, then reconfigure
        if (peakLimiter == null) {
            peakLimiter = PeakLimiter(
                sampleRate = sampleRate,
                lookaheadMs = 1f,
                thresholdDb = -0.5f,
                attackMs = 3f,   // Musical attack for bass
                releaseMs = 150f // Musical release
            )
        } else {
            // Reconfigure existing limiter with new sample rate
            peakLimiter = PeakLimiter(
                sampleRate = sampleRate,
                lookaheadMs = 1f,
                thresholdDb = -0.5f,
                attackMs = 3f,
                releaseMs = 150f
            )
        }
        highPassFilter?.configureHighPass(20f, sampleRate, 0.707f)
        highPassFilter?.reset()
        effects.configure(sampleRate)
        // Reallocate buffers for new sample rate if needed
        filterOutput = FloatArray(0)
        limiterOutput = FloatArray(0)
        workBuffer = FloatArray(0)
        updateActiveState()
        return format
    }

    override fun isActive(): Boolean = isActiveState

    override fun queueInput(inputBuffer: ByteBuffer) {
        try {
            // Contagem em SAMPLES (bytes/2), nao frames — preserva o interleave
            // real L,R do buffer e garante saida 1:1 sem colapso de canais.
            val remaining = inputBuffer.remaining() / 2
            if (remaining == 0) return

            // Bypass mode: passthrough audio unmodified
            if (!isActiveState) {
                val size = inputBuffer.remaining()
                if (cachedOutBuf.capacity() < size) {
                    cachedOutBuf = ByteBuffer.allocate(size).order(inputBuffer.order())
                }
                cachedOutBuf.clear()
                cachedOutBuf.put(inputBuffer)
                cachedOutBuf.flip()
                outputBuffer = cachedOutBuf
                // IMPORTANT: consume input buffer so ExoPlayer advances
                inputBuffer.position(inputBuffer.limit())
                inputEnded = false
                return
            }

            val input = inputBuffer.asShortBuffer()

            // Ensure temporary buffers are large enough
            val maxNeeded = remaining
            if (filterOutput.size < maxNeeded) {
                filterOutput = FloatArray(maxNeeded)
                limiterOutput = FloatArray(maxNeeded)
                workBuffer = FloatArray(maxNeeded)
            }

            // Step 1: Convert to float [-1, 1] - apply preamp FIRST (correct gain staging)
            for (i in 0 until maxNeeded) {
                filterOutput[i] = input[i].toFloat() / 32768f * cachedPreampLinear
            }

            // Step 2: High-pass filter (20Hz) to remove subsonics
            highPassFilter?.processBlock(filterOutput, filterOutput, 0, maxNeeded)

            // Step 3: Cascade filter bank (each band processes output of previous)
            for (band in 0 until bandCount) {
                val filter = filters[band]
                if (filter.isConfigured && kotlin.math.abs(filter.gainDb) > 0.001f) {
                    filter.processBlock(filterOutput, filterOutput, 0, maxNeeded)
                }
            }

            // Step 3.5: Efeitos de motor frame-aware (bass/wide/reverb), estereo real
            val stereo = channelCount >= 2
            if (effects.isActive) {
                val frames = if (stereo) maxNeeded / 2 else maxNeeded
                var i = 0
                for (f in 0 until frames) {
                    val l = filterOutput[i]
                    val r = if (stereo) filterOutput[i + 1] else l
                    val fx = effects.processFrame(l, r, channelCount)
                    filterOutput[i] = fx.first
                    if (stereo) filterOutput[i + 1] = fx.second
                    i += if (stereo) 2 else 1
                }
            }

            // Step 4: Peak limiter (with lookahead, envelope follower, makeup gain)
            peakLimiter?.process(filterOutput, limiterOutput, 0, maxNeeded) ?: run {
                System.arraycopy(filterOutput, 0, limiterOutput, 0, maxNeeded)
            }

            // Step 5: Soft-clip APENAS acima do limiar (material limpo sai limpo;
            // tanh sempre-on distorcia mesmo com ganhos baixos)
            for (i in 0 until maxNeeded) {
                var sample = limiterOutput[i]
                val a = kotlin.math.abs(sample)
                if (a > SOFT_CLIP_THRESHOLD) {
                    val over = (a - SOFT_CLIP_THRESHOLD) / (1f - SOFT_CLIP_THRESHOLD)
                    sample = kotlin.math.sign(sample) *
                        (SOFT_CLIP_THRESHOLD + tanh(over.toDouble()).toFloat() * (1f - SOFT_CLIP_THRESHOLD))
                }
                // Step 6: TPDF dither via LCG inline (sem lock de java.util.Random)
                ditherState = ditherState * 1664525 + 1013904223
                val r1 = (ditherState and 0xFFFF).toFloat() / 65536f
                ditherState = ditherState * 1664525 + 1013904223
                val r2 = (ditherState and 0xFFFF).toFloat() / 65536f
                sample += (r1 + r2 - 1f) / 32768f
                filterOutput[i] = sample.coerceIn(-1.0f, 1.0f)
            }

            // Convert back to int16, 1:1 com a entrada (estereo preservado)
            inputBuffer.position(inputBuffer.limit())

            val outBytes = maxNeeded * 2
            if (cachedOutBuf.capacity() < outBytes) {
                cachedOutBuf = ByteBuffer.allocate(outBytes).order(ByteOrder.nativeOrder())
            }
            cachedOutBuf.clear()
            cachedOutBuf.limit(outBytes)
            val outShorts = cachedOutBuf.asShortBuffer()
            for (i in 0 until maxNeeded) {
                outShorts.put((filterOutput[i] * 32767f).toInt().toShort())
            }
            cachedOutBuf.flip()
            outputBuffer = cachedOutBuf
            inputEnded = false
        } catch (e: Exception) {
            Log.e("EqualizerAudioProcessor", "queueInput error", e)
            inputBuffer.position(inputBuffer.limit())
            inputEnded = false
        }
    }

    override fun getOutput(): ByteBuffer {
        val buf = outputBuffer
        outputBuffer = ByteBuffer.allocate(0)
        return buf
    }

    override fun isEnded(): Boolean = inputEnded

    override fun queueEndOfStream() {
        inputEnded = true
    }

    override fun flush() {
        outputBuffer = ByteBuffer.allocate(0)
        inputEnded = false
        for (f in filters) f.reset()
        peakLimiter?.reset()
        highPassFilter?.reset()
        effects.reset()
    }

    override fun reset() {
        flush()
        updateActiveState()
    }
}