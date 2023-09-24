package com.example.myapplication.kotlinconcepts.BasicType

fun main() {
    //Type Check
    val greetings = "Welcome"
    if (greetings is String) {
        println("$greetings length is ${greetings.length}")  //output: Welcome length is 7
    } else {
        println("Not a String")
    }

    //Smart cast
    val imgDetails: Any = "Lion Image"
    if (imgDetails is String) {
        println("$imgDetails text length is ${imgDetails.length}")  //output: Lion Image text length is 10
    }

    val LicenseNumber = null
    //Unsafe Cast: Unsafe cast means cast operator throws an exception if the cast isn't possible.
    //val licenseNumberValidate: Long = LicenseNumber as Long  //output: NullPointerException: null cannot be cast to non-null type kotlin.Long

    //Safe Cast:  To avoid exceptions, use the safe cast operator as?, which returns null on failure.
    val licenseNumberValidate: Long? = LicenseNumber as? Long
    println(licenseNumberValidate)  //output: null
}