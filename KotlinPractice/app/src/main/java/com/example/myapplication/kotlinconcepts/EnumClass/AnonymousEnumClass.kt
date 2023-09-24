package com.example.myapplication.kotlinconcepts.EnumClass

interface SeasonData {
    fun seasonDescription()
}

enum class Season(val SeasonName: String) : SeasonData {
    WINTER("winter") {
        override fun seasonDescription() {
            println("Cold Environment")
        }
    },
    SUMMER("Summer") {
        override fun seasonDescription() {
            println("Hot Environment")
        }
    },
    MONSOON("Monsoon") {
        override fun seasonDescription() {
            println("Rainy Environment")
        }
    }
}

fun main() {
    Season.WINTER.seasonDescription()  //output: Cold Environment
    Season.MONSOON.seasonDescription()  //output: Rainy Environment
}