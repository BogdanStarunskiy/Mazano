package com.example.mazano.ui.games

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.mazano.R
import com.example.mazano.core.base_fragment.BaseFragment
import com.example.mazano.databinding.FragmentGamesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamesFragment : BaseFragment<FragmentGamesBinding>(FragmentGamesBinding::inflate) {
    private lateinit var gamesViewModel: GamesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gamesViewModel = ViewModelProvider(this)[GamesViewModel::class.java]
        gamesViewModel.checkUserAuth(requireActivity())
        initObservers()

    }
    private fun initObservers(){
        gamesViewModel.getGames().observe(viewLifecycleOwner){
            Log.wtf("SIMPLE_TAG","$it")
        }
    }


}