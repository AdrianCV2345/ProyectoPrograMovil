package com.calyrsoft.ucbp1.features.registro.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegistroViewModel {
    private val _ci = MutableStateFlow("")
    val ci: StateFlow<String> = _ci
    private val _nombre = MutableStateFlow("")
    val nombre: StateFlow<String> = _nombre
    private val _gmail = MutableStateFlow("")
    val gmail: StateFlow<String> = _gmail
    private val _fechaNacimiento = MutableStateFlow("")
    val fechaNacimiento: StateFlow<String> = _fechaNacimiento
    private val _genero = MutableStateFlow("")
    val genero: StateFlow<String> = _genero
    private val _ciudad = MutableStateFlow("")
    val ciudad: StateFlow<String> = _ciudad
    private val _usuario = MutableStateFlow("")
    val usuario: StateFlow<String> = _usuario
    private val _contrasena = MutableStateFlow("")
    val contrasena: StateFlow<String> = _contrasena

    fun onCiChange(value: String) { _ci.value = value }
    fun onNombreChange(value: String) { _nombre.value = value }
    fun onGmailChange(value: String) { _gmail.value = value }
    fun onFechaNacimientoChange(value: String) { _fechaNacimiento.value = value }
    fun onGeneroChange(value: String) { _genero.value = value }
    fun onCiudadChange(value: String) { _ciudad.value = value }
    fun onUsuarioChange(value: String) { _usuario.value = value }
    fun onContrasenaChange(value: String) { _contrasena.value = value }
    fun onOrdenarClick() {
        // Aquí va la lógica de registro
    }
}