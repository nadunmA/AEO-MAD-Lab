package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding2)

        val btnNext: Button = findViewById(R.id.btn_next)
        val btnSkip: Button = findViewById(R.id.btn_skip)

        btnNext.setOnClickListener {

            startActivity(Intent(this, Onboarding3::class.java))
            finish()
        }

        btnSkip.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
