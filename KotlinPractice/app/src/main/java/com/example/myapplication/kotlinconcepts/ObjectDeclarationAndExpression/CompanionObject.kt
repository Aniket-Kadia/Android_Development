package com.example.myapplication.kotlinconcepts.ObjectDeclarationAndExpression

class University {
    companion object {
        val name = "GTU"
        val fees = 50000
        fun getLocation(): String {
            return "Ahmedabad"
        }
    }
}

fun main() {
    println("${University.name} is located at ${University.getLocation()} and their Annual fees is ${University.fees}")
    //output: GTU is located at Ahmedabad and their Annual fees is 50000
}