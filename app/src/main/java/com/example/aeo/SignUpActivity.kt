package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat

class SignUpActivity : AppCompatActivity() {

    // UI Components
    private lateinit var etEmail: EditText
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnCreateAccount: Button
    private lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize UI components
        initializeViews()

        // Set click listeners
        setupClickListeners()

        // Setup modern back press handling
        setupBackPressHandler()
    }

    private fun initializeViews() {
        etEmail = findViewById(R.id.et_email)
        etFirstName = findViewById(R.id.et_first_name)
        etLastName = findViewById(R.id.et_last_name)
        etPassword = findViewById(R.id.et_password)
        etConfirmPassword = findViewById(R.id.et_confirm_password)
        btnCreateAccount = findViewById(R.id.btn_create_account)
        tvLogin = findViewById(R.id.tv_login)
    }

    private fun setupClickListeners() {
        // Navigate to Sign In Activity
        tvLogin.setOnClickListener {
            navigateToSignIn()
        }

        // Handle Create Account button click
        btnCreateAccount.setOnClickListener {
            handleSignUp()
        }
    }

    private fun setupBackPressHandler() {
        // Modern way to handle back press using OnBackPressedDispatcher
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Handle the back press with custom animation
                finish()
                // Use ActivityOptionsCompat for modern transitions
                val options = ActivityOptionsCompat.makeCustomAnimation(
                    this@SignUpActivity,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
                // Note: The animation will be applied when this activity finishes
            }
        })
    }

    private fun navigateToSignIn() {
        val intent = Intent(this, SignInActivity::class.java)

        // Modern way to handle activity transitions
        val options = ActivityOptionsCompat.makeCustomAnimation(
            this,
            android.R.anim.slide_in_left,
            android.R.anim.slide_out_right
        )

        startActivity(intent, options.toBundle())
    }

    private fun handleSignUp() {
        // Get input values
        val email = etEmail.text.toString().trim()
        val firstName = etFirstName.text.toString().trim()
        val lastName = etLastName.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val confirmPassword = etConfirmPassword.text.toString().trim()

        // Validate inputs
        if (validateInputs(email, firstName, lastName, password, confirmPassword)) {
            // TODO: Implement actual registration logic here
            // For now, show success message and navigate to sign in
            showToast("Account created successfully!")

            // Navigate to Sign In after successful registration
            navigateToSignIn()
        }
    }

    private fun validateInputs(
        email: String,
        firstName: String,
        lastName: String,
        password: String,
        confirmPassword: String
    ): Boolean {

        // Check if fields are empty
        if (email.isEmpty()) {
            etEmail.error = "Email is required"
            etEmail.requestFocus()
            return false
        }

        if (firstName.isEmpty()) {
            etFirstName.error = "First name is required"
            etFirstName.requestFocus()
            return false
        }

        if (lastName.isEmpty()) {
            etLastName.error = "Last name is required"
            etLastName.requestFocus()
            return false
        }

        if (password.isEmpty()) {
            etPassword.error = "Password is required"
            etPassword.requestFocus()
            return false
        }

        if (confirmPassword.isEmpty()) {
            etConfirmPassword.error = "Please confirm your password"
            etConfirmPassword.requestFocus()
            return false
        }

        // Validate email format
        if (!isValidEmail(email)) {
            etEmail.error = "Please enter a valid email"
            etEmail.requestFocus()
            return false
        }

        // Validate password strength
        if (password.length < 6) {
            etPassword.error = "Password must be at least 6 characters"
            etPassword.requestFocus()
            return false
        }

        // Check if passwords match
        if (password != confirmPassword) {
            etConfirmPassword.error = "Passwords do not match"
            etConfirmPassword.requestFocus()
            return false
        }

        return true
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}