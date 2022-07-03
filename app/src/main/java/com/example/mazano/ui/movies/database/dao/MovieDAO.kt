package com.example.mazano.ui.movies.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mazano.models.movie.MovieDatabaseModel

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovieList(movieDatabaseModel: MovieDatabaseModel)

    @Update
    fun updateMovieList(movieDatabaseModel: MovieDatabaseModel)

    @Query("SELECT * from movieEntity")
    fun getAllMovies(): LiveData<MovieDatabaseModel>

}