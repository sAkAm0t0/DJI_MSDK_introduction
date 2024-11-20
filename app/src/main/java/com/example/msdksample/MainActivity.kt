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
        val text = findViewById<TextView>(R.id.text)

        takeoffButton.setOnClickListener {
            text.text = "clicked."
            control.init()
            text.text = "done."
        }
    }
}