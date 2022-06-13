package com.example.mazano

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mazano.databinding.ActivityMainBinding
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
            CurvedBottomNavigation.Model(BOOKS_ITEM, "", R.drawable.ic_book),
            CurvedBottomNavigation.Model(PROFILE_ITEM, "", R.drawable.ic_profile),
            CurvedBottomNavigation.Model(SEARCH_ITEM, "", R.drawable.ic_search)

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
                PROFILE_ITEM -> {
                    navController.popBackStack(R.id.booksFragment, false)
                }
                SEARCH_ITEM -> {
                    navController.popBackStack(R.id.profileFragment, false)
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
        const val PROFILE_ITEM = R.id.profileFragment
        const val SEARCH_ITEM = R.id.searchFragment
    }

}