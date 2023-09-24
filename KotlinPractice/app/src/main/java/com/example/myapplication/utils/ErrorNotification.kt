package com.example.myapplication.utils

import android.content.Context
import android.widget.Toast

fun showErrorDiscription(context: Context, errorCode: Int) {
    when (errorCode) {
        400 -> showToast(context, "Bad Request")
        401 -> showToast(context, "Unauthorized")
        403 -> showToast(context, "Forbidden")
        404 -> showToast(context, "Not Found")
        500 -> showToast(context, "Internal Server Error")
        503 -> showToast(context, "Service Unavailable")
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}