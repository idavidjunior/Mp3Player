package com.mp3player.data.audio

import kotlin.math.exp
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sqrt

class PeakLimiter(private val sampleRate: Int,
                  private val lookaheadMs: Float = 1f,
                  private val thresholdDb: Float = -0.5f,
                  private val attackMs: Float = 3f,
                  private val releaseMs: Float = 150f) {

    private val lookaheadSamples = (lookaheadMs * sampleRate / 1000f).toInt().coerceAtLeast(1)
    private val lookaheadBuffer = FloatArray(lookaheadSamples)
    private var lookaheadPos = 0

    private val attackCoeff = exp(-1.0 / (attackMs * sampleRate / 1000f))
    private val releaseCoeff = exp(-1.0 / (releaseMs * sampleRate / 1000f))
    private val thresholdLinear = 10.0.pow(thresholdDb / 20.0)

    private var envelope = 0.0
    private var gainReduction = 1.0
    private var makeupGain = 1.0

    @Volatile
    var gainReductionDb: Float = 0f

    fun process(input: FloatArray, output: FloatArray, offset: Int = 0, length: Int = -1) {
        val len = if (length == -1) input.size - offset else length
        val end = offset + len

        // First pass: compute peak envelope for the whole block (for makeup gain)
        var blockPeak = 0.0
        for (i in offset until end) {
            val absSample = kotlin.math.abs(input[i].toDouble())
            if (absSample > blockPeak) blockPeak = absSample
        }

        // Process with lookahead
        for (i in offset until end) {
            val sample = input[i]
            lookaheadBuffer[lookaheadPos] = sample
            lookaheadPos = (lookaheadPos + 1) % lookaheadBuffer.size

            val delayedIdx = (lookaheadPos + lookaheadBuffer.size - lookaheadSamples) % lookaheadBuffer.size
            val delayedSample = lookaheadBuffer[delayedIdx]

            val absSample = kotlin.math.abs(delayedSample.toDouble())

            // Envelope follower with proper attack/release smoothing
            if (absSample > envelope) {
                // Attack: fast rise
                envelope = absSample * (1.0 - attackCoeff) + envelope * attackCoeff
            } else {
                // Release: slow decay
                envelope = envelope * releaseCoeff
            }

            // Gain reduction calculation
            val targetGain = if (envelope > thresholdLinear) thresholdLinear / envelope else 1.0
            if (targetGain < gainReduction) {
                // Gain reduction attack (fast)
                gainReduction = targetGain * (1.0 - attackCoeff) + gainReduction * attackCoeff
            } else {
                // Gain reduction release (slow)
                gainReduction = targetGain * (1.0 - releaseCoeff) + gainReduction * releaseCoeff
            }

            // Makeup gain: compensate for average gain reduction based on block peak
            // Target: peak after limiting should not exceed threshold
            val targetPeakAfterLimiting = blockPeak * gainReduction
            if (targetPeakAfterLimiting > 0.0) {
                makeupGain = (thresholdLinear / targetPeakAfterLimiting).coerceAtMost(2.0) // Max 6dB makeup
            } else {
                makeupGain = 1.0
            }

            val limited = delayedSample * gainReduction * makeupGain
            output[i] = limited.toFloat()
        }

        // Compute gain reduction dB once per block
        gainReductionDb = (20.0 * log10(gainReduction.toDouble())).toFloat()
    }

    fun reset() {
        lookaheadPos = 0
        for (i in lookaheadBuffer.indices) lookaheadBuffer[i] = 0f
        envelope = 0.0
        gainReduction = 1.0
        makeupGain = 1.0
        gainReductionDb = 0f
    }
}