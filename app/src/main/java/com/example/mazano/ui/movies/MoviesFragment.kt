package com.example.mazano.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mazano.R
import com.example.mazano.databinding.FragmentMoviesBinding
import com.example.mazano.utils.BaseFragment
import dagger.hilt.EntryPoint

class MoviesFragment : BaseFragment<FragmentMoviesBinding>(FragmentMoviesBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() =
            MoviesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
