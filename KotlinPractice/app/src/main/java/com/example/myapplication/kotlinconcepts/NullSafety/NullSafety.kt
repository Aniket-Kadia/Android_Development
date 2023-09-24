package com.example.myapplication.kotlinconcepts.NullSafety

fun main() {
    //Not-Null type Value
    var firstName = "Shiva"
    //name = null   This line Gives Error Because Null can not be a value of a non-null type String
    val carName: String? = null

    //if you want to perform operation on Nullable type value, that would not be safe.
    //Way to handle Nullable type value
    //Check Nullability
    val length = if (carName != null) carName.length else 0
    println("car name length is $length")  //output: car name length is 0

    //safe call operator:   ?.
    println("College Name length is ${carName?.length}")  //output: College Name length is null

    //Elvis operator:   ?:
    var exceptionName: String? = "IndexOutOfBoundException"
    println("Exception: $exceptionName")  //output: Exception: IndexOutOfBoundException
    exceptionName = null
    println("Exception: ${exceptionName?.length ?: "No Exception"}")  //output: Exception: No Exception

    //NotNull assertion operator (!!.)
    val salary: Int? = 50000
    println("Salary is ${salary!!.toDouble()}")  //output: Salary is 50000.0

    //Safe Cast: as?
    val state: Any = "Gujarat"
    val stateOfIndia: String? = state as? String
    println("India State List: $state") //output: India State List: Gujarat
}