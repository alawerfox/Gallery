package ru.kartyshova.gallery.main.domain.model

data class LoginResponse(
    val token: String,
    val userInfo: UserInfo
)

data class UserInfo(
    val id: String,
    val phone: String,
    val email: String,
    val city: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val about: String
)