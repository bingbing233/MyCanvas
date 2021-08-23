package com.bing.mycanvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 *  @author: liangbinghao
 *  @date:  2021/8/23 15:25
 *  @desc: 画板（后续可增加对paint的自定义）
 */
class MyCanvas @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int? = 0) :
    View(
        context,
        attributeSet,
        defStyleAttr!!
    ) {

    var mPath = Path()
    var mPaint = Paint()

    init {
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 5f
        mPaint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(mPath, mPaint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var x = event!!.x
        var y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mPath.moveTo(x, y)
            }
            MotionEvent.ACTION_MOVE -> {
                mPath.lineTo(x, y)
            }
            MotionEvent.ACTION_UP -> {
                mPath.lineTo(x, y)
            }
        }
        invalidate()
        return true
    }

    fun clear(){
        mPath.reset()
        invalidate()
    }

}