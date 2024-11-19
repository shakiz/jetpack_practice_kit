package com.example.jetpackpracticekit.ui.bottomnavsample.bottomnavscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackpracticekit.ui.bottomnavsample.BottomNavRoutes
import com.example.jetpackpracticekit.ui.bottomnavsample.sampleproduct.CartScreen
import com.example.jetpackpracticekit.ui.bottomnavsample.sampleproduct.ProductScreen
import com.example.jetpackpracticekit.ui.bottomnavsample.sampleproduct.SuccessScreen

enum class ProductNestedRoutes {
    PRODUCT,
    CART,
    SUCCESS
}

@Composable
fun HomeScreen(onProductClicked: () -> Unit) {
    val nestedNavController = rememberNavController()

    NavHost(nestedNavController, startDestination = BottomNavRoutes.HOME.name) {
        composable(BottomNavRoutes.HOME.name) {
            HomeScreenContent {
                onProductClicked()
                nestedNavController.navigate(ProductNestedRoutes.PRODUCT.name)
            }
        }
        composable(ProductNestedRoutes.PRODUCT.name) { ProductScreen(nestedNavController) }
        composable(ProductNestedRoutes.CART.name) { CartScreen(nestedNavController) }
        composable(ProductNestedRoutes.SUCCESS.name) { SuccessScreen(nestedNavController) }
    }
}

@Composable
fun HomeScreenContent(onNavigateToProductFlow: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onNavigateToProductFlow) {
            Text("Buy More")
        }
    }
}