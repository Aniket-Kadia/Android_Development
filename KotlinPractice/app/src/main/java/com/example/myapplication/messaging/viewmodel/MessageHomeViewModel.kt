package com.example.myapplication.messaging.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageHomeViewModel: ViewModel() {
    var id = MutableLiveData<Int>()

    fun updateID(number: Int) {
        id.value = number
    }
}