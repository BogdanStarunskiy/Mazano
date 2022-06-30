package com.example.mazano.ui.auth

import android.app.Activity
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.findNavController
import com.example.mazano.R
import com.example.mazano.utils.extentions.visible
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private var auth: FirebaseAuth = Firebase.auth
    fun signUp(email: String, password: String, activity: Activity) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    activity.findNavController(R.id.fragmentContainerView)
                        .navigate(R.id.action_authFragment_to_gamesFragment)
                    activity.findViewById<CurvedBottomNavigation>(R.id.bottomNavigation).visible()

                } else {
                    Toast.makeText(
                        getApplication<Application>().applicationContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun login(email: String, password: String, activity: Activity) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    activity.findNavController(R.id.fragmentContainerView)
                        .navigate(R.id.action_authFragment_to_gamesFragment)
                    activity.findViewById<CurvedBottomNavigation>(R.id.bottomNavigation).visible()
                } else {
                    Toast.makeText(
                        getApplication<Application>().applicationContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}