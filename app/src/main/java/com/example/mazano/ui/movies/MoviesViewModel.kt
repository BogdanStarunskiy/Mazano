package com.example.mazano.ui.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mazano.models.movie.MovieModel
import com.example.mazano.retrofit.movie.MovieService
import com.example.mazano.utils.MOVIE_API_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieService: MovieService): ViewModel() {
    fun getPopularMovies(){
        movieService.getPopularMovies(MOVIE_API_KEY).enqueue(object: Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                val result = response.body()
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}