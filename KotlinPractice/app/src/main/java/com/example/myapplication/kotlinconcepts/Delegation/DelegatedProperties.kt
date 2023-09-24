package com.example.myapplication.kotlinconcepts.Delegation

import kotlin.properties.Delegates

fun main() {
    //Lazy Properties
    val baseSalary: Double by lazy {
        println("Set Base Salary Value")
        30000.00
    }
    println(baseSalary)
    /*output:
    Set Base Salary Value
    30000.0
    */
    println(baseSalary)  //output: 30000.0

    //Observable Properties
    var fileName: String by Delegates.observable("text.kt") { propertyName, oldValue, newValue ->
        println("File name is refactor from $oldValue to $newValue")
    }
    fileName = "delegation.kt"  //output: File name is refactor from text.kt to delegation.kt

    //Vetoable Properties: It allows us to modify the values when the argument input by the user(s) fulfills the specified condition
    var age: Int by Delegates.vetoable(0) { propertyName, oldValue, newValue ->
        println("Will Change Age Value: $oldValue to $newValue")
        newValue > oldValue
    }

    fun setAge(ageValue: Int) {
        age = ageValue
        println("Your Age is $age")
    }
    setAge(10)
    /*
    Will Change Age Value: 0 to 10
    Your Age is 10
    */
    setAge(5)
    /*
    Will Change Age Value: 10 to 5
    Your Age is 10
    */
    setAge(15)
    /*
    Will Change Age Value: 10 to 15
    Your Age is 15
    */
}