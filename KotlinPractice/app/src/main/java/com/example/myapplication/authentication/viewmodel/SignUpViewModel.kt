package com.example.myapplication.authentication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.authentication.model.RegistrationRequest
import com.example.myapplication.repositories.OrganizationRepository
import com.example.myapplication.utils.Validation
import com.example.myapplication.utils.validateEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val organizationRepository: OrganizationRepository) :
    ViewModel() {

    var validation = MutableLiveData<Validation>()
    var isSuccessful = MutableLiveData<Int?>()
    var isUnsuccessful = MutableLiveData<Int?>()
    var username = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun registerAccount() {
        if (username.value.toString().trim().isEmpty()) {
            validation.value = Validation.EMPTY_NAME
        } else if (email.value.toString().trim().isEmpty()) {
            validation.value = Validation.EMPTY_EMAIL
        } else if (!validateEmail(email.value.toString())) {
            validation.value = Validation.NOT_VALID_EMAIL
        } else if (password.value.toString().trim().isEmpty()) {
            validation.value = Validation.EMPTY_PASSWORD
        } else if (password.value.toString().length < 6) {
            validation.value = Validation.NOT_VALID_PASSWORD
        } else {
            viewModelScope.launch {
                val response = organizationRepository.registerUser(
                    RegistrationRequest(
                        email.value.toString(),
                        username.value.toString(),
                        password.value.toString().toInt()
                    )
                )
                when (response.code()) {
                    in 200..299 -> {
                        isSuccessful.postValue(response.body()?.code)
                    }
                    in 400..499 -> {
                    isUnsuccessful.postValue(response.code())
                    }
                }
            }
        }
    }
}