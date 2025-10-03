package com.calyrsoft.ucbp1.features.loginPart.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginPartViewModel {
    private val _usuario = MutableStateFlow("")
    val usuario: StateFlow<String> = _usuario

    private val _contrasena = MutableStateFlow("")
    val contrasena: StateFlow<String> = _contrasena

    fun onUsuarioChange(newUsuario: String) {
        _usuario.value = newUsuario
    }

    fun onContrasenaChange(newContrasena: String) {
        _contrasena.value = newContrasena
    }

    fun onLoginClick() {
        // Aquí puedes conectar con la lógica de login
    }
}