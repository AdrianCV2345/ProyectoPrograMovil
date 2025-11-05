package com.calyrsoft.ucbp1.di

import androidx.room.Room
import com.calyrsoft.ucbp1.R
import com.calyrsoft.ucbp1.data.local.UcbpDatabase
import com.calyrsoft.ucbp1.features.loginPart.data.LoginPartRepository
import com.calyrsoft.ucbp1.features.loginPart.domain.LoginPartUseCase
import com.calyrsoft.ucbp1.features.loginPart.presentation.LoginPartViewModel
import com.calyrsoft.ucbp1.features.menu.presentation.MenuViewModel
import com.calyrsoft.ucbp1.features.registro.data.repository.RegisterRepository
import com.calyrsoft.ucbp1.features.registro.data.source.local.IRegisterLocalDataSource
import com.calyrsoft.ucbp1.features.registro.data.source.local.RegisterLocalDataSource
import com.calyrsoft.ucbp1.features.registro.data.source.remote.IRegisterRemoteDataSource
import com.calyrsoft.ucbp1.features.registro.data.source.remote.RegisterRemoteDataSource
import com.calyrsoft.ucbp1.features.registro.domain.repository.IRegisterRepository
import com.calyrsoft.ucbp1.features.registro.domain.usecase.RegisterUseCase
import com.calyrsoft.ucbp1.features.registro.presentation.RegistroViewModel
import com.google.firebase.auth.FirebaseAuth
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkConstants {
    const val RETROFIT_GITHUB = "RetrofitGithub"
    const val GITHUB_BASE_URL = "https://api.github.com/"
    const val RETROFIT_MOVIE = "RetrofitMovie"
    const val MOVIE_BASE_URL = "https://api.themoviedb.org/"
}

val appModule = module {

    // OkHttpClient
    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    // Retrofit
    single(named(NetworkConstants.RETROFIT_GITHUB)) {
        Retrofit.Builder()
            .baseUrl(NetworkConstants.GITHUB_BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single(named(NetworkConstants.RETROFIT_MOVIE)) {
        Retrofit.Builder()
            .baseUrl(NetworkConstants.MOVIE_BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single(named("apiKey")) {
        androidApplication().getString(R.string.api_key)
    }

    // Configuración de la Base de Datos Room
    single {
        Room.databaseBuilder(androidApplication(), UcbpDatabase::class.java, "ucbp-db")
            .fallbackToDestructiveMigration() // Opcional: útil en desarrollo
            .build()
    }

    // --- Flujo de Registro ---

    // Firebase
    single { FirebaseAuth.getInstance() }

    // DAOs
    single { get<UcbpDatabase>().userDao() }

    // DataSources
    single<IRegisterRemoteDataSource> { RegisterRemoteDataSource(get()) }
    single<IRegisterLocalDataSource> { RegisterLocalDataSource(get()) }

    // Repositorio
    single<IRegisterRepository> { RegisterRepository(get(), get()) }

    // Casos de Uso
    single { RegisterUseCase(get()) }

    // ViewModel
    viewModel { RegistroViewModel(get()) }

    // --- Flujo de Login Part ---

    // Repositorio
    single { LoginPartRepository(get()) }

    // Casos de Uso
    single { LoginPartUseCase(get()) }

    // ViewModel
    viewModel { LoginPartViewModel(get()) }

    // --- Flujo de Menu ---
    viewModel { MenuViewModel() }
}
