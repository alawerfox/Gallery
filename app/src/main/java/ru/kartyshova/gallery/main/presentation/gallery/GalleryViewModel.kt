package ru.kartyshova.gallery.main.presentation.gallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import ru.kartyshova.gallery.main.domain.model.GalleryItem
import ru.kartyshova.gallery.main.domain.usecase.GetImagesUseCase
import ru.kartyshova.gallery.main.viewModel.GalleryImages

class GalleryViewModel(
    private val getImagesUseCase: GetImagesUseCase
): ViewModel() {
    val items = MutableStateFlow<List<GalleryItem>>(emptyList())

    fun load() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                getImagesUseCase()
            }

            response.onSuccess {
                items.value = it
            }.onFailure {
                Log.e("GalleryViewModel","error",it)
            }
        }
    }
}