package com.karumi.magiccounterkataandroid

import android.content.Context
import android.content.Context.MODE_PRIVATE

interface CounterStorage {
    fun save(value: Int)
    fun get(): Int?
    fun clear()
}

class AndroidCounterStorage(private val context: Context) : CounterStorage {
    companion object {
        private const val preferencesFileName = "CounterStorage"
        private const val counterKey = "CounterStorage_counter"
    }

    private val preferences = context.getSharedPreferences(preferencesFileName, MODE_PRIVATE)

    override fun save(value: Int) = preferences.edit().putInt(counterKey, value).apply()

    override fun get(): Int? = if (preferences.contains(counterKey)) {
        preferences.getInt(counterKey, 0)
    } else {
        null
    }

    override fun clear() = preferences.edit().remove(counterKey).apply()
}
