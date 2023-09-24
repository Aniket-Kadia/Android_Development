package com.example.myapplication.kotlinconcepts.BasicType

fun main() {
    //Integer Types
    val rank: Byte = 1  // Byte Type value of size 8 bits
    val price: Short = 1  // Short Type value of size 16 bits
    val salary: Int = 1  // Int Type value of size 32 bits
    val postLikes: Long = 1L  // Long Type value of size 64 bits

    //Floating-Points Types
    val petrolPrice: Float = 95.36F  //Float Type value of size 32 bits
    val temprature: Double = 40.50  // Double Type value of size 64 bits

    //Booleans
    val policyAcceptationStatus: Boolean = true

    //Characters
    val grade: Char = 'A'

    //String
    val companyName: String = "Simform"

    //Explicit Number Conversion
    //All number types support conversions to other types: toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble()
    val dieselPrice: Int = petrolPrice.toInt()
    println("Convert float ($petrolPrice) to Int ($dieselPrice)")  //output: Convert float (95.36) to Int (95)
}