package com.example.jetpackpracticekit.ui.navgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackpracticekit.ui.auth.LoginScreen
import com.example.jetpackpracticekit.ui.auth.RegistrationScreen

enum class AuthNavGraphRoutes {
    LOGIN,
    REGISTER
}

@Composable
fun AuthNavGraph() {
    val authNavController = rememberNavController()

    NavHost(authNavController, startDestination = AuthNavGraphRoutes.LOGIN.name) {
        composable(AuthNavGraphRoutes.LOGIN.name) {
            LoginScreen(onLoginClick = { email, password ->
                authNavController.navigate("UiSamplesNavigation")
            }, onRegisterClick = { authNavController.navigate(AuthNavGraphRoutes.REGISTER.name) })
        }
        composable(AuthNavGraphRoutes.REGISTER.name) {
            RegistrationScreen(
                onRegisterClick = { name, email, password -> },
                onBackToLoginClick = { authNavController.popBackStack() })
        }
        composable("UiSamplesNavigation") {
            UiSamplesNavGraph()
        }
    }
}