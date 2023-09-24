package com.example.myapplication.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import com.example.myapplication.R

class StockExchangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock_exchange)
        setupView()
    }

    private fun setupView() {
        val spinner = findViewById<Spinner>(R.id.spinner_Stock)
        val spinnerReceive = findViewById<Spinner>(R.id.spinner_Stock2)
        val stockList = resources.getStringArray(R.array.stock_list)
        spinner.adapter = StockAdapter(this, stockList)
        spinnerReceive.adapter = StockAdapter(this, stockList)
    }
}