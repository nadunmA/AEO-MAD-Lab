package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    private val WELCOME_DELAY = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, DiscoverActivity::class.java)
            startActivity(intent)
            finish()
        }, WELCOME_DELAY)
    }
}
