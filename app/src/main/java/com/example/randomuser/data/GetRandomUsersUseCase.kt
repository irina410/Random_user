package com.example.randomuser.data

import com.example.randomuser.domain.User
import com.example.randomuser.domain.UserRepository
import kotlinx.coroutines.flow.Flow

class GetRandomUsersUseCase(private val repository: UserRepository) {
    operator fun invoke(): Flow<List<User>> = repository.getRandomUsers()
}