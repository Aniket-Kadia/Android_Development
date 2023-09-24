package com.example.myapplication.messaging.model

data class UserModel(
    val imageURl: Int,
    val name: String,
    val message: String,
    val time: String,
    val unseenChatCount: Int
)