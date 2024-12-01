package com.example.jetpackpracticekit.ui.bottomnavsample

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController
import com.example.jetpackpracticekit.ui.main.MyAppBar

data class BottomNavItem(val name: String, val route: String, val icon: ImageVector)

enum class BottomNavRoutes {
    HOME,
    PROFILE,
    SETTINGS,
}

@Composable
fun BottomNavSampleScreen() {
    val navController = rememberNavController()
    //var shouldShowBottomBar by remember { mutableStateOf(true) }

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
        topBar = {
            MyAppBar(
                title = "Jetpack UI Practice Kit",
                onBackPressed = { navController.popBackStack() })
        },
        bottomBar = {
            //if (shouldShowBottomBar) {
                BottomNavigationBar(navController, bottomNavItems)
            //}
        }
    ) { contentPadding ->
        MainNavigationConfigurations(navController, contentPadding, {
            //shouldShowBottomBar = false
        })
    }
}
