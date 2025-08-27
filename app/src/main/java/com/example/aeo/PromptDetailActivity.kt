/*package com.example.aeo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageButton
import android.widget.TextView

class PromptDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.item_prompt_card)

        // Fix system window insets (status/navigation bar padding)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Title
        val txtTitle = findViewById<TextView>(R.id.txtTitle)
        txtTitle.text = "Fashion Feature"  // default, or set from intent below

        // Handle Back Button
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // If data passed via intent, update content
        intent?.let {
            val titleFromIntent = it.getStringExtra("title")
            if (!titleFromIntent.isNullOrBlank()) {
                txtTitle.text = titleFromIntent
            }
        }
    }
}*/


package com.example.aeo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageButton
import android.widget.TextView

class PromptDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.item_prompt_card) // ✅ fix

        // Fix system window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Title
        val txtTitle = findViewById<TextView>(R.id.txtTitle)
        txtTitle.text = "Fashion Feature"

        // Back Button
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // If data passed via Intent
        intent?.let {
            val titleFromIntent = it.getStringExtra("title")
            if (!titleFromIntent.isNullOrBlank()) {
                txtTitle.text = titleFromIntent
            }
        }
    }
}
