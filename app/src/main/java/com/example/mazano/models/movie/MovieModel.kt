package com.example.mazano.models.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "movies")
data class MovieModel(
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val page: Int,
    @ColumnInfo
    val results: List<Result>,
    @ColumnInfo
    val total_pages: Int,
    @ColumnInfo
    val total_results: Int
)