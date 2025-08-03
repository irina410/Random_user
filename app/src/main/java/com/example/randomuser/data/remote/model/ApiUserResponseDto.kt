package com.example.randomuser.data.remote.model


import com.google.gson.annotations.SerializedName

data class ApiUserResponseDto(
    @SerializedName("results")
    val results: List<ApiUserDto>
)
