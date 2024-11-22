package com.example.jetpackpracticekit.ui.bottomnavsample

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController

data class BottomNavItem(val name: String, val route: String, val icon: ImageVector)

enum class BottomNavRoutes {
    HOME,
    PROFILE,
    SETTINGS,
}

@Composable
fun BottomNavSampleScreen() {
    val navController = rememberNavController()
    var shouldShowBottomBar by remember { mutableStateOf(true) }

    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = BottomNavRoutes.HOME.name,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Profile",
            route = BottomNavRoutes.PROFILE.name,
            icon = Icons.Default.Person
        ),
        BottomNavItem(
            name = "Settings",
            route = BottomNavRoutes.SETTINGS.name,
            icon = Icons.Default.Settings
        ),
    )

    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar) {
                BottomNavigationBar(navController, bottomNavItems)
            }
        }
    ) { contentPadding ->
        MainNavigationConfigurations(navController, contentPadding, {
            shouldShowBottomBar = false
        })
    }
}
