package com.kotlin.learn.myapplication.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.learn.myapplication.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }
}