package com.example.jetpackpracticekit.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackpracticekit.utils.PrefManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AuthState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLogin: Boolean = false,
    val error: String? = null
)

class AuthViewModel(private val prefManager: PrefManager) : ViewModel() {
    private val _authState = MutableStateFlow(AuthState())
    val uiState: StateFlow<AuthState> = _authState.asStateFlow()


    fun setLoginState(isLoggedIn: Boolean) {
        viewModelScope.launch {
            prefManager.putBooleanValue("isLoggedIn", isLoggedIn)
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