package com.example.aeo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat

class SignInActivity : AppCompatActivity() {

    // UI Components
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn: Button
    private lateinit var tvSignUp: TextView
    private lateinit var tvForgotPassword: TextView
    private lateinit var ivGoogleSignIn: ImageView
    private lateinit var ivAppleSignIn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Initialize UI components
        initializeViews()

        // Set click listeners
        setupClickListeners()

        // Setup modern back press handling
        setupBackPressHandler()
    }

    private fun initializeViews() {
        etEmail = findViewById(R.id.et_email_signin)
        etPassword = findViewById(R.id.et_password_signin)
        btnSignIn = findViewById(R.id.btn_sign_in)
        tvSignUp = findViewById(R.id.tv_sign_up)
        tvForgotPassword = findViewById(R.id.tv_forgot_password)
        ivGoogleSignIn = findViewById(R.id.iv_google_signin)
        ivAppleSignIn = findViewById(R.id.iv_apple_signin)
    }

    private fun setupClickListeners() {
        // Navigate to Sign Up Activity
        tvSignUp.setOnClickListener {
            navigateToSignUp()
        }

        // Handle Sign In button click
        btnSignIn.setOnClickListener {
            handleSignIn()
        }

        // Handle forgot password click
        tvForgotPassword.setOnClickListener {
            handleForgotPassword()
        }

        // Handle Google Sign In
        ivGoogleSignIn.setOnClickListener {
            handleGoogleSignIn()
        }

        // Handle Apple Sign In
        ivAppleSignIn.setOnClickListener {
            handleAppleSignIn()
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
                    this@SignInActivity,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
                // Note: The animation will be applied when this activity finishes
            }
        })
    }

    private fun navigateToSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)

        // Modern way to handle activity transitions
        val options = ActivityOptionsCompat.makeCustomAnimation(
            this,
            android.R.anim.slide_in_left,
            android.R.anim.slide_out_right
        )

        startActivity(intent, options.toBundle())
    }

    private fun handleSignIn() {
        // Get input values
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Validate inputs
        if (validateInputs(email, password)) {
            // TODO: Implement actual login logic here
            // For now, show success message and navigate to main app
            showToast("Login successful!")

            // Navigate to main activity (you'll need to create this)
            navigateToMainActivity()
        }
    }

    private fun validateInputs(email: String, password: String): Boolean {

        // Check if fields are empty
        if (email.isEmpty()) {
            etEmail.error = "Email is required"
            etEmail.requestFocus()
            return false
        }

        if (password.isEmpty()) {
            etPassword.error = "Password is required"
            etPassword.requestFocus()
            return false
        }

        // Validate email format
        if (!isValidEmail(email)) {
            etEmail.error = "Please enter a valid email"
            etEmail.requestFocus()
            return false
        }

        // Basic password validation
        if (password.length < 6) {
            etPassword.error = "Password must be at least 6 characters"
            etPassword.requestFocus()
            return false
        }

        return true
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun handleForgotPassword() {
        val email = etEmail.text.toString().trim()

        if (email.isEmpty()) {
            showToast("Please enter your email first")
            etEmail.requestFocus()
            return
        }

        if (!isValidEmail(email)) {
            showToast("Please enter a valid email")
            etEmail.requestFocus()
            return
        }

        // TODO: Implement forgot password logic
        showToast("Password reset link sent to $email")
    }

    private fun handleGoogleSignIn() {
        // TODO: Implement Google Sign In
        // You would integrate Google Sign-In SDK here
        showToast("Google Sign In - Coming Soon!")
    }

    private fun handleAppleSignIn() {
        // TODO: Implement Apple Sign In
        // You would integrate Apple Sign-In SDK here
        showToast("Apple Sign In - Coming Soon!")
    }

    private fun navigateToMainActivity() {
        // TODO: Create MainActivity and navigate to it
        // For now, just show a toast
        showToast("Welcome to Solomon App!")

        // Example navigation (uncomment when MainActivity is created):
        // val intent = Intent(this, MainActivity::class.java)
        // val options = ActivityOptionsCompat.makeCustomAnimation(
        //     this,
        //     android.R.anim.fade_in,
        //     android.R.anim.fade_out
        // )
        // startActivity(intent, options.toBundle())
        // finish() // Close sign in activity
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}