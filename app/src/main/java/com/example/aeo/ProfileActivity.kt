package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Click Listeners
        findViewById<TextView>(R.id.txtHelpFaq).setOnClickListener {
            // TODO: Open Help FAQ
        }

        findViewById<TextView>(R.id.txtPrivacyPolicy).setOnClickListener {
            // TODO: Open Privacy Policy
        }

        findViewById<TextView>(R.id.txtTerms).setOnClickListener {
            // TODO: Open Terms of Service
        }

        findViewById<TextView>(R.id.txtDebugInfo).setOnClickListener {
            // TODO: Copy debug info
        }

        findViewById<TextView>(R.id.txtAgentSupport).setOnClickListener {
            // TODO: Open Agent Support
        }

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            // TODO: Implement logout
        }

        // Bottom Navigation
        // Bottom Navigation
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.nav_profile
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }

                R.id.nav_favorites -> {
                    startActivity(Intent(this, FavoriteActivity::class.java))
                    true
                }

                R.id.nav_profile -> true
                R.id.nav_news -> {
                    startActivity(Intent(this, NewsActivity::class.java))
                    true
                }
                else -> false
            }
        }


    }
}
