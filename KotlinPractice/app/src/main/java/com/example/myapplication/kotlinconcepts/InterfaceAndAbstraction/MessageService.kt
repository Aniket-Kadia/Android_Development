package com.example.myapplication.kotlinconcepts.InterfaceAndAbstraction

// Interface for real-time messaging service
interface MessagingService {
    //Default Implementation
    fun connect() {
        println("established connection")
    }

    fun disconnect() {
        println("closed connection")
    }
}

//Inheritance of interface
interface TextMessage : MessagingService {
    val text: String
    fun sendTextMessage()
}

interface VideoMessage : MessagingService {
    val videoUrl: String
    fun sendVideoMessage()
}

// Implement the interface
class Messaging() : TextMessage, VideoMessage {
    override val text = "Hello, you are ready for session?"
    override val videoUrl = "https://videoStorage/avz06PDqDbM"
    override fun sendTextMessage() {
        println("Send text message successfully: $text ")
    }

    override fun sendVideoMessage() {
        println("Send Video message successfully: VideoURL-> $videoUrl")
    }
}

fun main() {
    val confirmationMessage: TextMessage = Messaging()
    confirmationMessage.connect()  //output: established connection
    confirmationMessage.sendTextMessage()  //output: Send text message successfully: Hello, you are ready for session?
    confirmationMessage.disconnect()  //output: closed connection

    val videoConfirmationMessage: VideoMessage = Messaging()
    videoConfirmationMessage.connect()  //output: established connection
    videoConfirmationMessage.sendVideoMessage()  //output: Send Video message successfully: VideoURL-> https://videoStorage/avz06PDqDbM
    videoConfirmationMessage.disconnect()  //output: closed connection
}