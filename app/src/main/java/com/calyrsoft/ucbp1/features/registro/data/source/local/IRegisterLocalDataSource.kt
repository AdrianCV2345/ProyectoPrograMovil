package com.calyrsoft.ucbp1.features.registro.data.source.local

import com.calyrsoft.ucbp1.features.user.domain.model.User

interface IRegisterLocalDataSource {
    suspend fun save(user: User)
}
