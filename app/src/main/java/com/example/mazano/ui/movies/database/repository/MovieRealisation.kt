package com.example.mazano.ui.movies.database.repository

import androidx.lifecycle.LiveData
import com.example.mazano.models.movie.Result
import com.example.mazano.ui.movies.database.dao.MovieDAO

class MovieRealisation(private val movieDAO: MovieDAO): MovieRepository{
    override val allMovies: LiveData<Result>
        get() = movieDAO.getAllMovies()

    override fun insertMovieList(result: Result) {
        movieDAO.insertMovieList(result)
    }

    override fun updateMovieList(result: Result) {
        movieDAO.updateMovieList(result)
    }
}