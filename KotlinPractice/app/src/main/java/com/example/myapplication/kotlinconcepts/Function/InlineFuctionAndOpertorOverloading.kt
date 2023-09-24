package com.example.myapplication.kotlinconcepts.Function

//Inline Function
inline fun executeTransaction(transaction: () -> Unit) {
    println("Transaction started")
    try {
        transaction()
        println("Transaction successful")
    } catch (e: Exception) {
        println("Transaction failed: ${e.message}")
    } finally {
        println("Transaction ended")
    }
}

fun performTransaction() {
    println("Performing transaction...")
    throw Exception("Transaction failed: Insufficient funds")
}

//Operator Overloading
data class Empolyee(val name: String) {
    operator fun plus(other: Empolyee) {
        println("Employee: $name, ${other.name} in Simform Solutions")
    }
}

fun main() {
    executeTransaction {
        performTransaction()
    }
    /*
    Transaction started
    Performing transaction...
    Transaction failed: Transaction failed: Insufficient funds
    Transaction ended
    */

    val employeeShiva = Empolyee("Shiva")
    val employeeYash = Empolyee("Yash")
    employeeShiva + employeeYash  //output: Employee: Shiva, Yash in Simform Solutions
}