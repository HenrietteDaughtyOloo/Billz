package com.henriette_.billz.repository

import com.henriette_.billz.api.ApiClient
import com.henriette_.billz.api.ApiInterface
import com.henriette_.billz.model.LoginRequest
import com.henriette_.billz.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepo {
    var client = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>{
        return withContext(Dispatchers.IO){
            client.loginUser(loginRequest)
        }
    }
}