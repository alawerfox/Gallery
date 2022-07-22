package ru.kartyshova.gallery.main.domain.model

data class LoginRequest(
    val phone: String,
    val password: String
)