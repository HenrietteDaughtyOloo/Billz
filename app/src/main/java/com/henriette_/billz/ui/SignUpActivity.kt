package com.henriette_.billz.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.henriette_.billz.databinding.ActivitySignUpBinding
import com.henriette_.billz.model.RegisterRequest
import com.henriette_.billz.viewmodel.UserViewModel

class SignUpActivity : AppCompatActivity() {
    val userViewModel:UserViewModel by viewModels()
    lateinit var binding: ActivitySignUpBinding

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
    binding.btnSignUp?.setOnClickListener {
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
        finish()
    }


    userViewModel.regLiveData.observe(this, Observer {
        regResponse->
        Toast.makeText(this, regResponse.message,Toast.LENGTH_LONG).show()
        startActivity(Intent(this, LogInActivity::class.java))

    })

    userViewModel.regLiveData.observe(this, Observer {
            error->
        Toast.makeText(this, error.message,Toast.LENGTH_LONG).show()

    })

}

private fun validate() {
    clearErrors()
    val userName = binding.tilLogUserName.editText?.text.toString()
    val password = binding.tilPassword.editText?.text.toString()
    val confirmPassword = binding.tilConfirmPassword.editText?.text.toString()
    val phoneNumber = binding.tilPhoneNumber.editText?.text.toString()
    val email = binding.tilEmail.editText?.text.toString()
    val lastName = binding.tilLastName.editText?.text.toString()
    var error = false

    if (userName.isBlank()) {
        binding.tilLogUserName.error = "User Name is required to proceed"
        error = true
    }

    if (password.isBlank()) {
        binding.tilPassword.error = "Password needed to proceed"
        error = true
    }
    if (phoneNumber.isBlank()) {
        binding.tilPhoneNumber.error = "Enter your phone number to proceed"
        error = true
    }
    if (email.isBlank()) {
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
        val registerRequest=RegisterRequest(
            firstName =userName,
            lastName = lastName,
            email=email,
            phoneNumber = phoneNumber,
            password = password,
        )
        userViewModel.registerUser(registerRequest)




    }
    binding.progressBar2.visibility=View.VISIBLE

}


private fun clearErrors() {
    binding.tilLogUserName.error = null
    binding.tilPassword.error = null
}
}

