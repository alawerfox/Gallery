package ru.kartyshova.gallery.main.presentation.gallery

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kartyshova.gallery.main.domain.repository.GalleryRepository
import ru.kartyshova.gallery.main.domain.usecase.GetImagesUseCase

val galleryModule = module {
    single { GalleryRepository(get()) }
    single { GetImagesUseCase(get())}
    viewModel { GalleryViewModel(get()) }
}