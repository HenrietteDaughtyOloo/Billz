package com.henriette_.billz.repository

import com.henriette_.billz.api.ApiClient
import com.henriette_.billz.api.ApiInterface
import com.henriette_.billz.model.RegisterRequest
import com.henriette_.billz.model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepo {
    var client=ApiClient.buildClient(ApiInterface::class.java)

    suspend fun registerUser(registerRequest: RegisterRequest):Response<RegisterResponse>{
        return withContext(Dispatchers.IO){
            client.registerUser(registerRequest)
        }
    }
}