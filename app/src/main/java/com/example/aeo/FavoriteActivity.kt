/*package com.example.aeo

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class FavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        // Back button logic
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Goes back to previous activity
        }
    }
}

package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        // Back button logic
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Goes back to MainActivity
        }

        // Bottom Navigation
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_favorites
        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_home -> {
                    // Go back to MainActivity
                    finish()
                    true
                }
                R.id.nav_favorites -> true // already here
                R.id.nav_search -> {
                    // Optional: implement SearchActivity
                    true
                }
                R.id.nav_profile -> {
                    // Optional: implement ProfileActivity
                    true
                }
                else -> false
            }
        }
    }
}*/

package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        // Back Button
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        // Bottom Navigation
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_favorites
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.nav_favorites -> true // already here
                R.id.nav_news -> {
                    startActivity(Intent(this, NewsActivity::class.java))
                    true
                }
                R.id.nav_profile -> true
                else -> false
            }
        }
    }
}



