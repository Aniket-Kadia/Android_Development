package com.example.myapplication.authentication.model

import com.google.gson.annotations.SerializedName

data class LoginSignupResponse(
    @SerializedName("code")
    var code: Int?,
    @SerializedName("data")
    var `data`: Data?,
    @SerializedName("message")
    var message: String?
)