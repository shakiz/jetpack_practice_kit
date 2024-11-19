package com.example.jetpackpracticekit.ui.bottomnavsample

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController

data class BottomNavItem(val name: String, val route: String, val icon: ImageVector)

enum class AppRouteConstants{
    HOME,
    PROFILE,
    SETTINGS,
}

@Composable
fun BottomNavSampleScreen() {
    val navController = rememberNavController()

    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = AppRouteConstants.HOME.name,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Profile",
            route = AppRouteConstants.PROFILE.name,
            icon = Icons.Default.Person
        ),
        BottomNavItem(
            name = "Settings",
            route = AppRouteConstants.SETTINGS.name,
            icon = Icons.Default.Settings
        ),
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, bottomNavItems) }
    ) { contentPadding ->
        MainNavigationConfigurations(navController, contentPadding)
    }
}
