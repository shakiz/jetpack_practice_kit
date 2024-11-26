package com.example.jetpackpracticekit.utils

import android.content.Context

class PrefManager(context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences("jetpack_practice_kit", Context.MODE_PRIVATE)

    fun getBooleanValue(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun getStringValue(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun putBooleanValue(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun putStringValue(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }
}