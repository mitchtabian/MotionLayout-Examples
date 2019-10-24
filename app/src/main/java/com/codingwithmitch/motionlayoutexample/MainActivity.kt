package com.codingwithmitch.motionlayoutexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coordinateMotion()
    }

    private fun coordinateMotion() {
        val appBarLayout: AppBarLayout = findViewById(R.id.appbar_layout)
        val motionLayout: MotionLayout = findViewById(R.id.motion_layout)

        val listener = AppBarLayout.OnOffsetChangedListener { unused, verticalOffset ->
            val seekPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            motionLayout.progress = seekPosition
        }

        appBarLayout.addOnOffsetChangedListener(listener)
    }
}



















