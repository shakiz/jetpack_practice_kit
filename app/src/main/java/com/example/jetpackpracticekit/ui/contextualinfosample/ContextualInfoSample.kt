package com.example.jetpackpracticekit.ui.contextualinfosample

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Dialog

@Composable
fun ContextualInfoScreen() {
    var showAlertDialog by remember { mutableStateOf(false) }
    var showDropdownMenu by remember { mutableStateOf(false) }
    var showCustomDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // AlertDialog example
        Button(onClick = { showAlertDialog = true }) {
            Text(text = "Show AlertDialog")
        }
        if (showAlertDialog) {
            AlertDialog(
                onDismissRequest = { showAlertDialog = false },
                title = { Text(text = "Alert") },
                text = { Text(text = "This is an important alert message!") },
                confirmButton = {
                    TextButton(onClick = { showAlertDialog = false }) {
                        Text(text = "OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showAlertDialog = false }) {
                        Text(text = "Cancel")
                    }
                }
            )
        }

        // DropdownMenu example
        Box {
            Button(onClick = { showDropdownMenu = true }) {
                Text(text = "Show Dropdown Menu")
            }
            DropdownMenu(
                expanded = showDropdownMenu,
                onDismissRequest = { showDropdownMenu = false }
            ) {
                DropdownMenuItem(onClick = { showDropdownMenu = false },
                    text = { Text(text = "Option 1") }
                )
                DropdownMenuItem(onClick = { showDropdownMenu = false },
                    text = { Text(text = "Option 2") }
                )
                DropdownMenuItem(onClick = { showDropdownMenu = false },
                    text = { Text(text = "Option 3") }
                )
            }
        }

        // Custom Dialog example
        Button(onClick = { showCustomDialog = true }) {
            Text(text = "Show Custom Dialog")
        }
        if (showCustomDialog) {
            Dialog(onDismissRequest = { showCustomDialog = false }) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "This is a custom dialog!")
                        Button(onClick = { showCustomDialog = false }) {
                            Text(text = "Close")
                        }
                    }
                }
            }
        }

        // Card example for grouping content
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "This is a Card")
                Text(text = "Cards are useful for grouping related content")
            }
        }

        // Surface example for styling content sections
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = MaterialTheme.colorScheme.primary,
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 4.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "This is a Surface", color = MaterialTheme.colorScheme.onPrimary)
                Text(
                    text = "Surfaces can be styled with color, shape, and elevation",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}
