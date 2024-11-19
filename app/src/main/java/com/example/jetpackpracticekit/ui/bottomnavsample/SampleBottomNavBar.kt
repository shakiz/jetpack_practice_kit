package com.example.jetpackpracticekit.ui.bottomnavsample

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController, bottomNavItems: List<BottomNavItem>) {
    NavigationBar {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        bottomNavItems.forEach {
            NavigationBarItem(
                label = {
                    Text(it.name)
                },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = ""
                    )
                },
                selected = currentRoute == it.route,
                onClick = {
                    if (currentRoute != it.route){
                        navController.navigate(it.route)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = Color.Gray,
                    selectedTextColor = Color.Black,
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Black,
                    indicatorColor = Color.White
                ),
            )
        }
    }
}