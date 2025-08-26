package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val SPLASH_DELAY = 2000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startAnimations()
        navigateNext()
    }

    private fun startAnimations() {
        try {
            val logoImage = findViewById<ImageView>(R.id.iv_logo)
            val appNameText = findViewById<TextView>(R.id.tv_app_name)
            val taglineText = findViewById<TextView>(R.id.tv_tagline)

            logoImage?.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_up))
            appNameText?.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in))
            taglineText?.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun navigateNext() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SignUpActivity::class.java) // show SignUp first
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}
