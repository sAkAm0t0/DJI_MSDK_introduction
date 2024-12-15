package com.example.msdksample

import android.os.Bundle
import android.widget.Button
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
        val movingButton = findViewById<Button>(R.id.moving_button)
        val rotatingmButton = findViewById<Button>(R.id.rotatingm_button)
        val movingmButton = findViewById<Button>(R.id.movingm_button)
        val enableVSButton = findViewById<Button>(R.id.enableVS_button)
        val disableVSButton = findViewById<Button>(R.id.disableVS_button)
        val stopButton = findViewById<Button>(R.id.stop_button)
       // val verticalPicker = findViewById<NumberPicker>(R.id.verticalPicker)
        //val horizontalPicker = findViewById<NumberPicker>(R.id.horizontalPicker)
        //val rotatePicker = findViewById<NumberPicker>(R.id.rotatingPicker)

        /*verticalPicker.maxValue = 100
        verticalPicker.minValue = -100
        verticalPicker.value = 0
        horizontalPicker.maxValue = 100
        horizontalPicker.minValue = -100
        horizontalPicker.value = 0
        rotatePicker.maxValue = 100
        rotatePicker.minValue = -100
        rotatePicker.value = 0*/
        //val text = findViewById<TextView>(R.id.text)

        takeoffButton.setOnClickListener {
            control.takeoff()
        }

        landingButton.setOnClickListener {
            control.landing()
        }

        rotatingButton.setOnClickListener {
            control.rotating(50)
        }

        rotatingmButton.setOnClickListener {
            control.rotating(-50)
        }

        movingButton.setOnClickListener {
            control.move(0, 20)
        }

        movingmButton.setOnClickListener {
            control.move(0, -20)
            control.rotating(50)
        }

        enableVSButton.setOnClickListener {
            control.enableVS()
        }

        disableVSButton.setOnClickListener {
            control.disableVS()
        }

        stopButton.setOnClickListener {
            control.stop()
        }
    }
}