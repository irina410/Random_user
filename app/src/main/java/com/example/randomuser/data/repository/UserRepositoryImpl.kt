package com.example.randomuser.data.repository

import com.example.randomuser.data.remote.model.toDomain
import com.example.randomuser.domain.RandomUserApi
import com.example.randomuser.domain.User
import com.example.randomuser.domain.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl( val api: RandomUserApi) : UserRepository {
    override fun getRandomUsers(): Flow<List<User>> {
        return flow { emit(api.getUsers().result.map { it.toDomain() }) }
    }
}