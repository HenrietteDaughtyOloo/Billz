package com.henriette_.billz.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("first_name")var firstName:String,
    @SerializedName("last_name")var lastName:String,
    @SerializedName("user_id")var userId:String,
    var email:String,
    var password:String,
    @SerializedName("phone_number")var phoneNumber:String,
)
