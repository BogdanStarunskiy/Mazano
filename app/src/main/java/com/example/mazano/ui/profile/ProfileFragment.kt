package com.example.mazano.ui.profile

import android.os.Bundle
import com.example.mazano.databinding.FragmentProfileBinding
import com.example.mazano.utils.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}