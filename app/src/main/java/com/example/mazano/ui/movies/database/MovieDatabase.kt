package com.example.mazano.ui.movies.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mazano.models.movie.MovieDatabaseModel
import com.example.mazano.ui.movies.database.dao.MovieDAO

@Database(entities = [MovieDatabaseModel::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDAO

    companion object {
        @Synchronized
        fun getInstance(context: Context): MovieDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, MovieDatabase::class.java, "db").build()
                database as MovieDatabase
            } else {
                database as MovieDatabase
            }
        }

        private var database: MovieDatabase? = null
    }
}