package com.calyrsoft.ucbp1.features.registro.domain.repository

import com.calyrsoft.ucbp1.core.common.Result
import com.calyrsoft.ucbp1.features.user.domain.model.User

interface IRegisterRepository {
    suspend fun register(email: String, password: String): Result<User>
}
