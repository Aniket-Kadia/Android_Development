package com.example.myapplication.kotlinconcepts.ScopeFunction

data class Bank(val bankName: String, val branchName: String)
data class Credentials(var userName: String = "", var password: String = "")

fun main() {

    //LET
    val universityName: String = "  Gujarat technological university  "
    val formatUniversityName = universityName.let {
        println("University Name is:")
        it.trim().uppercase()
    }
    println(formatUniversityName) //output: University Name is: GUJARAT TECHNOLOGICAL UNIVERSITY

    //RUN
    val sbi = Bank("SBI", "Ranip").run {
        "My bank name is $bankName with branchName $branchName"
    }
    println(sbi)  //output: My bank name is SBI with branchName Ranip

    //WITH
    val numbers = mutableListOf(1, 2, 3, 4, 5)
    with(numbers) {
        add(6)
        remove(2)
        println(this)
    } //output: [1, 3, 4, 5, 6]

    //APPLY
    val userCredentials = Credentials().apply {
        userName = "root"
        password = "root@123"
    }
    println(userCredentials)  //output: Credentials(userName=root, password=root@123)

    //ALSO
    val country = "India"
    val uppercaseText = country.also { println("Country name is: $it") }.uppercase().also { println("Formatted Country name is: $it") } //output: Country name is: India
    numbers.also {
        println("Original list: $it")  //output: Original list: [1, 3, 4, 5, 6]
        it.removeIf { number -> number % 2 == 0 }
        println("Modified list: $it")  //output: Modified list: [1, 3, 5]
    }
}