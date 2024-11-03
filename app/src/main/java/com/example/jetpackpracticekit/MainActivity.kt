package com.example.jetpackpracticekit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackpracticekit.ui.buttonexample.ButtonExampleScreen
import com.example.jetpackpracticekit.ui.contextualinfosample.ContextualInfoScreen
import com.example.jetpackpracticekit.ui.layoutsample.LayoutSampleScreen
import com.example.jetpackpracticekit.ui.mediaandloadingsample.MediaAndLoadingScreen
import com.example.jetpackpracticekit.ui.richuisample.RichUILayoutScreen
import com.example.jetpackpracticekit.ui.textsample.TextSampleScreen
import com.example.jetpackpracticekit.ui.typographysample.TypographySampleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") { MainScreen(navController) }
        composable("layoutSampleScreen") { LayoutSampleScreen() }
        composable("textFieldsScreen") { TextSampleScreen() }
        composable("buttonScreen") { ButtonExampleScreen() }
        composable("typographyScreen") { TypographySampleScreen() }
        composable("mediaAndLoadingScreen") { MediaAndLoadingScreen() }
        composable("contextualInfoScreen") { ContextualInfoScreen() }
        composable("richUILayoutScreen") { RichUILayoutScreen() }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyAppBar(title = "Jetpack UI Practice Kit", onBackPressed = { navController.popBackStack() })
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
    }
}