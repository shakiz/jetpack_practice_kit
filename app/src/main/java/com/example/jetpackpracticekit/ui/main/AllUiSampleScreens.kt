package com.example.jetpackpracticekit.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AllUISampleScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MyAppBar(
                title = "Jetpack UI Practice Kit",
                onBackPressed = { navController.popBackStack() })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(1.dp))
            Button(onClick = { navController.navigate("layoutSampleScreen") }) {
                Text("Go to Layouts Screen")
            }
            Button(onClick = { navController.navigate("textFieldsScreen") }) {
                Text("Go to Text Fields Screen")
            }
            Button(onClick = { navController.navigate("buttonScreen") }) {
                Text("Go to Button Screen")
            }
            Button(onClick = { navController.navigate("typographyScreen") }) {
                Text("Go to Typography Screen")
            }
            Button(onClick = { navController.navigate("mediaAndLoadingScreen") }) {
                Text("Go to Media and Loading Screen")
            }
            Button(onClick = { navController.navigate("contextualInfoScreen") }) {
                Text("Go to Dialog and Popup Screen")
            }
            Button(onClick = { navController.navigate("richUILayoutScreen") }) {
                Text("Go to Rich UI Screen")
            }
            Button(onClick = { navController.navigate("mVVMSampleScreen") }) {
                Text("Go to MVVM Screen")
            }
            Button(onClick = { navController.navigate("bottomNavigationComponent") }) {
                Text("Go to Bottom Nav Sample Screen")
            }
        }
    }
}