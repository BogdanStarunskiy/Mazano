package com.example.mazano.retrofit.games

import com.example.mazano.models.games.GamesModel
import com.example.mazano.models.games.GamesModelItem
import retrofit2.Call
import retrofit2.http.GET

interface GamesService {

    @GET("./games")
    fun getGamesList(): Call<GamesModelItem>
}