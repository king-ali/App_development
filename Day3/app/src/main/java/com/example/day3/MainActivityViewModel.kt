package com.example.day3

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var count = 0

    fun updateCount(){
        count++
    }

}