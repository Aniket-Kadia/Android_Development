package com.example.myapplication.kotlinconcepts.ControlFlow

fun main() {
    //If Expression
    val maxSalary = if (30_000 > 50_000) 30_000 else 50_000
    println("Maximum salary is: $maxSalary") //output: Maximum salary is: 50000

    //When statements
    when (3) {
        1 -> println("January")
        2 -> println("February")
        3 -> println("March")
        4 -> println("April")
        else -> println("default")
    }  //output: March

    //when as arbitrary function
    when (13) {
        in 1..10 -> println("Number from range 1 to 10")
        in 10..20 -> println("Number from range 10 to 20")
    }  //output: Number from range 10 to 20

    //For Loop
    for (i in 1..5) {
        println("Number: $i")
    }
    /* Output:
    Number: 1
    Number: 2
    Number: 3
    Number: 4
    Number: 5
    */

    //For Loop With Index
    val statesOfGujarat = arrayOf("Gujarat", "Goa", "rajasthan")
    for ((index, stateName) in statesOfGujarat.withIndex()) {
        println("$index = $stateName")
    }
    /* output:
    0 = Gujarat
    1 = Goa
    2 = rajasthan
    */

    //While Loop
    var rank = 1
    while (rank < 3) {
        println("Rank: $rank")
        rank++
    }
    /* output:
    Rank: 1
    Rank: 2
    */

    //Do-While Loop
    do {
        println(rank)
        rank++
    } while (rank < 0)  //output: 3

    //Break Statement
    for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) break
            println("Row: $i, Column: $j")
        }
    }
    /* output:
    Row: 1, Column: 1
    Row: 2, Column: 1
    Row: 3, Column: 1
    */

    //Continue Statement with Label
    label@ for (i in 1..3) {
        for (j in 1..3) {
            if (j == 3) continue@label
            println("Row: $i, Column: $j")
        }
    }
    /* output:
    Row: 1, Column: 1
    Row: 1, Column: 2
    Row: 2, Column: 1
    Row: 2, Column: 2
    Row: 3, Column: 1
    Row: 3, Column: 2
    */
}