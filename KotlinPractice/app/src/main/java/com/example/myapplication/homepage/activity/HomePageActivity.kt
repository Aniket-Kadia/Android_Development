package com.example.myapplication.homepage.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHomePageBinding
import com.example.myapplication.intent.activity.CompanyFeedbackActivity
import com.example.myapplication.intent.activity.SenderActivity
import com.example.myapplication.messaging.activity.MessageHomeActivity
import com.example.myapplication.uiwidgets.StockExchangeActivity
import com.example.myapplication.utils.Constants
import com.example.myapplication.utils.PreferenceManager

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setupView()
        setContentView(binding.root)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            currentFocus?.clearFocus()
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun setupView() {
        binding.textUsername.text =
            "Welcome ${PreferenceManager.getPreference(applicationContext, Constants.KEY_USERNAME)}"

        binding.btnStockExchange.setOnClickListener {
            startActivity(Intent(applicationContext, StockExchangeActivity::class.java))
        }

        binding.btnIntent.setOnClickListener {
            startActivity(Intent(applicationContext, CompanyFeedbackActivity::class.java))
        }

        binding.btnDataPass.setOnClickListener {
            startActivity(Intent(applicationContext, SenderActivity::class.java))
        }

        binding.btnMessagingScreen.setOnClickListener {
            startActivity(Intent(applicationContext,MessageHomeActivity::class.java))
        }
    }
}