package ru.kartyshova.gallery.main.domain.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.kartyshova.gallery.main.data.api.GalleryApi
import ru.kartyshova.gallery.main.domain.model.GalleryItem

class GalleryRepository(
    private val galleryApi: GalleryApi
) {
    suspend fun getImages(): List<GalleryItem> {
        return galleryApi.getImages()
    }
}