package com.example.mazano.models.movie

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieEntity")
data class MovieDatabaseModel(
    @PrimaryKey
    val id: String,
    val adult: Boolean,
    val backdrop_path: String,
    val original_language: String,
    val genre: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)