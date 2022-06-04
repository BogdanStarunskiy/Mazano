package com.example.mazano.ui.books

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mazano.R
import com.example.mazano.databinding.FragmentBooksBinding
import com.example.mazano.utils.BaseFragment
import dagger.hilt.EntryPoint


class BooksFragment : BaseFragment<FragmentBooksBinding>(FragmentBooksBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() =
            BooksFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}