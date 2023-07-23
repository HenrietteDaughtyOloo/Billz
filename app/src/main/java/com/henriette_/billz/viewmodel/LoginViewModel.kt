package com.henriette_.billz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henriette_.billz.model.LoginRequest
import com.henriette_.billz.model.LoginResponse
import com.henriette_.billz.repository.LoginRepo
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    val logLiveData=MutableLiveData<LoginResponse>()
    val errorLiveData=MutableLiveData<String>()
    val loginRepo=LoginRepo()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=loginRepo.loginUser(loginRequest)
            if (response.isSuccessful){
                logLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}