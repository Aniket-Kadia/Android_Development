package com.example.myapplication.kotlinconcepts.Extension

//Extension Function
fun MutableList<Int>.swapping(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

//Extensions resolved statically
open class Defence
class Army : Defence()
fun Defence.getClassName() = "Defence"
fun Army.getClassName() = "Army"
fun printClassName(objectOf: Defence) {
    println("Class Name: ${objectOf.getClassName()}")
}

class Bank(var balance: Int) {
    fun addMoney(amount: Int) {
        println("Current Balance is: $balance")
        balance += amount
        println("Add $amount and current balance is ${balance}")
    }
}

fun Int.Dollar(): Int {
    return this * 80
}

fun main() {
    val rank = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Before Swapping List: $rank")  //output: Before Swapping List: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    rank.swapping(3, 7)
    println("After Swapping List: $rank")  //output: After Swapping List: [1, 2, 3, 8, 5, 6, 7, 4, 9, 10]

    //Extensions function resolved statically
    printClassName(Army()) //output: Class Name: Defence

    var account = Bank(100)
    account.addMoney(200)
    /* output:
    Current Balance is: 100
    Add 200 and current balance is 300
    */
    account.addMoney(10.Dollar())
    /* output:
    Current Balance is: 300
    Add 800 and current balance is 1100
    */

    //Library class using extension function
    fun Int.abs(): Int {
        return if (this < 0) -this else this
    }

    val num = -10
    println("Apply abs() function on $num and result is : ${num.abs()}")  //output: Apply abs() function on -10 and result is : 10
}