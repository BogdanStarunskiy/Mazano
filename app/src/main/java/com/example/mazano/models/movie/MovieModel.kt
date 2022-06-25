package com.example.mazano.models.movie


data class MovieModel(
    val id: Int,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)