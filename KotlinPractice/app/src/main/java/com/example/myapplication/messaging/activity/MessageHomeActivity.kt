package com.example.myapplication.messaging.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMessageHomeBinding

class MessageHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessageHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}