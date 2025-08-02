package com.example.randomuser.ui

import com.example.randomuser.domain.User

data class UserState(
    val users: List<User> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)