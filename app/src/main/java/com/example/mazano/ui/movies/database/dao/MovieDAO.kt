package com.example.mazano.ui.movies.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mazano.models.movie.Result

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovieList(result: Result)

    @Update
    fun updateMovieList(result: Result)

    @Query("SELECT * from movies")
    fun getAllMovies(): LiveData<Result>

}