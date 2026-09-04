package com.mp3player

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.media.audiofx.Visualizer
import android.util.AttributeSet
import android.view.View
import com.mp3player.util.resolveThemeColor
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sqrt

class VisualizerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val barCount = 7

    // Referencia trocada a cada frame pela thread de captura; lida na UI thread.
    @Volatile
    private var displayLevels = FloatArray(barCount) { 0.1f }
    // Suavizacao/ataque mantidos apenas na thread de captura.
    private var memory = FloatArray(barCount) { 0.1f }

    var isAnimating: Boolean = false
        private set

    private var audioSessionId = 0
    private var visualizer: Visualizer? = null
    private var retryCount = 0

    private val retryRunnable = Runnable { if (isAnimating) startInternal() }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#1DB954")
        style = Paint.Style.FILL
    }

    private val inactivePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    private val rect = RectF()

    init {
        inactivePaint.color = context.resolveThemeColor(R.attr.themeSurface2)
    }

    fun setAudioSessionId(id: Int) {
        if (audioSessionId == id) return
        audioSessionId = id
        if (isAnimating) {
            release()
            startInternal()
        }
    }

    fun startAnimating() {
        if (isAnimating) return
        isAnimating = true
        startInternal()
        invalidate()
    }

    fun stopAnimating() {
        isAnimating = false
        removeCallbacks(retryRunnable)
        retryCount = 0
        release()
        displayLevels = FloatArray(barCount) { 0.1f }
        memory = FloatArray(barCount) { 0.1f }
        invalidate()
    }

    private fun startInternal() {
        if (audioSessionId <= 0) {
            // O ExoPlayer so define a session apos o prepare; tenta por alguns segundos.
            removeCallbacks(retryRunnable)
            if (retryCount < 8) {
                retryCount++
                postDelayed(retryRunnable, 400)
            }
            return
        }
        removeCallbacks(retryRunnable)
        retryCount = 0
        if (visualizer != null) return
        try {
            val sizeRange = Visualizer.getCaptureSizeRange()
            val captureSize = sizeRange[0]
            if (captureSize == 0) return
            visualizer = Visualizer(audioSessionId).apply {
                setCaptureSize(captureSize)
                setDataCaptureListener(
                    object : Visualizer.OnDataCaptureListener {
                        override fun onWaveFormDataCapture(v: Visualizer?, waveform: ByteArray?, samplingRate: Int) {}
                        override fun onFftDataCapture(v: Visualizer?, fft: ByteArray?, samplingRate: Int) {
                            fft?.let { updateLevels(it) }
                        }
                    },
                    Visualizer.getMaxCaptureRate() / 2,
                    false,
                    true
                )
                enabled = true
            }
        } catch (e: Exception) {
            visualizer = null
            android.util.Log.w("VisualizerView", "Falha ao criar Visualizer: ${e.message}")
        }
    }

    private fun updateLevels(fft: ByteArray) {
        val binCount = fft.size / 2
        if (binCount < 2) return
        val usableBins = binCount - 1
        val current = memory
        val next = FloatArray(barCount)
        for (b in 0 until barCount) {
            val low = if (b == 0) 1 else ((b.toDouble() / barCount).pow(2.0) * usableBins).toInt().coerceIn(1, usableBins)
            val high = (((b + 1).toDouble() / barCount).pow(2.0) * usableBins).toInt().coerceIn(low, usableBins)
            var magnitude = 0.0
            var count = 0
            for (i in low until high) {
                val real = fft[i * 2].toDouble() / 128.0
                val imag = fft[i * 2 + 1].toDouble() / 128.0
                magnitude += sqrt(real * real + imag * imag)
                count++
            }
            val avg = if (count > 0) magnitude / count else 0.0
            val db = 20.0 * log10(avg + 1e-9)
            val normalized = ((db + 50.0) / 50.0).coerceIn(0.0, 1.0).toFloat()
            val prev = current[b]
            next[b] = if (normalized >= prev) normalized else prev * 0.92f + normalized * 0.08f
        }
        memory = next
        displayLevels = next
        postInvalidateOnAnimation()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val gap = 4f
        val totalGaps = gap * (barCount - 1)
        val barWidth = (width - totalGaps) / barCount
        val maxHeight = height * 0.85f
        val bars = displayLevels
        for (i in 0 until barCount) {
            val barHeight = maxHeight * bars[i].coerceIn(0f, 1f)
            val left = i * (barWidth + gap)
            val top = height - barHeight
            rect.set(left, top, left + barWidth, height.toFloat() - 2f)
            canvas.drawRoundRect(rect, 3f, 3f, if (isAnimating) paint else inactivePaint)
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeCallbacks(retryRunnable)
        release()
    }

    private fun release() {
        visualizer?.let {
            try { it.enabled = false } catch (_: Exception) {}
            try { it.release() } catch (_: Exception) {}
        }
        visualizer = null
    }
}