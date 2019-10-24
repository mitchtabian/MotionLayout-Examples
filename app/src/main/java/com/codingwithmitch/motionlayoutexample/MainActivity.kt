package com.codingwithmitch.motionlayoutexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val motionLayout: MotionLayout = findViewById(R.id.motionLayout)
        motionLayout.setTransitionListener(object: MotionLayout.TransitionListener{

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                Log.d("onTransitionTrigger", "$p1, $p2, $p3")
            }

            override fun allowsTransition(p0: MotionScene.Transition?): Boolean {
                return true
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                Log.d("onTransitionStarted", "$p1, $p2")
            }

            // p1 = end position
            // p2 = start position
            // p3 =  progress
            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                Log.d("onTransitionChange", "$p1, $p2, $p3")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                Log.d("onTransitionCompleted", "$p1")
            }

        })
    }
}
