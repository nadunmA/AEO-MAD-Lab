package com.example.aeo   // FIX package to match project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var logoImage: ImageView
    private lateinit var appNameText: TextView
    private lateinit var taglineText: TextView

    companion object {
        private const val SPLASH_DELAY = 3000L // 3 seconds
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize views
        initViews()

        // Start animations
        startAnimations()

        // Navigate to main activity after delay
        navigateToMainActivity()
    }

    private fun initViews() {
        logoImage = findViewById(R.id.iv_logo)
        appNameText = findViewById(R.id.tv_app_name)
        taglineText = findViewById(R.id.tv_tagline)
    }

    private fun startAnimations() {
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        val scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up)

        Handler(Looper.getMainLooper()).postDelayed({
            logoImage.startAnimation(scaleUp)
        }, 500)

        Handler(Looper.getMainLooper()).postDelayed({
            appNameText.startAnimation(fadeIn)
        }, 1000)

        Handler(Looper.getMainLooper()).postDelayed({
            taglineText.startAnimation(slideUp)
        }, 1500)
    }

    private fun navigateToMainActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            @Suppress("DEPRECATION")
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }, SPLASH_DELAY)
    }
}
