package com.dev.divig.findmovies.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev.divig.findmovies.ui.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}