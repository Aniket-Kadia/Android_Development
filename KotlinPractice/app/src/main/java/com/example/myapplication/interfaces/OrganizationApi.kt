package com.example.myapplication.interfaces

import com.example.myapplication.authentication.model.LoginRequest
import com.example.myapplication.authentication.model.LoginSignupResponse
import com.example.myapplication.authentication.model.RegistrationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface OrganizationApi {
    @POST("/api/authaccount/registration")
    suspend fun registerUser(@Body registerAccount: RegistrationRequest): Response<LoginSignupResponse>

    @POST("/api/authaccount/login")
    suspend fun loginuser(@Body loginRequest: LoginRequest): Response<LoginSignupResponse>
}