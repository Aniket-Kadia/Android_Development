package com.example.myapplication.messaging.model

data class Attachment(val viewType:Int, val userData: ChatApp)
open class ChatApp(val textMessage: String)
class UserMessages(textMessages: String): ChatApp(textMessages)