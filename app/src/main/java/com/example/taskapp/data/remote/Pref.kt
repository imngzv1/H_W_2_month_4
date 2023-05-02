package com.example.taskapp.data.remote

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Pref(private val context: Context) {

    private val pref: SharedPreferences = context.getSharedPreferences("TaskPref", MODE_PRIVATE)
    fun IsUserSeen(): Boolean {
        return pref.getBoolean(USER_SEEN_KEY, false)
    }

    fun saveUserSeen() {
        pref.edit().putBoolean(USER_SEEN_KEY, true).apply()
    }


    fun getName(): String? {
        return pref.getString(PREF_SAVE_NAME, "")
    }

    fun saveName(title: String) {
        pref.edit().putString(PREF_SAVE_NAME, title).apply()
    }

    fun getImage(): String? {
        return pref.getString(PREF_IMAGE_PROFILE, "")
    }

    fun saveImage(image: String) {
        pref.edit().putString(PREF_IMAGE_PROFILE, image).apply()

    }

    companion object {
        private const val PREF_SAVE_NAME = "name"
        private const val PREF_IMAGE_PROFILE = "image"
        private const val USER_SEEN_KEY = "user.seen"

    }
}

