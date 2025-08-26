package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn: Button
    private lateinit var tvSignUp: TextView
    private lateinit var tvForgotPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Initialize views
        etEmail = findViewById(R.id.et_email_signin)
        etPassword = findViewById(R.id.et_password_signin)
        btnSignIn = findViewById(R.id.btn_sign_in)
        tvSignUp = findViewById(R.id.tv_sign_up)
        tvForgotPassword = findViewById(R.id.tv_forgot_password)

        // Set click listeners
        btnSignIn.setOnClickListener { handleSignIn() }
        tvSignUp.setOnClickListener { navigateToSignUp() }
        tvForgotPassword.setOnClickListener { handleForgotPassword() }
    }

    private fun handleSignIn() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
            navigateToWelcome()
        }
    }

    private fun navigateToWelcome() {
        startActivity(Intent(this, WelcomeActivity::class.java))
        finish()
    }


    private fun navigateToSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    private fun handleForgotPassword() {
        Toast.makeText(this, "Password reset link sent!", Toast.LENGTH_SHORT).show()
    }
}
