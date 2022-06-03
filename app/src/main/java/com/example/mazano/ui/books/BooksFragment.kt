package com.example.mazano.ui.books

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mazano.R
import dagger.hilt.EntryPoint


class BooksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BooksFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}