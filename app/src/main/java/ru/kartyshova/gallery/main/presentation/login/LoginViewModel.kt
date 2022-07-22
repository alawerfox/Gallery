package ru.kartyshova.gallery.main.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import ru.kartyshova.gallery.main.domain.usecase.LoginParam
import ru.kartyshova.gallery.main.domain.usecase.LoginUseCase

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    val auth = MutableStateFlow(false)

    private var phone:String = ""
    private var password:String = ""

    fun updatePhone(value: String) {
        phone = "+7$value"
    }

    fun updatePassword(value: String) {
        password = value
    }

    fun login() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { loginUseCase(LoginParam(phone, password)) }
            result.onSuccess {
                auth.value = it
            }
            result.onFailure {
                Log.e("LoginViewModel", "Error", it)
            }
        }
    }
}
