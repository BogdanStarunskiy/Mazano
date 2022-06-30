package com.example.mazano.ui.games


import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.mazano.R
import com.example.mazano.models.games.GamesModel

import com.example.mazano.retrofit.games.GamesService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


import javax.inject.Inject


@HiltViewModel
class GamesViewModel @Inject constructor(private val gamesService: GamesService) : ViewModel() {
    private lateinit var auth: FirebaseAuth
    fun getGamesMovies() {
        gamesService.getGamesList().enqueue(object : Callback<GamesModel> {
            override fun onResponse(call: Call<GamesModel>, response: Response<GamesModel>) {
                val result = response.body()
                Log.wtf("MYTAG", result.toString())
            }

            override fun onFailure(call: Call<GamesModel>, t: Throwable) {

            }

        })
    }

    fun checkUserAuth(activity: Activity) {
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if (currentUser == null)
            activity.findNavController(R.id.fragmentContainerView)
                .navigate(R.id.action_gamesFragment_to_authFragment)

    }
}


