package com.example.myapplication.authentication.model

import com.google.gson.annotations.SerializedName

data class RegistrationRequest(
    @SerializedName("email")
    var email: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("password")
    var password: Int?
)