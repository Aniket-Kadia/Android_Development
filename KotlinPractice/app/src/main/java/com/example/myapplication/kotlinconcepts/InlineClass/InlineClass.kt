package com.example.myapplication.kotlinconcepts.InlineClass


interface Validation {
    fun isValid(): Boolean
}

@JvmInline
value class Email(val email: String) : Validation {
    override fun isValid(): Boolean {
        return email.contains("@")
    }
}

@JvmInline
value class Name(val userName: String) : Validation {
    override fun isValid(): Boolean {
        return !userName.isEmpty()
    }
}

data class User(val userName: Name, val email: Email)

fun main() {
    val email = Email("ak183@gmail.com")
    val username = Name("Aniket")
    val credentials = if (email.isValid() && username.isValid()) {
        User(username, email)
    } else {
        return
    }
    println(credentials) //output: User(userName=Name(userName=Aniket), email=Email(email=ak183@gmail.com))
}