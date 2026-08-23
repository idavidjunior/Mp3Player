package com.mp3player.ui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.mp3player.data.model.EqualizerBand

class EqCurveView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var levels: FloatArray = FloatArray(0)
        set(value) {
            if (value.size != field.size) {
                field = value
                currentLevels = value.clone()
                targetLevels = value.clone()
                animateToNewLevels(value)
            } else {
                animateToNewLevels(value)
            }
        }

    private var targetLevels: FloatArray = FloatArray(0)
    private var currentLevels: FloatArray = FloatArray(0)
    private var animator: ValueAnimator? = null

    private val minDb = -24f
    private val maxDb = 24f

    private val gridPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.argb(30, 255, 255, 255)
        strokeWidth = 1f
    }
    private val centerLinePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.argb(60, 255, 255, 255)
        strokeWidth = 1f
    }
    private val curvePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.argb(255, 0, 191, 255)
        strokeWidth = 2.5f
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }
    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.argb(50, 0, 191, 255)
        style = Paint.Style.FILL
    }
    private val dotPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.argb(255, 0, 191, 255)
        style = Paint.Style.FILL
    }
    private val labelPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.argb(180, 200, 200, 200)
        textSize = 24f
        isAntiAlias = true
    }
    private val freqLabelPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.argb(150, 180, 180, 180)
        textSize = 20f
        isAntiAlias = true
        textAlign = Paint.Align.CENTER
    }

    private val frequencies = EqualizerBand.FREQUENCIES
    private val freqLabels = frequencies.map { freq ->
        if (freq >= 1000f) "%.0fk".format(freq / 1000f) else "%.0f".format(freq)
    }.toTypedArray()

    private fun animateToNewLevels(newLevels: FloatArray) {
        targetLevels = newLevels.clone()
        if (currentLevels.isEmpty() || currentLevels.size != newLevels.size) {
            currentLevels = newLevels.clone()
            invalidate()
            return
        }
        animator?.cancel()
        animator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 120
            addUpdateListener { animation ->
                val fraction = animation.animatedValue as Float
                for (i in currentLevels.indices) {
                    currentLevels[i] = currentLevels[i] + (targetLevels[i] - currentLevels[i]) * fraction
                }
                invalidate()
            }
            start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val w = width.toFloat()
        val h = height.toFloat()
        if (w <= 0 || h <= 0 || currentLevels.isEmpty()) return

        val paddingLeft = 48f
        val paddingRight = 16f
        val paddingTop = 32f
        val paddingBottom = 40f
        val graphWidth = w - paddingLeft - paddingRight
        val graphHeight = h - paddingTop - paddingBottom

        // Draw dB grid lines (-24, -18, -12, -6, 0, +6, +12, +18, +24)
        for (db in -24..24 step 6) {
            val frac = (db - minDb) / (maxDb - minDb)
            val y = paddingTop + (1f - frac) * graphHeight
            if (y in paddingTop..(paddingTop + graphHeight)) {
                canvas.drawLine(paddingLeft, y, w - paddingRight, y, if (db == 0) centerLinePaint else gridPaint)
            }
        }

        // Draw frequency vertical lines
        for (i in frequencies.indices) {
            val x = paddingLeft + (i / (frequencies.size - 1f)) * graphWidth
            canvas.drawLine(x, paddingTop, x, paddingTop + graphHeight, gridPaint)
        }

        // Draw curve using Catmull-Rom spline interpolation
        if (currentLevels.size >= 2) {
            val points = mutableListOf<Pair<Float, Float>>()
            for (i in currentLevels.indices) {
                val x = paddingLeft + (i / (currentLevels.size - 1f)) * graphWidth
                val frac = (currentLevels[i] - minDb) / (maxDb - minDb)
                val y = paddingTop + (1f - frac) * graphHeight
                points.add(x to y.coerceIn(paddingTop, paddingTop + graphHeight))
            }

            val path = Path()
            val fillPath = Path()

            // Catmull-Rom spline
            path.moveTo(points[0].first, points[0].second)
            fillPath.moveTo(points[0].first, paddingTop + graphHeight)

            for (i in 1 until points.size) {
                val p0 = if (i - 2 >= 0) points[i - 2] else points[0]
                val p1 = points[i - 1]
                val p2 = points[i]
                val p3 = if (i + 1 < points.size) points[i + 1] else points.last()

                val cp1x = p1.first + (p2.first - p0.first) / 6f
                val cp1y = p1.second + (p2.second - p0.second) / 6f
                val cp2x = p2.first - (p3.first - p1.first) / 6f
                val cp2y = p2.second - (p3.second - p1.second) / 6f

                path.cubicTo(cp1x, cp1y, cp2x, cp2y, p2.first, p2.second)
                fillPath.lineTo(p2.first, p2.second)
            }

            // Close fill path
            fillPath.lineTo(points.last().first, paddingTop + graphHeight)
            fillPath.lineTo(points.first().first, paddingTop + graphHeight)
            fillPath.close()

            canvas.drawPath(fillPath, fillPaint)
            canvas.drawPath(path, curvePaint)

            // Draw dots at band centers
            for ((x, y) in points) {
                canvas.drawCircle(x, y, 5f, dotPaint)
            }
        }

        // Draw frequency labels at bottom
        for (i in freqLabels.indices) {
            val x = paddingLeft + (i / (freqLabels.size - 1f)) * graphWidth
            canvas.drawText(freqLabels[i], x, h - 8f, freqLabelPaint)
        }

        // Draw dB labels on left
        for (db in -24..24 step 6) {
            val frac = (db - minDb) / (maxDb - minDb)
            val y = paddingTop + (1f - frac) * graphHeight
            val label = if (db > 0) "+$db" else db.toString()
            canvas.drawText(label, 4f, y + 8f, labelPaint)
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator?.cancel()
    }
}