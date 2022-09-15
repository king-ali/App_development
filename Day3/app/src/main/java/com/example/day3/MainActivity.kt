package com.example.day3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        var textView = findViewById<TextView>(R.id.tvtext)
        var btn = findViewById<Button>(R.id.tvbtn)

//        textView.text = count.toString()
        textView.text = viewModel.count.toString()

        btn.setOnClickListener {
//            count++
//            textView.text = count.toString()
            viewModel.updateCount()
            textView.text = viewModel.count.toString()
        }



    }
}