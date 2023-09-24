package com.example.myapplication.kotlinconcepts.Property

//compile-time constant
const val COUNTRY =
    "INDIA" //It must be initialized with a value of type String or a primitive type and cannot be a custom getter

class Address {
    var state = "Gujarat"
        get() = field.uppercase() //a field is only used as a part of a property to hold its value in memory
        set(value) {
            field = value
        }

    //Late-initialized properties
    lateinit var city: String

    fun getMallAddress() {
        if (this::city.isInitialized) {
            println("Mall Location is: $COUNTRY, $state, $city")
        }
    }
}

fun main() {
    val mall = Address()
    mall.city = "Ahmedabad"
    mall.getMallAddress()  //output: Mall Location is: INDIA, GUJARAT, Ahmedabad
}