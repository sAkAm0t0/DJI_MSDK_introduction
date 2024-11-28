package com.example.msdksample

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.msdksample.src.autoControl

class MainActivity : AppCompatActivity() {
    private val control = autoControl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val takeoffButton = findViewById<Button>(R.id.ctrl_button)
        val landingButton = findViewById<Button>(R.id.landing_button)
        val rotatingButton = findViewById<Button>(R.id.rotating_button)
        val text = findViewById<TextView>(R.id.text)

        takeoffButton.setOnClickListener {
            text.text = "clicked."
            control.takeoff()
            text.text = "done."
        }

        landingButton.setOnClickListener {
            control.landing()
        }

        rotatingButton.setOnClickListener {
            control.rotating()
        }
    }
}