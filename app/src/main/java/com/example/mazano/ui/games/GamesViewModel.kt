package com.example.mazano.ui.games


import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mazano.models.games.GamesModel

import com.example.mazano.retrofit.games.GamesService

import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


import javax.inject.Inject


@HiltViewModel
class GamesViewModel @Inject constructor(private val gamesService: GamesService) : ViewModel() {
    fun getGamesMovies(){
        gamesService.getGamesList().enqueue(object: Callback<GamesModel> {
            override fun onResponse(call: Call<GamesModel>, response: Response<GamesModel>) {
                val result = response.body()
                Log.wtf("MYTAG",result.toString())
            }

            override fun onFailure(call: Call<GamesModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
}}


