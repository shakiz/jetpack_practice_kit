package com.example.jetpackpracticekit.ui.main

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
import com.example.jetpackpracticekit.ui.auth.LoginScreen
import com.example.jetpackpracticekit.ui.bottomnavsample.BottomNavSampleScreen
import com.example.jetpackpracticekit.ui.buttonexample.ButtonExampleScreen
import com.example.jetpackpracticekit.ui.contextualinfosample.ContextualInfoScreen
import com.example.jetpackpracticekit.ui.layoutsample.LayoutSampleScreen
import com.example.jetpackpracticekit.ui.mediaandloadingsample.MediaAndLoadingScreen
import com.example.jetpackpracticekit.ui.mvvm.MVVMSampleScreen
import com.example.jetpackpracticekit.ui.navgraphs.AuthNavGraph
import com.example.jetpackpracticekit.ui.richuisample.RichUILayoutScreen
import com.example.jetpackpracticekit.ui.textsample.TextSampleScreen
import com.example.jetpackpracticekit.ui.typographysample.TypographySampleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthNavGraph()
        }
    }
}