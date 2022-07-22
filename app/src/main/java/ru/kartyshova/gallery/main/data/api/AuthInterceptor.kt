package ru.kartyshova.gallery.main.data.api

import okhttp3.Interceptor
import okhttp3.Response
import ru.kartyshova.gallery.main.domain.repository.SecurityRepository
import ru.kartyshova.gallery.main.domain.repository.TokenRepository

class AuthInterceptor(
    private val tokenRepository: TokenRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url.toString()
        if (url.endsWith("login")) {
            return chain.proceed(chain.request())
        }

        val token = tokenRepository.getToken()
        val newRequest = request.newBuilder()
            .addHeader("Authorization", "Token $token")
            .build()

        return chain.proceed(newRequest)
    }
}