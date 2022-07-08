package com.example.mazano.ui.games


import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.mazano.R
import com.example.mazano.models.games.GamesModel
import com.example.mazano.models.games.GamesModelItem
import com.example.mazano.retrofit.games.GamesService
import com.example.mazano.ui.games.db.repo.GamesRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class GamesViewModel @Inject constructor(private val repository: GamesRepository) : ViewModel() {
    private lateinit var auth: FirebaseAuth
    val games = MutableLiveData<GamesModelItem>()
    fun getAllGamesFromApi() {
        games.value = repository.getAllGames()
    }
    fun getGames():LiveData<GamesModelItem>{
        return games
    }

    fun checkUserAuth(activity: Activity) {
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if (currentUser == null)
            activity.findNavController(R.id.fragmentContainerView)
                .navigate(R.id.action_gamesFragment_to_authFragment)

    }
}


