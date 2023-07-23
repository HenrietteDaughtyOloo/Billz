package com.henriette_.billz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henriette_.billz.model.RegisterRequest
import com.henriette_.billz.model.RegisterResponse
import com.henriette_.billz.repository.UserRepo
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val regLiveData=MutableLiveData<RegisterResponse>()
    val errorLiveData=MutableLiveData<String>()
    val userRepo=UserRepo()

    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepo.registerUser(registerRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}