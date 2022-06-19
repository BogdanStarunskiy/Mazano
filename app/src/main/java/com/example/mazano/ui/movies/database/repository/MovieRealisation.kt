package com.example.mazano.ui.movies.database.repository

import androidx.lifecycle.LiveData
import com.example.mazano.models.movie.MovieModel
import com.example.mazano.ui.movies.database.dao.MovieDAO

class MovieRealisation(private val movieDAO: MovieDAO): MovieRepository{
    override val allMovies: LiveData<MovieModel>
        get() = movieDAO.getAllMovies()

    override fun insertMovieList(movieModel: MovieModel) {
        movieDAO.insertMovieList(movieModel)
    }

    override fun updateMovieList(movieModel: MovieModel) {
        movieDAO.updateMovieList(movieModel)
    }
}