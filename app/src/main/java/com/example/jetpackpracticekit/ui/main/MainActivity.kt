package com.example.jetpackpracticekit.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.jetpackpracticekit.ui.navgraphs.AuthNavGraph
import com.example.jetpackpracticekit.ui.navgraphs.UiSamplesNavGraph
import com.example.jetpackpracticekit.ui.theme.JetPackPracticeKitTheme
import com.example.jetpackpracticekit.utils.PrefManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashscreen = installSplashScreen()
        var keepSplashScreen = true
        super.onCreate(savedInstanceState)
        val preferencesManager = PrefManager(this)
        splashscreen.setKeepOnScreenCondition { keepSplashScreen }
        enableEdgeToEdge()
        lifecycleScope.launch {
            delay(200)
            keepSplashScreen = false
            val isLoggedIn = preferencesManager.getBooleanValue("isLoggedIn", false)
            if (isLoggedIn) {
                setContent {
                    JetPackPracticeKitTheme {
                        UiSamplesNavGraph()
                    }
                }
            } else {
                setContent {
                    JetPackPracticeKitTheme {
                        AuthNavGraph()
                    }
                }
            }
        }
    }
}