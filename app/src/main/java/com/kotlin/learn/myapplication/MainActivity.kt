package com.kotlin.learn.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlin.learn.myapplication.ui.auth.AuthActivity
import org.opencv.android.OpenCVLoader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentLogin = Intent(this, AuthActivity::class.java)
        startActivity(intentLogin)

        if(OpenCVLoader.initDebug()) Log.d("LOADED", "SUCCESS")
        else Log.d("LOADED", "error")


    }
}