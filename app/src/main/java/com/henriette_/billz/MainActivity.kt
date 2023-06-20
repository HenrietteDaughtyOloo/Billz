package com.henriette_.billz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.henriette_.billz.databinding.ActivityLogInBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogIn.setOnClickListener {}

    }

    fun validate() {
        clearErrors()
        val person1 = binding.etLogUserName.text.toString()
        val person2 = binding.etLogPassword.text.toString()
        var error = false

        if (person1.isBlank()) {
            binding.tilLogUserName.error = "User Name is required to proceed"
            error = true

        }
//        binding.tilLogPassword.text = result.toString()


    }

    private fun clearErrors() {
        binding.tilLogUserName.error=null
        binding.tilLogPassword.error=null
    }
}


