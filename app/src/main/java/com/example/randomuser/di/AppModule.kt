package com.example.randomuser.di

import com.example.randomuser.data.repository.UserRepositoryImpl
import com.example.randomuser.domain.RandomUserApi
import com.example.randomuser.domain.UserRepository
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object AppModule {
    @Singleton
    @Provides
    fun provideUserRepository(api: RandomUserApi): UserRepository {
        return UserRepositoryImpl(api)
    }
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}