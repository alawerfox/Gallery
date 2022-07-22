package ru.kartyshova.gallery.main.data.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.kartyshova.gallery.main.domain.model.GalleryItem
import ru.kartyshova.gallery.main.domain.model.LoginRequest
import ru.kartyshova.gallery.main.domain.model.LoginResponse

interface GalleryApi {

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("picture")
    suspend fun getImages():  List<GalleryItem>
}