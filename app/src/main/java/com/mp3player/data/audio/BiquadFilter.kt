package com.mp3player.data.audio

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class BiquadFilter {

    private var b0 = 0.0; private var b1 = 0.0; private var b2 = 0.0
    private var a1 = 0.0; private var a2 = 0.0

    private var x1 = 0.0; private var x2 = 0.0
    private var y1 = 0.0; private var y2 = 0.0

    private var configured = false
    private var lastFrequency = 0f
    private var lastGainDb = 0f
    private var lastSampleRate = 0
    private var lastQ = 1.414f
    private var filterType = FilterType.PEAKING

    enum class FilterType {
        PEAKING,
        HIGH_PASS,
        LOW_PASS
    }

    fun configure(frequencyHz: Float, gainDb: Float, sampleRate: Int, q: Float = 1.414f) {
        configure(frequencyHz, gainDb, sampleRate, q, FilterType.PEAKING)
    }

    fun configureHighPass(frequencyHz: Float, sampleRate: Int, q: Float = 0.707f) {
        configure(frequencyHz, 0f, sampleRate, q, FilterType.HIGH_PASS)
    }

    fun configureLowPass(frequencyHz: Float, sampleRate: Int, q: Float = 0.707f) {
        configure(frequencyHz, 0f, sampleRate, q, FilterType.LOW_PASS)
    }

    private fun configure(frequencyHz: Float, gainDb: Float, sampleRate: Int, q: Float, type: FilterType) {
        filterType = type

        val frequencyClamped = frequencyHz.coerceIn(10f, sampleRate / 2f - 10f)
        val qClamped = q.coerceIn(0.1f, 20f)

        val w0 = 2.0 * PI * frequencyClamped / sampleRate
        val cosW0 = cos(w0)
        val sinW0 = sin(w0)
        val alpha = sinW0 / (2.0 * qClamped)

        when (type) {
            FilterType.PEAKING -> {
                val gainDbClamped = gainDb.coerceIn(-24f, 24f)
                val A = 10.0.pow(gainDbClamped / 40.0)

                b0 = 1.0 + alpha * A
                b1 = -2.0 * cosW0
                b2 = 1.0 - alpha * A
                val a0 = 1.0 + alpha / A
                a1 = -2.0 * cosW0
                a2 = 1.0 - alpha / A

                b0 /= a0; b1 /= a0; b2 /= a0
                a1 /= a0; a2 /= a0

                configured = true
                lastGainDb = gainDbClamped
            }

            FilterType.HIGH_PASS -> {
                // Butterworth 2nd order high-pass (Q = 1/sqrt(2) ≈ 0.707)
                // Standard RBJ cookbook: b0 = (1+cosW0)/2, b1 = -(1+cosW0), b2 = (1+cosW0)/2
                // a0 = 1+alpha, a1 = -2cosW0, a2 = 1-alpha
                b0 = (1.0 + cosW0) / 2.0
                b1 = -(1.0 + cosW0)
                b2 = (1.0 + cosW0) / 2.0
                val a0 = 1.0 + alpha
                a1 = -2.0 * cosW0
                a2 = 1.0 - alpha

                b0 /= a0; b1 /= a0; b2 /= a0
                a1 /= a0; a2 /= a0

                configured = true
                lastGainDb = 0f
            }

            FilterType.LOW_PASS -> {
                // Butterworth 2nd order low-pass
                b0 = (1.0 - cosW0) / 2.0
                b1 = 1.0 - cosW0
                b2 = (1.0 - cosW0) / 2.0
                val a0 = 1.0 + alpha
                a1 = -2.0 * cosW0
                a2 = 1.0 - alpha

                b0 /= a0; b1 /= a0; b2 /= a0
                a1 /= a0; a2 /= a0

                configured = true
                lastGainDb = 0f
            }
        }

        lastFrequency = frequencyClamped
        lastSampleRate = sampleRate
        lastQ = qClamped
        reset()
    }

    fun process(sample: Float): Float {
        if (!configured) return sample
        val x = sample.toDouble()
        val y = b0 * x + b1 * x1 + b2 * x2 - a1 * y1 - a2 * y2
        x2 = x1; x1 = x
        y2 = y1; y1 = y
        return y.toFloat()
    }

    fun processBlock(input: FloatArray, output: FloatArray, offset: Int = 0, length: Int = -1) {
        val len = if (length == -1) input.size - offset else length
        if (!configured) {
            for (i in 0 until len) output[offset + i] = input[offset + i]
            return
        }
        for (i in 0 until len) {
            val x = input[offset + i].toDouble()
            val y = b0 * x + b1 * x1 + b2 * x2 - a1 * y1 - a2 * y2
            x2 = x1; x1 = x
            y2 = y1; y1 = y
            output[offset + i] = y.toFloat()
        }
    }

    fun reset() {
        x1 = 0.0; x2 = 0.0; y1 = 0.0; y2 = 0.0
    }

    fun getFrequencyResponse(freqHz: Float, sampleRate: Int): Pair<Float, Float> {
        if (!configured) return 1.0f to 0.0f
        val w = 2.0 * PI * freqHz / sampleRate
        val cosW = cos(w)
        val sinW = sin(w)
        val numRe = b0 + b1 * cosW + b2 * cos(2.0 * w)
        val numIm = -(b1 * sinW + b2 * sin(2.0 * w))
        val denRe = 1.0 + a1 * cosW + a2 * cos(2.0 * w)
        val denIm = -(a1 * sinW + a2 * sin(2.0 * w))
        val mag = sqrt((numRe * numRe + numIm * numIm) / (denRe * denRe + denIm * denIm))
        val phase = kotlin.math.atan2(numIm * denRe - numRe * denIm, numRe * denRe + numIm * denIm)
        return mag.toFloat() to phase.toFloat()
    }

    fun getMagnitudeResponse(freqHz: Float, sampleRate: Int): Float {
        return getFrequencyResponse(freqHz, sampleRate).first
    }

    val isConfigured: Boolean get() = configured
    val frequency: Float get() = lastFrequency
    val gainDb: Float get() = lastGainDb
    val q: Float get() = lastQ
}