package com.calyrsoft.ucbp1.features.registro.domain.usecase

import com.calyrsoft.ucbp1.core.common.Result
import com.calyrsoft.ucbp1.features.registro.domain.repository.IRegisterRepository
import com.calyrsoft.ucbp1.features.user.domain.model.User

class RegisterUseCase(private val repository: IRegisterRepository) {
    suspend operator fun invoke(email: String, password: String): Result<User> {
        return repository.register(email, password)
    }
}
