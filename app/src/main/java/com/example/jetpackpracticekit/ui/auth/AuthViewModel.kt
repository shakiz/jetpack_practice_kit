package com.example.jetpackpracticekit.ui.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class AuthState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLogin: Boolean = false,
    val error: String? = null
)

class AuthViewModel : ViewModel() {
    private val _authState = MutableStateFlow(AuthState())
    val uiState: StateFlow<AuthState> = _authState.asStateFlow()

    fun setLoginState(isLoggedIn: Boolean) {
        _authState.update {
            it.copy(isLogin = isLoggedIn)
        }
    }

    fun setEmail(email: String) {
        _authState.update {
            it.copy(email = email)
        }
    }

    fun setPassword(password: String) {
        _authState.update {
            it.copy(password = password)
        }
    }
}