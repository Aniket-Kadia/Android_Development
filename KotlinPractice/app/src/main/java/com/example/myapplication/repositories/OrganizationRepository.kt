package com.example.myapplication.repositories

import com.example.myapplication.authentication.model.LoginRequest
import com.example.myapplication.authentication.model.RegistrationRequest
import com.example.myapplication.interfaces.OrganizationApi
import retrofit2.http.Body

class OrganizationRepository (private val organizationApi: OrganizationApi) {

    suspend fun registerUser(@Body registerAccount: RegistrationRequest) =
        organizationApi.registerUser(registerAccount)

    suspend fun loginUser(@Body loginRequest: LoginRequest) =
        organizationApi.loginuser(loginRequest)
}