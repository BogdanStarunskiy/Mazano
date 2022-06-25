package com.example.mazano.ui.profile

import android.os.Bundle
import com.example.mazano.core.base_fragment.BaseFragment
import com.example.mazano.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}