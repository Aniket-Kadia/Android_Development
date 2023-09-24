package com.example.myapplication.kotlinconcepts.ControlFlow

import java.lang.Exception

//Custom Exception Class
class AgeException() : Exception("Not a Valid Age")

fun main() {
    val productData = "product_32i7u"
    var productNumber = try {
        productData.toInt()
    } catch (e: Throwable) {
        println("Error: Can't covert String to Int")
    }  //output: Error: Can't covert String to Int

    fun divide(a: Int, b: Int) {
        try {
            print(a / b)
        } catch (E: ArithmeticException) {
            println(E)
        }
    }
    divide(15, 0)  // output: java.lang.ArithmeticException: / by zero

    //Use Of Custom Exception
    val age = 16
    try {
        if (age < 18) {
            throw AgeException()
        }
    } catch (e: AgeException) {
        println(e.message)
    }  //output: Not a Valid Age
}