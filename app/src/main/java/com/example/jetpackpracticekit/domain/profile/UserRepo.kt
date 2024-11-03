package com.example.jetpackpracticekit.domain.profile

import com.example.jetpackpracticekit.data.model.Profile

interface UserRepo {
    fun fetchUserProfile(): List<Profile>
}