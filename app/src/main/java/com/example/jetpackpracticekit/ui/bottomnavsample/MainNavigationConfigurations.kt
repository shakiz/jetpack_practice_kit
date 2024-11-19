package com.example.jetpackpracticekit.ui.bottomnavsample

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackpracticekit.ui.bottomnavsample.screens.HomeScreen
import com.example.jetpackpracticekit.ui.bottomnavsample.screens.ProfileScreen
import com.example.jetpackpracticekit.ui.bottomnavsample.screens.SettingScreen

@Composable
fun MainNavigationConfigurations(navController: NavHostController, contentPadding: PaddingValues) {
    NavHost(navController, startDestination = "home") {
        composable(AppRouteConstants.HOME.name) { HomeScreen() }
        composable(AppRouteConstants.PROFILE.name) { ProfileScreen() }
        composable(AppRouteConstants.SETTINGS.name) { SettingScreen() }
    }
}