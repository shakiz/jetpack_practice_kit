package com.example.jetpackpracticekit.ui.bottomnavsample

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController, bottomNavItems: List<BottomNavItem>) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

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
                selected = currentDestination?.route == it.route,
                onClick = {
                    if (currentDestination?.route != it.route){
                        navController.navigate(it.route)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = Color.Gray,
                    selectedTextColor = Color.Black,
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Green,
                ),
            )
        }
    }
}