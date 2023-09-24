package com.example.myapplication.uiwidgets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.myapplication.R

class StockAdapter(context: Context, private val stockList: Array<String>) :
    ArrayAdapter<String>(context, 0, stockList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, parent)
    }

    private fun initView(position: Int, parent: ViewGroup): View {
        val childView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_stock_spinner, parent, false)
        val name = childView.findViewById<TextView>(R.id.textViewStockName)
        name.text = stockList[position]
        return childView
    }
}