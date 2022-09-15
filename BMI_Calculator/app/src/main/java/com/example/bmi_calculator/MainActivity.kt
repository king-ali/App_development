package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val WeightText = findViewById<EditText>(R.id.etWeight)
        val HeightText = findViewById<EditText>(R.id.etHeight)
        val CalButton = findViewById<Button>(R.id.btncalculate)


        CalButton.setOnClickListener {
            val weight = WeightText.text.toString()
            val height = HeightText.text.toString()
            displayResult(weight, height)
//            if(validateimput(weight, height)){
////                val bmi = weight.toFloat()/((height.toFloat()*100)*(height.toFloat()*100))
////                val bmi2d = String.format("%.2f", bmi).toFloat()
////                var b = bmi2d.toFloat()
//                displayResult(weight, height)
//            }
        }

    }

    private fun validateimput(weight:String?, height:String?):Boolean {

        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_LONG).show()
                return false
            }
            else -> {
                return true
            }
        }

    }

    private fun displayResult(weight:String, height: String){
        val resultIndex = findViewById<TextView>(R.id.tvindex)
        val info = findViewById<TextView>(R.id.tvinfo)
        val h = height.toFloat() * 100
        val bmi = (weight.toFloat()/(h*h))*10

//        val bmi2d = String.format("%.2f", bmi).toFloat()
//        var b = bmi2d.toFloat()
        val b = bmi * 10
        resultIndex.text = b.toString()
        info.text = "( Normal range is 18.5 - 24.9 )"

    }

}