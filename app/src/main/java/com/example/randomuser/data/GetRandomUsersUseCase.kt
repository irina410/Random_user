package com.example.randomuser.data

import com.example.randomuser.domain.User
import com.example.randomuser.domain.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetRandomUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(page: Int): Flow<List<User>> {
        return repository.getRandomUsers(page)
    }
}
