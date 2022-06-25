package com.example.mazano.ui.movies.database.repository

import androidx.lifecycle.LiveData
import com.example.mazano.models.movie.Result

interface MovieRepository {
    val allMovies: LiveData<Result>
    fun insertMovieList(result: Result)
    fun updateMovieList(result: Result)
}