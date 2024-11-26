package com.example.jetpackpracticekit.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.jetpackpracticekit.utils.PrefManager

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit,
    onRegisterClick: () -> Unit
) {
    val context = LocalContext.current
    val preferencesManager = remember { PrefManager(context) }
    val authViewModel = remember { AuthViewModel(preferencesManager) }
    val authState by authViewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // App Logo
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "App Logo",
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.primary
            )

            // Email Input
            OutlinedTextField(
                value = authState.email,
                onValueChange = {
                    authViewModel.setEmail(it)
                },
                label = { Text("Email") },
                placeholder = { Text("Enter your email") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )

            // Password Input
            OutlinedTextField(
                value = authState.password,
                onValueChange = { authViewModel.setPassword(it) },
                label = { Text("Password") },
                placeholder = { Text("Enter your password") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (authState.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            // Login Button
            Button(
                onClick = {
                    authViewModel.setLoginState(true)
                    onLoginClick(authState.email, authState.password)
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = authState.email.isNotBlank() && authState.password.isNotBlank()
            ) {
                Text("Login")
            }

            // Register UI
            TextButton(onClick = { onRegisterClick() }) {
                Text("Register Yourself")
            }
        }
    }
}

