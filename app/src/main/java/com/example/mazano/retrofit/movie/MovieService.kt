package com.example.mazano.retrofit.movie

import com.example.mazano.models.movie.MovieModel
import com.example.mazano.utils.MOVIE_API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("./movie/popular?api_key=$MOVIE_API_KEY")
    fun getPopularMovies(@Query("api_key=") key:String): Call<MovieModel>
}