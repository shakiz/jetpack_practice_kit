package com.example.jetpackpracticekit.ui.navgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackpracticekit.ui.bottomnavsample.BottomNavSampleScreen
import com.example.jetpackpracticekit.ui.buttonexample.ButtonExampleScreen
import com.example.jetpackpracticekit.ui.contextualinfosample.ContextualInfoScreen
import com.example.jetpackpracticekit.ui.layoutsample.LayoutSampleScreen
import com.example.jetpackpracticekit.ui.main.AllUISampleScreen
import com.example.jetpackpracticekit.ui.mediaandloadingsample.MediaAndLoadingScreen
import com.example.jetpackpracticekit.ui.mvvm.MVVMSampleScreen
import com.example.jetpackpracticekit.ui.richuisample.RichUILayoutScreen
import com.example.jetpackpracticekit.ui.textsample.TextSampleScreen
import com.example.jetpackpracticekit.ui.typographysample.TypographySampleScreen

@Composable
fun UiSamplesNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "allUISampleScreen") {
        composable("allUISampleScreen") { AllUISampleScreen(navController) }
        composable("layoutSampleScreen") { LayoutSampleScreen() }
        composable("textFieldsScreen") { TextSampleScreen() }
        composable("buttonScreen") { ButtonExampleScreen() }
        composable("typographyScreen") { TypographySampleScreen() }
        composable("mediaAndLoadingScreen") { MediaAndLoadingScreen() }
        composable("contextualInfoScreen") { ContextualInfoScreen() }
        composable("richUILayoutScreen") { RichUILayoutScreen() }
        composable("mVVMSampleScreen") { MVVMSampleScreen() }
        composable("bottomNavigationComponent") { BottomNavSampleScreen() }
    }
}