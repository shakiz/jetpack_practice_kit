package com.example.jetpackpracticekit.domain.profile

import com.example.jetpackpracticekit.data.model.Profile

interface UserRepo {
    suspend fun fetchUserProfile(): List<Profile>
}