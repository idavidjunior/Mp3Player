package com.mp3player.data.audio

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tanh

/**
 * Efeitos de motor no estilo JetAudio, processados apos o equalizador e antes
 * do limitador. Cada efeito tem bypass exato quando seu valor é 0 (custo zero).
 */
class EffectsChain {

    private var sampleRate = 44100

    /** Bass Boost: duas prateleiras graves (~90/140 Hz), 0f..1f mapeia 0..+9 dB. */
    private val bassLow = LowShelf(90f)
    private val bassHigh = LowShelf(140f)
    var bassBoost = 0f
        private set

    /** Stereo Widener M/S: amplia o sinal lateral sem mover o centro. */
    var stereoWidth = 0f
        private set

    /** Reverb curto estilo sala: pentes + allpass por canal, mix 0..1. */
    var reverbMix = 0f
        private set
    private val reverbL = SimpleReverb()
    private val reverbR = SimpleReverb()

    fun configure(sampleRate: Int) {
        this.sampleRate = sampleRate
        bassLow.setSampleRate(sampleRate)
        bassHigh.setSampleRate(sampleRate)
        reverbL.init(sampleRate)
        reverbR.init(sampleRate)
        applyBass()
    }

    fun setBassBoost(amount: Float) {
        bassBoost = amount.coerceIn(0f, 1f)
        applyBass()
    }

    private fun applyBass() {
        // +9 dB no total dividido em duas prateleiras para curva suave
        val db = bassBoost * 9f
        bassLow.configure(db)
        bassHigh.configure(db * 0.5f)
    }

    fun setStereoWidth(amount: Float) {
        stereoWidth = amount.coerceIn(0f, 1f)
    }

    fun setReverbMix(amount: Float) {
        reverbMix = amount.coerceIn(0f, 1f)
    }

    val isActive: Boolean
        get() = bassBoost > 0.001f || stereoWidth > 0.001f || reverbMix > 0.001f

    /**
     * Processa um frame estéreo (L,R). Com mono, o mesmo sinal entra/sai nos dois.
     */
    fun processFrame(left: Float, right: Float, channels: Int): Pair<Float, Float> {
        if (!isActive) return left to right

        var l = left
        var r = right

        if (bassBoost > 0.001f) {
            l = bassHigh.process(bassLow.process(l))
            r = bassHigh.process(bassLow.process(r))
        }

        if (stereoWidth > 0.001f && channels >= 2) {
            val mid = (l + r) * 0.5f
            val side = (r - l) * 0.5f * (1f + stereoWidth * 1.4f)
            l = mid - side
            r = mid + side
        }

        if (reverbMix > 0.001f) {
            val wet = reverbMix * 0.45f
            if (channels >= 2) {
                l += reverbL.process(l) * wet
                r += reverbR.process(r) * wet
            } else {
                val wetSig = reverbL.process(l) * wet
                l += wetSig
                r += wetSig
            }
        }

        // Guarda suave contra excursão dos efeitos; limiter final ainda atua
        l = tanh(l.toDouble()).toFloat()
        r = tanh(r.toDouble()).toFloat()
        return l to r
    }

    fun reset() {
        bassLow.reset(); bassHigh.reset()
        reverbL.reset(); reverbR.reset()
    }
}

/** Prateleira grave RBJ low-shelf (S=1 => alpha = sin(w0)/2 * sqrt(2)). */
class LowShelf(private var freqHz: Float) {

    private var sampleRate = 44100
    private var b0 = 1.0; private var b1 = 0.0; private var b2 = 0.0
    private var a1 = 0.0; private var a2 = 0.0
    private var x1 = 0.0; private var x2 = 0.0
    private var y1 = 0.0; private var y2 = 0.0

    fun setSampleRate(rate: Int) {
        sampleRate = rate
    }

    fun configure(gainDb: Float) {
        if (gainDb <= 0.01f) {
            b0 = 1.0; b1 = 0.0; b2 = 0.0; a1 = 0.0; a2 = 0.0
            reset()
            return
        }
        val w0 = 2.0 * PI * freqHz / sampleRate
        val cosW0 = cos(w0)
        val sinW0 = sin(w0)
        val a = 10.0.pow(gainDb / 40.0)
        val alpha = sinW0 / 2.0 * sqrt(2.0)
        val twoSqrtAAlpha = 2.0 * sqrt(a) * alpha

        val b0n = a * ((a + 1.0) - (a - 1.0) * cosW0 + twoSqrtAAlpha)
        val b1n = 2.0 * a * ((a - 1.0) - (a + 1.0) * cosW0)
        val b2n = a * ((a + 1.0) - (a - 1.0) * cosW0 - twoSqrtAAlpha)
        val a0n = (a + 1.0) + (a - 1.0) * cosW0 + twoSqrtAAlpha
        val a1n = -2.0 * ((a - 1.0) + (a + 1.0) * cosW0)
        val a2n = (a + 1.0) + (a - 1.0) * cosW0 - twoSqrtAAlpha

        b0 = b0n / a0n; b1 = b1n / a0n; b2 = b2n / a0n
        a1 = a1n / a0n; a2 = a2n / a0n
        reset()
    }

    fun process(sample: Float): Float {
        val x = sample.toDouble()
        val y = b0 * x + b1 * x1 + b2 * x2 - a1 * y1 - a2 * y2
        x2 = x1; x1 = x; y2 = y1; y1 = y
        return y.toFloat()
    }

    fun reset() { x1 = 0.0; x2 = 0.0; y1 = 0.0; y2 = 0.0 }
}

/**
 * Reverb Schroeder simplificado: 8 pentes com damping + 3 allpass.
 * Delays clássicos em samples @44.1kHz escalados pela taxa real.
 */
class SimpleReverb {

    private class Comb(val delay44k: Int) {
        lateinit var buffer: FloatArray
        var idx = 0
        var filterStore = 0f

        fun init(rate: Int) {
            val n = (delay44k.toLong() * rate / 44100L).toInt().coerceAtLeast(8)
            buffer = FloatArray(n)
            idx = 0
            filterStore = 0f
        }

        fun process(input: Float, feedback: Float, damp: Float): Float {
            val output = buffer[idx]
            filterStore = output * (1f - damp) + filterStore * damp
            buffer[idx] = input + filterStore * feedback
            if (++idx >= buffer.size) idx = 0
            return output
        }
    }

    private class Allpass(val delay44k: Int) {
        lateinit var buffer: FloatArray
        var idx = 0

        fun init(rate: Int) {
            val n = (delay44k.toLong() * rate / 44100L).toInt().coerceAtLeast(8)
            buffer = FloatArray(n)
            idx = 0
        }

        fun process(input: Float): Float {
            val bufOut = buffer[idx]
            val out = -input + bufOut
            buffer[idx] = input + bufOut * 0.5f
            if (++idx >= buffer.size) idx = 0
            return out
        }
    }

    private val combs = listOf(
        Comb(1116), Comb(1188), Comb(1277), Comb(1356),
        Comb(1422), Comb(1491), Comb(1557), Comb(1617)
    )
    private val allpasses = listOf(Allpass(556), Allpass(441), Allpass(341))

    fun init(sampleRate: Int) {
        combs.forEach { it.init(sampleRate) }
        allpasses.forEach { it.init(sampleRate) }
    }

    fun process(input: Float): Float {
        var acc = 0f
        for (c in combs) acc += c.process(input, 0.82f, 0.35f)
        acc /= combs.size.toFloat()
        for (ap in allpasses) acc = ap.process(acc)
        return acc
    }

    fun reset() {
        combs.forEach { it.buffer.fill(0f); it.filterStore = 0f }
        allpasses.forEach { it.buffer.fill(0f) }
    }
}
