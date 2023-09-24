package com.example.myapplication.kotlinconcepts.Function

fun main() {

    //Function with parameters and Explicit return type
    fun totalLoanPayment(rupees: Double, interestRate: Double, totalYear: Int): String {
        return "You have to pay total ${rupees + (rupees * interestRate * totalYear)} rupees in $totalYear year"
    }
    println(totalLoanPayment(530000.0, 0.05, 6))  //output: You have to pay total 689000.0 rupees in 6 year

    //Function With Default parameter
    fun setAddress(city: String, state: String, country: String = "India") {
        println("Your Home Location Is $city, $state, $country")
    }
    setAddress("Ahmedabad", "Gujarat") //output: Your Home Location Is Ahmedabad, Gujarat, India

    //Single-expression function: When a function returns a single expression, the curly braces can be omitted and the body is specified after a = symbol
    fun calculateAge(yearOfBirth: Int): Int = 2023 - yearOfBirth
    println("My Age is: ${calculateAge(2002)}")  //output: My Age is: 21

    //Variable Number Of Argument
    fun subjectList(vararg subject: String) {
        println("You Current Standard Subject is:")
        subject.forEach { println(it) }
    }
    subjectList("Maths", "Science", "English")
    /* output:
    You Current Standard Subject is:
    Maths
    Science
    English
    */

    //Infix Function
    data class Location(val state: String, val country: String) {
        infix fun toMove(other: Location) {
            println("Person Move to $state, $country to ${other.state}, ${other.country}")
        }
    }
    val currentLocation = Location("Gujarat", "India")
    val anotherLocation = Location("Bangalore", "India")
    currentLocation toMove anotherLocation //output: Person Move to Gujarat, India to Bangalore, India
}