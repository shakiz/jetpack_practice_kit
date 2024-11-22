package com.example.jetpackpracticekit.ui.bottomnavsample.sampleproduct

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackpracticekit.ui.bottomnavsample.bottomnavscreens.ProductNestedRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(nestedNavController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(16.dp,),
    ) {
        items(8){
            Card(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    nestedNavController.navigate(ProductNestedRoutes.CART.name)
                }
            ) {
                Text(text = "Product Sample", modifier = Modifier.padding(16.dp))
            }
        }
    }
}