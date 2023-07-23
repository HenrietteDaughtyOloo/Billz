package com.henriette_.billz.model

import com.google.gson.annotations.SerializedName

data class ModelUsers(
    @SerializedName("user_id") var userId:String,
    var email: String,
    var password:String,

)
