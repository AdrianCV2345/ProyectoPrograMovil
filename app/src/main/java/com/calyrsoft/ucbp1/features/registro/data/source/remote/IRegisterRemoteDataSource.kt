package com.calyrsoft.ucbp1.features.registro.data.source.remote

import com.calyrsoft.ucbp1.core.common.Result
import com.calyrsoft.ucbp1.features.user.domain.model.User

interface IRegisterRemoteDataSource {
    suspend fun register(email: String, password: String): Result<User>
}
