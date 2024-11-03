package com.example.jetpackpracticekit.ui.layoutsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutSampleScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("My Layout Example") })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                // Row containing buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = { /* Handle Action */ }) {
                        Text("Button 1")
                    }
                    Button(onClick = { /* Handle Action */ }) {
                        Text("Button 2")
                    }
                }

                // Box with overlapping elements
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Box Content", modifier = Modifier.align(Alignment.Center))
                    Text("Overlay", modifier = Modifier.align(Alignment.TopEnd))
                }

                // LazyColumn for a vertical scrollable list
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(100) { index ->
                        Text(
                            text = "Item #$index",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

                // Spacer to separate sections
                Spacer(modifier = Modifier.height(16.dp))

                // LazyVerticalGrid for a two-dimensional grid layout
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(20) { index ->
                        Card(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(text = "Grid Item $index", modifier = Modifier.padding(16.dp))
                        }
                    }
                }
            }
        }
    )
}
