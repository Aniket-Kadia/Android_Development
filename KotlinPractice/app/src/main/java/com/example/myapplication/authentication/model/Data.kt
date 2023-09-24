package com.example.myapplication.authentication.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("Email")
    var email: String?,
    @SerializedName("Id")
    var id: Int?,
    @SerializedName("Name")
    var name: String?,
    @SerializedName("Token")
    var token: String?
)