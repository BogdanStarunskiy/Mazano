package com.example.mazano

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.mazano.databinding.ActivityMainBinding
import com.example.mazano.ui.books.BooksFragment
import com.example.mazano.ui.games.GamesFragment
import com.example.mazano.ui.movies.MoviesFragment
import com.example.mazano.ui.profile.ProfileFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // initBottomNavBar()
    }

    private fun initBottomNavBar() {
        val bottomNavigation = binding.bottomNavigation
        addFragments(GamesFragment.newInstance())
        bottomNavigation.show(1)
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_controller))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_popcorn))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_book))
        bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.ic_profile))
        bottomNavigation.setOnClickMenuListener {
            when (it.id) {
                1 -> replaceFragments(GamesFragment.newInstance())
                2 -> replaceFragments(MoviesFragment.newInstance())
                3 -> replaceFragments(BooksFragment.newInstance())
                4 -> replaceFragments(ProfileFragment.newInstance())
            }
        }
    }

    private fun replaceFragments(fragment: Fragment) {
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.fragmentContainerView, fragment)
            .addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragments(fragment: Fragment) {
        val trans = supportFragmentManager.beginTransaction()
        trans.add(R.id.fragmentContainerView, fragment)
            .addToBackStack(Fragment::class.java.simpleName).commit()
    }


}