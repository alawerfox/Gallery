package ru.kartyshova.gallery.main.domain.repository

import android.content.Context
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import ru.kartyshova.gallery.main.data.api.GalleryApi
import ru.kartyshova.gallery.main.domain.model.LoginRequest
import ru.kartyshova.gallery.main.domain.model.UserInfo

class SecurityRepository(
    private val galleryApi: GalleryApi,

    private val tokenRepository: TokenRepository

) {

    suspend fun login(phone:String, password:String): Boolean {
        val response = galleryApi.login(LoginRequest(phone, password))

      tokenRepository.setToken(response.token)

        return true
    }

    fun logout() {
        TODO("not implemented")
    }

    fun getUserInfo(): UserInfo {
        TODO("not implemented")
    }

    private companion object {
        const val TOKEN_KEY = "token"
    }
}