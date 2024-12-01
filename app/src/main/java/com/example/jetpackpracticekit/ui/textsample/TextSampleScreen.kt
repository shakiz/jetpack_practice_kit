package com.example.jetpackpracticekit.ui.textsample

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackpracticekit.ui.main.MyAppBar

@Composable
fun TextSampleScreen(navController: NavController) {
    val context = LocalContext.current

    // State variables for input values
    var text by remember { mutableStateOf("") }
    var outlinedText by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(false) }
    var isSwitchedOn by remember { mutableStateOf(false) }
    var sliderPosition by remember { mutableStateOf(0f) }

    Scaffold(
        topBar = {
            MyAppBar(
                title = "Texts Sample Screen",
                Icons.Filled.ArrowBack,
                onBackPressed = { navController.popBackStack() })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Standard TextField
            TextField(
                value = text,
                onValueChange = {
                    text = it
                    Toast.makeText(context, "TextField value: $it", Toast.LENGTH_SHORT).show()
                },
                label = { Text("Standard TextField") }
            )

            // Outlined TextField
            OutlinedTextField(
                value = outlinedText,
                onValueChange = {
                    outlinedText = it
                    Toast.makeText(context, "OutlinedTextField value: $it", Toast.LENGTH_SHORT)
                        .show()
                },
                label = { Text("Outlined TextField") }
            )

            // Password Field
            TextField(
                value = password,
                onValueChange = {
                    password = it
                    Toast.makeText(context, "Password field changed", Toast.LENGTH_SHORT).show()
                },
                label = { Text("Password Field") },
                visualTransformation = PasswordVisualTransformation()
            )

            // Checkbox
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = it
                        Toast.makeText(
                            context,
                            "Checkbox is ${if (it) "checked" else "unchecked"}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Checkbox")
            }

            // RadioButton
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedOption,
                    onClick = {
                        selectedOption = !selectedOption
                        Toast.makeText(
                            context,
                            "RadioButton is ${if (selectedOption) "selected" else "unselected"}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("RadioButton")
            }

            // Switch
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Switch(
                    checked = isSwitchedOn,
                    onCheckedChange = {
                        isSwitchedOn = it
                        Toast.makeText(
                            context,
                            "Switch is ${if (it) "ON" else "OFF"}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Switch")
            }

            // Slider
            Column {
                Slider(
                    value = sliderPosition,
                    onValueChange = {
                        sliderPosition = it
                        Toast.makeText(context, "Slider value: ${it.toInt()}", Toast.LENGTH_SHORT)
                            .show()
                    },
                    valueRange = 0f..100f
                )
                Text("Slider Value: ${sliderPosition.toInt()}")
            }
        }
    }
}
