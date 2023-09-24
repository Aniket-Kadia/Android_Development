package com.example.myapplication.kotlinconcepts.InterfaceAndAbstraction

//Normal Interface
interface IntPredicate {
    fun accept(i: Int): Boolean
}

//Functional Interface
fun interface NumberPredicate {
    fun accept(i: Int): Boolean
}

fun main() {
    //Normal Interface Implementation
    val isEven = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 == 0
        }
    }
    println("Number Even Status: ${isEven.accept(6)}")  //output: Number Even Status: true

    //Functional Interface Implementation
    val isOdd = NumberPredicate { it % 2 != 0 }
    println("Number Odd Status: ${isOdd.accept(3)}")  //output: Number Odd Status: true
}