package com.example.myapplication.utils

fun validateEmail(email: String?): Boolean {
    return if (email.isNullOrEmpty()) {
        false
    } else {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}