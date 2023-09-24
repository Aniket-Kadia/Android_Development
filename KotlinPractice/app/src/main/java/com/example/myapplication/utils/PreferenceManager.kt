package com.example.myapplication.utils

import android.content.Context

object PreferenceManager {
    private const val PREF_NAME = "SharedPreference"

    fun setPreference(context: Context, tokenIdentifier: String, value: String) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
            .putString(tokenIdentifier, value).apply()
    }

    fun getPreference(context: Context, tokenIdentifier: String): String? {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(tokenIdentifier, null)
    }
}