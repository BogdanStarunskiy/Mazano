package com.example.mazano.ui.games

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.mazano.R
import com.example.mazano.core.base_fragment.BaseFragment
import com.example.mazano.databinding.FragmentGamesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class GamesFragment : BaseFragment<FragmentGamesBinding>(FragmentGamesBinding::inflate) {
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if(currentUser == null)
            requireActivity().findNavController(R.id.fragmentContainerView).navigate(R.id.action_gamesFragment_to_authFragment)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            GamesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}