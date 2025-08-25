package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "SplashActivity"
        private const val SPLASH_DELAY = 3000L // 3 seconds
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Start animations safely
        startAnimationsSafely()

        // Navigate after delay
        navigateToSignUp()
    }

    private fun startAnimationsSafely() {
        try {
            // Try to find views and animate them
            val logoImage = findViewById<ImageView>(R.id.iv_logo)
            val appNameText = findViewById<TextView>(R.id.tv_app_name)
            val taglineText = findViewById<TextView>(R.id.tv_tagline)

            // Check if animation files exist and animate
            animateView(logoImage, R.anim.scale_up, 500)
            animateView(appNameText, R.anim.fade_in, 1000)
            animateView(taglineText, R.anim.slide_up, 1500)

        } catch (e: Exception) {
            Log.e(TAG, "Animation error (app will continue without animations)", e)
            // Don't crash - just continue without animations
        }
    }

    private fun animateView(view: android.view.View?, animationResource: Int, delay: Long) {
        view?.let { v ->
            try {
                Handler(Looper.getMainLooper()).postDelayed({
                    try {
                        val animation = AnimationUtils.loadAnimation(this, animationResource)
                        v.startAnimation(animation)
                    } catch (e: Exception) {
                        Log.e(TAG, "Failed to load animation resource: $animationResource", e)
                    }
                }, delay)
            } catch (e: Exception) {
                Log.e(TAG, "Failed to schedule animation for view", e)
            }
        }
    }

    private fun navigateToSignUp() {
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                Log.e(TAG, "Navigation failed", e)
            }
        }, SPLASH_DELAY)
    }
}