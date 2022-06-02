package com.example.mazano.ui.games

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mazano.R
import com.example.mazano.ui.movies.MoviesFragment


class GamesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false)
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