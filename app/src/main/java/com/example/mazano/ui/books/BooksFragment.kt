package com.example.mazano.ui.books

import android.os.Bundle
import com.example.mazano.core.base_fragment.BaseFragment
import com.example.mazano.databinding.FragmentBooksBinding


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