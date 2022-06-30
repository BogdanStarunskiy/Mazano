package com.example.mazano.di

import com.example.mazano.retrofit.games.GamesService
import com.example.mazano.utils.GAMES_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GameModule {

    @Singleton
    @Provides
    fun provideRetrofit(): GamesService {
        return Retrofit.Builder()
            .baseUrl(GAMES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GamesService::class.java)
    }
}