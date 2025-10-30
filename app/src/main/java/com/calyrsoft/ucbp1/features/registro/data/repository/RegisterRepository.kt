package com.calyrsoft.ucbp1.features.registro.data.repository

import com.calyrsoft.ucbp1.core.common.Result
import com.calyrsoft.ucbp1.features.registro.data.source.local.IRegisterLocalDataSource
import com.calyrsoft.ucbp1.features.registro.data.source.remote.IRegisterRemoteDataSource
import com.calyrsoft.ucbp1.features.registro.domain.repository.IRegisterRepository
import com.calyrsoft.ucbp1.features.user.domain.model.User

class RegisterRepository(
    private val remoteDataSource: IRegisterRemoteDataSource,
    private val localDataSource: IRegisterLocalDataSource
) : IRegisterRepository {

    override suspend fun register(email: String, password: String): Result<User> {
        // 1. Intentamos registrar el usuario en el servicio remoto (Firebase)
        val remoteResult = remoteDataSource.register(email, password)

        // 2. Comprobamos si el registro remoto fue exitoso
        if (remoteResult is Result.Success) {
            // 3. Si fue exitoso, guardamos una copia del usuario en la base de datos local
            localDataSource.save(remoteResult.data)
        }

        // 4. Devolvemos el resultado de la operación remota (sea éxito o error)
        return remoteResult
    }
}
