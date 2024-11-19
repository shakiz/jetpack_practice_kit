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

@Composable
fun BottomNavSampleScreen() {
    val navController = rememberNavController()

    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Profile",
            route = "profile",
            icon = Icons.Default.Person
        ),
        BottomNavItem(
            name = "Settings",
            route = "settings",
            icon = Icons.Default.Settings
        ),
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, bottomNavItems) }
    ) { contentPadding ->
        MainNavigationConfigurations(navController, contentPadding)
    }
}
