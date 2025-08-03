package com.example.randomuser.ui

sealed class UserIntent {
    object LoadUsers : UserIntent()
}