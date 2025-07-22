package com.example.randomuser.domain

data class User(
    val username: String,
    val firstName: String,
    val lastName: String,
    val photoUrl: String,
    val phone: String,
    val email: String,
    val dateOfBirth: String,
    val country: String,
    val city: String,
    val state: String,
    val street: String
)
