package com.example.myapplication.utils

enum class Validation(val message: String) {
    EMPTY_NAME("Please Enter Name"),
    EMPTY_EMAIL("Please Enter Email"),
    NOT_VALID_EMAIL("Please Enter Valid Email Address"),
    EMPTY_PASSWORD("Please Enter Password"),
    NOT_VALID_PASSWORD("Your Password length should between 6 to 9 digit")
}