package com.calyrsoft.ucbp1.features.registro.data.source.local

import com.calyrsoft.ucbp1.features.user.data.local.dao.UserDao
import com.calyrsoft.ucbp1.features.user.data.local.model.UserEntity
import com.calyrsoft.ucbp1.features.user.domain.model.User

class RegisterLocalDataSource(private val userDao: UserDao) : IRegisterLocalDataSource {
    override suspend fun save(user: User) {
        // Mapeamos el modelo de dominio al modelo de entidad de la BD
        val userEntity = UserEntity(
            userId = user.userId,
            email = user.email
        )
        userDao.insert(userEntity)
    }
}
