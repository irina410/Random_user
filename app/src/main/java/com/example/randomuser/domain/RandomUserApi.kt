package com.example.randomuser.domain
import com.example.randomuser.data.remote.model.ApiUserResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApi {
    @GET("api/")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("results") count: Int = 50
    ): ApiUserResponseDto

}

