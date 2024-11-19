package com.example.jetpackpracticekit.ui.bottomnavsample

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackpracticekit.ui.bottomnavsample.bottomnavscreens.HomeScreen
import com.example.jetpackpracticekit.ui.bottomnavsample.bottomnavscreens.ProfileScreen
import com.example.jetpackpracticekit.ui.bottomnavsample.bottomnavscreens.SettingScreen

@Composable
fun MainNavigationConfigurations(navController: NavHostController, contentPadding: PaddingValues) {
    NavHost(navController, startDestination = "home", modifier = Modifier.padding(contentPadding)) {
        composable(AppRouteConstants.HOME.name) { HomeScreen() }
        composable(AppRouteConstants.PROFILE.name) { ProfileScreen() }
        composable(AppRouteConstants.SETTINGS.name) { SettingScreen() }
    }
}