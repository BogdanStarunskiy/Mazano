package com.example.mazano.ui.movies.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mazano.models.movie.MovieModel

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovieList(movieModel: MovieModel)

    @Update
    fun updateMovieList(movieModel: MovieModel)

    @Query("SELECT * from movies")
    fun getAllMovies(): LiveData<MovieModel>

}