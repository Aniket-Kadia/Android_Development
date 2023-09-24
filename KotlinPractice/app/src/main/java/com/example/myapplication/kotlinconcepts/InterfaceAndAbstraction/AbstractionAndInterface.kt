package com.example.myapplication.kotlinconcepts.InterfaceAndAbstraction

interface specialAbility {
    fun SpecialPower()
}

abstract class Character(val name: String) : specialAbility {
    abstract fun move()
    abstract fun attack()
}

class Sage(name: String) : Character(name) {
    override fun move() {
        println("$name is Move with 3kmph speed")
    }

    override fun attack() {
        println("$name Attack point is 10")
    }

    override fun SpecialPower() {
        println("$name have special ability of revive another player")
    }
}

class Jatt(name: String) : Character(name) {
    override fun move() {
        println("$name is Move with 5kmph speed")
    }

    override fun attack() {
        println("$name Attack point is 30")
    }

    override fun SpecialPower() {
        println("$name have special ability of Create wall of fire")
    }
}

fun main() {
    val sage = Sage("sage")
    sage.attack()  //output: sage Attack point is 10
    sage.move()  //output: sage is Move with 3kmph speed
    sage.SpecialPower()  //output: sage have special ability of revive another player

    val viper = Jatt("viper")
    viper.attack()  // output: viper Attack point is 30
    viper.move() //output: viper is Move with 5kmph speed
    viper.SpecialPower() //output: viper have special ability of Create wall of fire
}