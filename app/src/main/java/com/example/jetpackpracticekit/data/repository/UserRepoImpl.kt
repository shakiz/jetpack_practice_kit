package com.example.jetpackpracticekit.data.repository

import com.example.jetpackpracticekit.data.model.Profile
import com.example.jetpackpracticekit.domain.profile.UserRepo

class UserRepoImpl : UserRepo{
    override suspend fun fetchUserProfile(): List<Profile> {
        return List(20) { index ->
            Profile(
                id = index,
                name = "User $index",
                userName = "UserName @$index"
            )
        }
    }
}