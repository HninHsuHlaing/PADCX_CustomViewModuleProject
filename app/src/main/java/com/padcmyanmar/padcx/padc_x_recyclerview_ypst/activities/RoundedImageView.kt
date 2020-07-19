package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.Components.EmotionalFaceView
import kotlinx.android.synthetic.main.activity_rounded_image_view.*

class RoundedImageView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rounded_image_view)

//        happyButton.setOnClickListener {
//            emotionalFaceView.happinessState = EmotionalFaceView.HAPPY
//        }
//        sadButton.setOnClickListener {
//            emotionalFaceView.happinessState = EmotionalFaceView.SAD
//        }
    }

}
