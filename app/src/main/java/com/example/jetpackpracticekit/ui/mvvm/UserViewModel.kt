package com.example.jetpackpracticekit.ui.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackpracticekit.data.model.Profile
import com.example.jetpackpracticekit.domain.profile.UserRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userRepo: UserRepo) : ViewModel() {
    private val _items = MutableStateFlow<List<Profile>>(emptyList())
    val items: StateFlow<List<Profile>> get() = _items

    init {
        fetchProfiles()
    }

    private fun fetchProfiles() {
        viewModelScope.launch {
            // Fetch items from repository
            _items.value = userRepo.fetchUserProfile()
        }
    }
}