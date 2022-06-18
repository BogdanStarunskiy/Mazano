package com.example.mazano.ui.movies.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mazano.models.movie.MovieModel

@Dao
interface MovieDAO {
    @Insert
    fun insertMovieList(movieModel: MovieModel)

    @Update
    fun updateMovieList(movieModel: MovieModel)

}