package com.example.jetpackpracticekit.ui.mediaandloadingsample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackpracticekit.R
import com.example.jetpackpracticekit.ui.main.MyAppBar

@Composable
fun MediaAndLoadingScreen(navController: NavController) {
    var isLoading by remember { mutableStateOf(true) }
    var progress by remember { mutableStateOf(0.3f) } // Example progress state

    Scaffold(topBar = {
        MyAppBar(
            title = "Media and Loading Sample",
            Icons.Filled.ArrowBack,
            onBackPressed = { navController.popBackStack() })
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image with painterResource and content description
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with your drawable resource
                contentDescription = "Sample Image",
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )

            // Icon example using a Material Icon from the Icons library
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorite Icon",
                tint = Color.Red,
                modifier = Modifier.size(40.dp)
            )

            // CircularProgressIndicator for showing loading state
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp),
                    color = Color.Blue,
                    strokeWidth = 4.dp
                )
            }

            // LinearProgressIndicator for showing progress, here with a sample value
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Color.Green,
                trackColor = Color.LightGray
            )

            // Button to toggle loading state
            Button(onClick = { isLoading = !isLoading }) {
                Text(text = if (isLoading) "Hide Loading" else "Show Loading")
            }

            // Button to increase progress for LinearProgressIndicator
            Button(onClick = { progress = (progress + 0.1f).coerceAtMost(1f) }) {
                Text(text = "Increase Progress")
            }
        }
    }
}
