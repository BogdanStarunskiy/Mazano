package com.example.mazano.ui.games.db.repo

import com.example.mazano.models.games.GamesModel
import com.example.mazano.models.games.GamesModelItem
import com.example.mazano.retrofit.games.GamesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GamesRepository @Inject constructor(private val gamesService: GamesService) {
    var result:GamesModelItem? = null
    fun getAllGames():GamesModelItem? {


        gamesService.getGamesList().enqueue(object : Callback<GamesModelItem> {

            override fun onResponse(
                call: Call<GamesModelItem>,
                response: Response<GamesModelItem>
            ) {
                result = response.body()
            }

            override fun onFailure(call: Call<GamesModelItem>, t: Throwable) {

            }

        })
        return result
    }
}