package com.example.mazano.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
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
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        binding.signInButton.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        requireActivity().findNavController(R.id.fragmentContainerView).navigate(R.id.action_authFragment_to_gamesFragment)
                        requireActivity().findViewById<CurvedBottomNavigation>(R.id.bottomNavigation).visible()

                    } else {
                        Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        binding.loginButton.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        requireActivity().findNavController(R.id.fragmentContainerView).navigate(R.id.action_authFragment_to_gamesFragment)
                        requireActivity().findViewById<CurvedBottomNavigation>(R.id.bottomNavigation).visible()
                    } else {
                        Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    override fun onStart() {
        super.onStart()
        requireActivity().findViewById<CurvedBottomNavigation>(R.id.bottomNavigation).invisible()
    }

}