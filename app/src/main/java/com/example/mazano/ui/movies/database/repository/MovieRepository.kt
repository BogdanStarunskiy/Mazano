package com.example.mazano.ui.movies.database.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import androidx.room.Update
import com.example.mazano.models.movie.MovieModel

interface MovieRepository {
    val allMovies: LiveData<MovieModel>
    fun insertMovieList(movieModel: MovieModel)
    fun updateMovieList(movieModel: MovieModel)
}