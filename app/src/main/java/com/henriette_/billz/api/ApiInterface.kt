package com.henriette_.billz.api

import com.henriette_.billz.model.LoginRequest
import com.henriette_.billz.model.LoginResponse
import com.henriette_.billz.model.RegisterRequest
import com.henriette_.billz.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>

    @POST("/users/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}