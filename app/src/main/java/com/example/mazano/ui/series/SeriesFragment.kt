package com.example.mazano.ui.series

import android.os.Bundle
import com.example.mazano.core.base_fragment.BaseFragment
import com.example.mazano.databinding.FragmentSeriesBinding


class SeriesFragment : BaseFragment<FragmentSeriesBinding>(FragmentSeriesBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() =
            SeriesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}