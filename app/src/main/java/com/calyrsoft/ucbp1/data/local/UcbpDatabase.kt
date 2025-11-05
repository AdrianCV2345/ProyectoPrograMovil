package com.calyrsoft.ucbp1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.calyrsoft.ucbp1.features.user.data.local.dao.UserDao
import com.calyrsoft.ucbp1.features.user.data.local.model.UserEntity

@Database(
    entities = [UserEntity::class], // <- Dejamos solo UserEntity
    version = 2, // <- Mantenemos la versión incrementada
    exportSchema = false
)
abstract class UcbpDatabase : RoomDatabase() {
    // abstract fun movieDao(): MovieDao // <- Eliminamos la referencia a movieDao
    abstract fun userDao(): UserDao
}
