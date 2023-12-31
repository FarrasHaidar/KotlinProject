package com.kotlin.learn.myapplication.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.kotlin.learn.myapplication.MainActivity
import com.kotlin.learn.myapplication.R
import com.kotlin.learn.myapplication.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.auth_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    fun moveToMain() {
        val intent = Intent(this@AuthActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.auth_fragment_container)
        return navController.navigateUp()
    }
}