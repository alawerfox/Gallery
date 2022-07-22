package ru.kartyshova.gallery.main.domain.repository

import android.content.Context
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class TokenRepository(
    context: Context
) {
    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getToken(): String {
        return sharedPreferences.getString(TOKEN_KEY, null) ?: ""
    }

    fun setToken(value:String){
        sharedPreferences.edit {
            putString(TOKEN_KEY, value)
            // TODO сохранить userInfo
        }
    }

    private companion object {
        const val TOKEN_KEY = "token"
    }
}