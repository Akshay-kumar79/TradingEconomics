package com.example.tradingeconomics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.tradingeconomics.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{_,destination,_ ->
            when(destination.id){
                R.id.homeFragment -> binding.bottomNavigation.visibility = View.GONE
                R.id.newsFragment -> binding.bottomNavigation.visibility = View.VISIBLE
                R.id.calendarFragment -> binding.bottomNavigation.visibility = View.VISIBLE
                R.id.marketFragment -> binding.bottomNavigation.visibility = View.VISIBLE
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            if(item.itemId != binding.bottomNavigation.selectedItemId)
                NavigationUI.onNavDestinationSelected(item, navController)
            true
        }

        setContentView(binding.root)
    }
}