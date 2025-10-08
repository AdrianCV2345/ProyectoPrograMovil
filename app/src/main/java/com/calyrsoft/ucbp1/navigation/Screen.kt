package com.calyrsoft.ucbp1.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object LoginPart : Screen("loginPart")
    object Home : Screen("home")
    object Profile : Screen("profile")
    object CardExamples : Screen("cardExamples")
    object Registro : Screen("registro")
    object Menu : Screen("menu")
}