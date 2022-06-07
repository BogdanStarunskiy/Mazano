package com.example.mazano

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mazano.databinding.ActivityMainBinding
import com.example.mazano.ui.books.BooksFragment
import com.example.mazano.ui.games.GamesFragment
import com.example.mazano.ui.movies.MoviesFragment
import com.example.mazano.ui.profile.ProfileFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavHost()
        setUpBottomNavigation()
    }


    private fun initNavHost() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
    }


    private fun setUpBottomNavigation()  {
        val bottomNavigationItems = mutableListOf(
            CurvedBottomNavigation.Model(GAMES_ITEM, "", R.drawable.ic_controller),
            CurvedBottomNavigation.Model(MOVIES_ITEM, "", R.drawable.ic_popcorn),
            CurvedBottomNavigation.Model(BOOKS_ITEM, "", R.drawable.ic_book)

        )
        binding.bottomNavigation.apply {
            bottomNavigationItems.forEach { add(it) }
            setOnClickMenuListener {
                navController.navigate(it.id)
            }
            setupNavController(navController)
        }
    }
    override fun onBackPressed() {
        if (navController.currentDestination!!.id == GAMES_ITEM)
            super.onBackPressed()
        else {
            when (navController.currentDestination!!.id) {
                MOVIES_ITEM -> {
                    navController.popBackStack(R.id.gamesFragment, false)
                }
                BOOKS_ITEM -> {
                    navController.popBackStack(R.id.moviesFragment, false)
                }

                else -> {
                    navController.navigateUp()
                }
            }
        }
    }


    companion object {
        const val GAMES_ITEM = R.id.gamesFragment
        const val MOVIES_ITEM = R.id.moviesFragment
        const val BOOKS_ITEM = R.id.booksFragment

    }

}