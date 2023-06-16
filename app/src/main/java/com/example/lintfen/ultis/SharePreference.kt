package com.example.lintfen.ultis

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object SharePreference {

//    MARK: Keys
    const val IS_FIRST_TIME = "IS_FIRST_TIME"

//    MARK: To use
    fun sharePref(context: Context, name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.isFirstTime
        get() = getBoolean(IS_FIRST_TIME, false)
        set(value) {
            edit {
                it.putBoolean(IS_FIRST_TIME, value)
            }
        }

}