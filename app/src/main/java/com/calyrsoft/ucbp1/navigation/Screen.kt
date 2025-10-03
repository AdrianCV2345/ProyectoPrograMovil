package com.calyrsoft.ucbp1.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Profile: Screen("profile")
    object CardExamples: Screen("card")
    object Login: Screen("login") // Nueva ruta para login
}