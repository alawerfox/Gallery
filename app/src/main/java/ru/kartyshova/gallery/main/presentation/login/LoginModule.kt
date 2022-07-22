package ru.kartyshova.gallery.main.presentation.login

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kartyshova.gallery.main.domain.repository.SecurityRepository
import ru.kartyshova.gallery.main.domain.repository.TokenRepository
import ru.kartyshova.gallery.main.domain.usecase.LoginUseCase

val loginModule = module {
    single { SecurityRepository(get(),get()) }
    single { LoginUseCase(get()) }
    single { TokenRepository(get()) }
    viewModel { LoginViewModel(get()) }
}