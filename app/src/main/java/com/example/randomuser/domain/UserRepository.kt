package com.example.randomuser.domain
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getRandomUsers(page: Int): Flow<List<User>>
}