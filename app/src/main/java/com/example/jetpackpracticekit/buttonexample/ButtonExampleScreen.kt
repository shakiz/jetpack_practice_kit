package com.example.jetpackpracticekit.buttonexample

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ButtonExampleScreen() {
    val context = LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(context, "FloatingActionButton clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }
        },
        content = { paddingValues -> // Pass paddingValues as contentPadding
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues) // Apply content padding here
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(onClick = {
                    Toast.makeText(context, "Primary Button clicked", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Primary Button")
                }

                OutlinedButton(onClick = {
                    Toast.makeText(context, "Outlined Button clicked", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Outlined Button")
                }

                TextButton(onClick = {
                    Toast.makeText(context, "Text Button clicked", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Text Button")
                }

                IconButton(onClick = {
                    Toast.makeText(context, "Icon Button clicked", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Favorite Icon")
                }
            }

        }
    )
}
