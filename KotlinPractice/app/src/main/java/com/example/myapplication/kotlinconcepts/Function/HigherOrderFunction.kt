package com.example.myapplication.kotlinconcepts.Function

class Timer {
    fun startTimer(duration: Long, callback: () -> Unit) {
        Thread {
            Thread.sleep(duration)
            callback()
        }.start()
    }
}

class UserManager {
    private val users = listOf("Shiva", "Krishna")

    fun getUser(userName: String, callback: (String?) -> Unit) {
        val userFind = users.find { it == userName }
        callback(userFind)
    }
}


fun main() {
    val timer = Timer()
    println("Timer started...")
    timer.startTimer(3000) {
        println("Timer completed!")
    }
    /* output:
    Timer started...
    After starting the timer
    Timer completed!
    */
    println("After starting the timer")

    val userManager = UserManager()
    userManager.getUser("Shiva") { user ->
        if (user != null) {
            println("User found.")
        } else {
            println("User not found")
        }
    }  //output: User found.
}
