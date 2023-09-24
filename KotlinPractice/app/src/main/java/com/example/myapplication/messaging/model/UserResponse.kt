package com.example.myapplication.messaging.model

import com.example.myapplication.R

fun getChatData(): ArrayList<UserModel> {
    val chatData = arrayListOf(
        UserModel(R.drawable.image_profile_micheal,"Micheal Joshua","Hello how are you?","12:05 PM",10),
        UserModel(R.drawable.image_profile_sara,"Sara Johnson","Hey can you come for party?","02:05 PM",0),
        UserModel(R.drawable.image_profile_john,"John Smith","Hey Happy journey...","05:05 PM",13),
        UserModel(R.drawable.image_profile_joseph,"Joseph Ray","Hello how are you?","12:05 PM",10),
        UserModel(R.drawable.image_profile_thomas,"Thomas Adison","Hey can you come for party?","02:05 PM",0),
        UserModel(R.drawable.image_profile_ariana,"Ariana Amberline","Hey Happy journey...","05:05 PM",0)
    )
    return chatData
}