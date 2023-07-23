package com.henriette_.billz.model

import android.os.Message

data class LoginResponse(
    var message: String,
    var access_token:String,
    var user_id:ModelUsers,
)
