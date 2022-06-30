package com.example.mazano.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.mazano.R
import com.example.mazano.core.base_fragment.BaseFragment
import com.example.mazano.databinding.FragmentAuthBinding
import com.example.mazano.utils.extentions.invisible
import com.example.mazano.utils.extentions.isVisible
import com.example.mazano.utils.extentions.visible
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class AuthFragment : BaseFragment<FragmentAuthBinding>(FragmentAuthBinding::inflate) {
    private lateinit var authViewModel: AuthViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        binding.signInButton.setOnClickListener {
            authViewModel.signUp(
                binding.email.text.toString(),
                binding.password.text.toString(),
                requireActivity()
            )
        }
        binding.loginButton.setOnClickListener {
            authViewModel.login(
                binding.email.text.toString(),
                binding.password.text.toString(),
                requireActivity()
            )
        }
    }

    override fun onStart() {
        super.onStart()
        requireActivity().findViewById<CurvedBottomNavigation>(R.id.bottomNavigation).invisible()
    }

}