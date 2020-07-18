package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.Components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class PrefixCustomEditText(
    context: Context, attrs: AttributeSet
) : AppCompatEditText(context, attrs) {

    private var mPrefix = "+95"
    private var mPrefixColor = Color.BLUE

    private val mPrefixRect = Rect()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        paint.getTextBounds(mPrefix,0,mPrefix.length,mPrefixRect)
        mPrefixRect.right += paint.measureText(" ").toInt()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        paint.color = mPrefixColor
        canvas?.drawText(mPrefix,super.getCompoundPaddingLeft().toFloat(),baseline.toFloat(),paint)
        super.onDraw(canvas)
    }

    override fun getCompoundPaddingLeft(): Int {
        return super.getCompoundPaddingLeft()+ mPrefixRect.width()
    }
}