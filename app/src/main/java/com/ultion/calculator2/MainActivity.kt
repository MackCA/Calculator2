package com.ultion.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val orbitalRadiusTextBox = findViewById<EditText>(R.id.orbitalRadiusTextBox)
        val orbitalPeriodTextBox = findViewById<EditText>(R.id.orbitalPeriodTextBox)
        val responseTextView = findViewById<TextView>(R.id.responseTextView)

        calculateButton.setOnClickListener {
            val orbitalRadius = orbitalRadiusTextBox.text.toString().toDouble()  // Already in meters
            val orbitalPeriod = orbitalPeriodTextBox.text.toString().toDouble()
            val G = 6.67430e-11
            val astronomicalUnitInMeters = 1.496e+11
            val secondsInADay = 86400.0
            val a = orbitalRadius * astronomicalUnitInMeters
            val T = orbitalPeriod * secondsInADay
            val mass = (4 * Math.PI.pow(2) * a.pow(3)) / (G * T.pow(2))
            val roundedMass = "%.2e".format(mass).toDouble()
            responseTextView.text = "Mass of the Star: $roundedMass kg"

        }

        resetButton.setOnClickListener {
            orbitalRadiusTextBox.text.clear()
            orbitalPeriodTextBox.text.clear()
            responseTextView.text = ""
        }
    }
}