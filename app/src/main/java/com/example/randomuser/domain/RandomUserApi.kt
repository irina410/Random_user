package com.example.randomuser.domain
import com.example.randomuser.data.remote.model.ApiUserResponseDto
import retrofit2.http.GET

interface RandomUserApi {
    @GET("api/?results=50")
    suspend fun getUsers(): ApiUserResponseDto
}
