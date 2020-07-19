package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.Components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R
import java.util.Collections.min
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin


private enum class FanSpeed(val label :Int) {
    OFF (R.string.fan_off),
    LOW (R.string.fan_low),
    MEDIUM (R.string.fan_medium),
    HIGH (R.string.fan_height);
}

private const val RADIUS_OFFSET_LABEL = 30
private const val RADIUS_OFFSET_INDICATOR = -35

private var radius = 0.0f
private var fanspeed = FanSpeed.OFF

private val pointPosition :PointF = PointF(0.0f,0.0f)



class DialView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {

        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("",Typeface.BOLD)

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = (min(width,height)/2.0 * 0.8).toFloat()
    }
    private fun PointF.computeXYForSpeed(pos : FanSpeed , radius : Float){
        pos.ordinal
        val startAngle = Math.PI * (9/8.0)
        val angle = startAngle + pos.ordinal * (Math.PI /4)
        x = (radius * cos(angle).toFloat())  + width/2
        y = (radius * sin (angle).toFloat()) + height/2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawBackground(canvas)
        
        drawIndicatorCircle(canvas)
        
        drawlabelText(canvas)
    }

    private fun drawIndicatorCircle(canvas: Canvas) {
        val markerRadius = radius + RADIUS_OFFSET_INDICATOR

        pointPosition.computeXYForSpeed(fanspeed, markerRadius)

        paint.color = Color.BLACK
        canvas.drawCircle(pointPosition.x, pointPosition.y, radius/12, paint)
    }

    private fun drawlabelText(canvas: Canvas) {

        val labelRadius = radius + RADIUS_OFFSET_LABEL

        for( i in FanSpeed.values()){
            pointPosition.computeXYForSpeed(i, labelRadius)
            val label = resources.getString(i.label)
            canvas.drawText(label, pointPosition.x , pointPosition.y,paint)
        }
    }

    private fun drawBackground(canvas: Canvas) {
        paint.color = if(fanspeed == FanSpeed.OFF) Color.GRAY else Color.GREEN

        canvas.drawCircle((width/2).toFloat(),(height/2).toFloat(), radius,paint)

    }

}
