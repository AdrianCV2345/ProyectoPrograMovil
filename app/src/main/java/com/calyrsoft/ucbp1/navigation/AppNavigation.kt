package com.calyrsoft.ucbp1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.calyrsoft.ucbp1.features.login.presentation.LoginScreen
import com.calyrsoft.ucbp1.features.login.presentation.LoginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.calyrsoft.ucbp1.features.login.presentation.SplashScreen.SplashScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route // Inicia en el SplashScreen
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(onNavigate = {
                navController.navigate(Screen.Login.route) {
                    // Limpia el stack para que el usuario no pueda volver al SplashScreen
                    popUpTo(Screen.SplashScreen.route) { inclusive = true }
                }
            })
        }

        composable(Screen.Login.route) {
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(
                navController = navController,
                viewModel = loginViewModel
            )
        }
        composable(Screen.LoginPart.route) {
            val loginPartViewModel = com.calyrsoft.ucbp1.features.loginPart.presentation.LoginPartViewModel()
            com.calyrsoft.ucbp1.features.loginPart.presentation.LoginPartScreen(viewModel = loginPartViewModel)
        }
        composable(Screen.Home.route) {

        }


        composable(Screen.Registro.route) {
            val registroViewModel = com.calyrsoft.ucbp1.features.registro.presentation.RegistroViewModel()
            com.calyrsoft.ucbp1.features.registro.presentation.RegistroScreen(viewModel = registroViewModel)
        }
        composable(Screen.Menu.route) {
            val menuViewModel = com.calyrsoft.ucbp1.features.menu.presentation.MenuViewModel()
            com.calyrsoft.ucbp1.features.menu.presentation.MenuScreen(viewModel = menuViewModel)
        }
    }
}