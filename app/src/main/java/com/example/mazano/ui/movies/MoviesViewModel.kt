package com.example.mazano.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mazano.models.movie.MovieModel
import com.example.mazano.retrofit.movie.MovieAPI
import com.example.mazano.ui.movies.database.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    val movies = MutableLiveData<MovieModel>()
    fun getMoviesFromServer() {
        movies.value = repository.getMoviesFromServer()
    }

    fun getMovies(): LiveData<MovieModel> {
        return movies
    }
}