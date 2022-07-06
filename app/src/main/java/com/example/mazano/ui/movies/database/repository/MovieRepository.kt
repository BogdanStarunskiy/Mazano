package com.example.mazano.ui.movies.database.repository

import com.example.mazano.models.movie.MovieModel
import com.example.mazano.retrofit.movie.MovieAPI
import com.example.mazano.utils.MOVIE_API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieAPI: MovieAPI) {
    fun getMoviesFromServer(): MovieModel? {
        var result: MovieModel? = null
        movieAPI.getPopularMovies(MOVIE_API_KEY).enqueue(object : Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                result = response.body()
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {

            }
        })
        return result
    }
}