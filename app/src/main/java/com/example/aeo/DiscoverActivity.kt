package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DiscoverActivity : AppCompatActivity() {

    private lateinit var btnSkip: Button
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)

        // Initialize views
        btnSkip = findViewById(R.id.btn_skip)
        btnNext = findViewById(R.id.btn_next)

        // Set click listeners
        btnSkip.setOnClickListener {
            // Navigate to main app
            navigateToMainApp()
        }

        btnNext.setOnClickListener {
            // Navigate to Main Activity
            navigateToMainApp()
        }
    }

    private fun navigateToMainApp() {
        // Navigate to main activity
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()

        // Optional: Add transition animation
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}