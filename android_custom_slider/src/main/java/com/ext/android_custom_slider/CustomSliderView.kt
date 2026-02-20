package com.ext.android_custom_slider

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.DecelerateInterpolator
import kotlin.math.max
import kotlin.math.min

class CustomSliderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var minValue = 0f
    private var maxValue = 100f
    private var currentValue = 50f
    private var animatedValue = currentValue

    private var trackColor = Color.LTGRAY
    private var progressColor = Color.BLUE
    private var thumbColor = Color.RED

    private var trackHeight = 12f
    private var thumbRadius = 24f

    private var enableAnimation = true
    private var animationDuration = 300

    private val trackPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val progressPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val thumbPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var animator: ValueAnimator? = null

    init {
        attrs?.let {
            val ta = context.obtainStyledAttributes(it, R.styleable.CustomSliderView)

            minValue = ta.getFloat(R.styleable.CustomSliderView_cs_min, 0f)
            maxValue = ta.getFloat(R.styleable.CustomSliderView_cs_max, 100f)
            currentValue = ta.getFloat(R.styleable.CustomSliderView_cs_value, 50f)
            animatedValue = currentValue

            trackColor = ta.getColor(R.styleable.CustomSliderView_cs_trackColor, Color.LTGRAY)
            progressColor = ta.getColor(R.styleable.CustomSliderView_cs_progressColor, Color.BLUE)
            thumbColor = ta.getColor(R.styleable.CustomSliderView_cs_thumbColor, Color.RED)

            trackHeight = ta.getDimension(R.styleable.CustomSliderView_cs_trackHeight, 12f)
            thumbRadius = ta.getDimension(R.styleable.CustomSliderView_cs_thumbRadius, 24f)

            enableAnimation = ta.getBoolean(R.styleable.CustomSliderView_cs_enableAnimation, true)
            animationDuration = ta.getInt(R.styleable.CustomSliderView_cs_animationDuration, 300)

            ta.recycle()
        }

        trackPaint.color = trackColor
        trackPaint.strokeWidth = trackHeight
        trackPaint.strokeCap = Paint.Cap.ROUND

        progressPaint.color = progressColor
        progressPaint.strokeWidth = trackHeight
        progressPaint.strokeCap = Paint.Cap.ROUND

        thumbPaint.color = thumbColor
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerY = height / 2f
        val startX = paddingLeft.toFloat()
        val endX = width - paddingRight.toFloat()

        canvas.drawLine(startX, centerY, endX, centerY, trackPaint)

        val percent = (animatedValue - minValue) / (maxValue - minValue)
        val progressX = startX + percent * (endX - startX)

        canvas.drawLine(startX, centerY, progressX, centerY, progressPaint)
        canvas.drawCircle(progressX, centerY, thumbRadius, thumbPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_MOVE -> {
                val startX = paddingLeft.toFloat()
                val endX = width - paddingRight.toFloat()
                val x = event.x.coerceIn(startX, endX)
                val percent = (x - startX) / (endX - startX)
                val newValue = minValue + percent * (maxValue - minValue)
                setValue(newValue)
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    private fun setValue(newValue: Float) {

        val value = min(max(newValue, minValue), maxValue)

        if (!enableAnimation) {
            currentValue = value
            animatedValue = value
            invalidate()
            return
        }

        animator?.cancel()

        animator = ValueAnimator.ofFloat(animatedValue, value).apply {
            duration = animationDuration.toLong()
            interpolator = DecelerateInterpolator()

            addUpdateListener {
                this@CustomSliderView.animatedValue = it.animatedValue as Float
                invalidate()
            }
            start()
        }

        currentValue = value
    }
}