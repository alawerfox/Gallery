package ru.kartyshova.gallery.main.domain.usecase

import ru.kartyshova.gallery.main.domain.repository.SecurityRepository

class LoginParam(
    val phone: String,
    val password: String
)

class LoginUseCase(
    private val securityRepository: SecurityRepository
) {
    suspend operator fun invoke(param: LoginParam): Result<Boolean> {
        return runCatching {
            securityRepository.login(param.phone, param.password)
        }
    }
}