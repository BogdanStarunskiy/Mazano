package com.example.mazano.di

import com.example.mazano.retrofit.movie.MovieAPI
import com.example.mazano.utils.MOVIE_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Singleton
    @Provides
    fun provideRetrofit(): MovieAPI {
        return Retrofit.Builder()
            .baseUrl(MOVIE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }
}