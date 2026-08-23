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

    val bandCount = EqualizerBand.BAND_COUNT
    private val filters = Array(bandCount) { BiquadFilter() }
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
    private val random = java.util.Random()
    private var debugCounter = 0

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
        isActiveState = enabled && (kotlin.math.abs(preampGainDb) > 0.001f || anyGain)
    }

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
            val remaining = inputBuffer.remaining() / channelCount
            if (remaining == 0) return

            // Debug: log once per 1000 calls
            if (debugCounter % 1000 == 0) {
                Log.d("EQ_DEBUG", "queueInput: remaining=$remaining, channelCount=$channelCount, isActiveState=$isActiveState, enabled=$enabled, preampGainDb=$preampGainDb, cachedPreampLinear=$cachedPreampLinear")
            }
            debugCounter++

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
                if (debugCounter % 100 == 1) {
                    // Check first few samples in bypass
                    val checkBuf = inputBuffer.duplicate()
                    checkBuf.position(0)
                    var nonZero = 0
                    for (i in 0 until min(10, checkBuf.remaining() / 2)) {
                        val s = checkBuf.getShort()
                        if (s != 0) nonZero++
                    }
                    Log.d("EQ_DEBUG", "BYPASS: size=$size, nonZeroSamples=$nonZero/10, isActiveState=$isActiveState")
                }
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
            var peakInput = 0f
            for (i in 0 until maxNeeded) {
                val v = input[i].toFloat() / 32768f * cachedPreampLinear
                filterOutput[i] = v
                if (kotlin.math.abs(v) > peakInput) peakInput = kotlin.math.abs(v)
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

            // Debug: check signal after filters
            var peakAfterFilters = 0f
            for (i in 0 until maxNeeded) {
                val v = kotlin.math.abs(filterOutput[i])
                if (v > peakAfterFilters) peakAfterFilters = v
            }

            // Step 4: Peak limiter (with lookahead, envelope follower, makeup gain)
            peakLimiter?.process(filterOutput, limiterOutput, 0, maxNeeded) ?: run {
                System.arraycopy(filterOutput, 0, limiterOutput, 0, maxNeeded)
            }

            // Debug: check signal after limiter
            var peakAfterLimiter = 0f
            for (i in 0 until maxNeeded) {
                val v = kotlin.math.abs(limiterOutput[i])
                if (v > peakAfterLimiter) peakAfterLimiter = v
            }
            if (debugCounter % 1000 == 2) {
                Log.d("EQ_DEBUG", "peaks: in=$peakInput, afterFilters=$peakAfterFilters, afterLimiter=$peakAfterLimiter, gainReductionDb=${peakLimiter?.gainReductionDb}")
            }

            // Step 5: Soft clipper (tanh - transparent, musical)
            for (i in 0 until maxNeeded) {
                var sample = limiterOutput[i]
                sample = tanh(sample.toDouble()).toFloat()
                // Step 6: TPDF dither (1-bit) before quantization
                val dither = (random.nextDouble() - random.nextDouble()) * 2.0 / 32768.0
                sample += dither.toFloat()
                filterOutput[i] = sample.coerceIn(-1.0f, 1.0f)
            }

            // Convert back to int16 (handle mono/stereo)
            inputBuffer.position(inputBuffer.limit())

            val outBytes = maxNeeded * channelCount * 2
            if (cachedOutBuf.capacity() < outBytes) {
                cachedOutBuf = ByteBuffer.allocate(outBytes).order(ByteOrder.nativeOrder())
            }
            cachedOutBuf.clear()
            cachedOutBuf.limit(outBytes)
            val outShorts = cachedOutBuf.asShortBuffer()
            for (i in 0 until maxNeeded) {
                val s = (filterOutput[i] * 32767f).toInt().toShort()
                if (channelCount == 1) {
                    outShorts.put(s)
                } else {
                    outShorts.put(s)
                    outShorts.put(s) // Duplicate for stereo
                }
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
        if (buf.remaining() > 0 && debugCounter % 1000 == 500) {
            val checkBuf = buf.duplicate()
            checkBuf.position(0)
            var nonZero = 0
            var maxVal = 0
            for (i in 0 until min(10, checkBuf.remaining() / 2)) {
                val s = checkBuf.getShort()
                if (s != 0) nonZero++
                val abs = kotlin.math.abs(s)
                if (abs > maxVal) maxVal = abs
            }
            Log.d("EQ_DEBUG", "getOutput: remaining=${buf.remaining()}, nonZero=$nonZero/10, maxShort=$maxVal")
        }
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
    }

    override fun reset() {
        flush()
        updateActiveState()
    }
}