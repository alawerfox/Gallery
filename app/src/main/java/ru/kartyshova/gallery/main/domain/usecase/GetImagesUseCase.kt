package ru.kartyshova.gallery.main.domain.usecase

import ru.kartyshova.gallery.main.domain.model.GalleryItem
import ru.kartyshova.gallery.main.domain.repository.GalleryRepository

class GetImagesUseCase(
    private val galleryRepository: GalleryRepository
)  {

    suspend operator fun invoke(): Result<List<GalleryItem>> {
        return runCatching {
            galleryRepository.getImages()

        }
    }
}