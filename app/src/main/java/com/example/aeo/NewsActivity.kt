/*package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        // Back Button
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        // Bottom Navigation
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.nav_search -> {
                    // TODO: Implement SearchActivity
                    true
                }
                R.id.nav_profile -> {
                    // TODO: Implement ProfileActivity
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

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        // Back Button
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        // Bottom Navigation
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.nav_news
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
                R.id.nav_news -> true // already here
                R.id.nav_profile -> true
                else -> false
            }
        }
    }
}

