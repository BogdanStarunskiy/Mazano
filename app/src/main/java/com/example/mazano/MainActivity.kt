package com.example.mazano

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.mazano.databinding.ActivityMainBinding
import com.example.mazano.ui.books.BooksFragment
import com.example.mazano.ui.games.GamesFragment
import com.example.mazano.ui.movies.MoviesFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var menu:ChipNavigationBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,GamesFragment()).commit()
        menu = findViewById(R.id.menu)
        menu.setItemSelected(R.id.games, true)
        initBottomNavBar()

    }

    private fun initBottomNavBar() {
        menu.setOnItemSelectedListener {
            var fragment: Fragment? = null
            when(it){
                R.id.games -> fragment = GamesFragment()
                R.id.movies -> fragment = MoviesFragment()
                R.id.books -> fragment = BooksFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,fragment!!).commit()

        }

    }


}