package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Onboarding3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding3)

        val startButton: Button = findViewById(R.id.startButton)

        startButton.setOnClickListener {
            // After last onboarding → go to MainActivity (or SignUp if you want)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
