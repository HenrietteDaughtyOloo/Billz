package com.henriette_.billz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.henriette_.billz.databinding.ActivityMainBinding
import com.henriette_.billz.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }




override fun onResume() {
    super.onResume()

    binding.btnSignUp?.setOnClickListener {
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
        finish()
    }

    binding.btnSignUp?.setOnClickListener {
        validate()
    }
//    binding.tvAccountAdd?.setOnClickListener {
//        val intent = Intent(this, LogInActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
}

private fun validate() {
    clearErrors()
    val userName = binding.tilLogUserName.editText?.text.toString()
    val password = binding.tilPassword.editText?.text.toString()
    val confirmPassword = binding.tilConfirmPassword.editText?.text.toString()
    val phoneNumber = binding.tilPhoneNumber.editText?.text.toString()
    val email = binding.tilEmail.editText?.text.toString()
    var error = false

    if (userName.isBlank()) {
        binding.tilLogUserName.error = "User Name is required to proceed"
        error = true
    }

    if (password.isBlank()) {
        binding.tilPassword.error = "Password needed to proceed"
        error = true
    }
    if (phoneNumber.isBlank()){
        binding.tilPhoneNumber.error = "Enter your phone number to proceed"
        error = true
    }
    if (email.isBlank()){
        binding.tilEmail.error = "Enter your email to proceed"
        error = true
    }


    if (!error) {
        if (password == confirmPassword) {
            // Successful login
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // Login failed
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }
}

private fun clearErrors() {
    binding.tilLogUserName.error = null
    binding.tilPassword.error = null
}
}

