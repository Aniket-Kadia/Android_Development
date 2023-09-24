package com.example.myapplication.kotlinconcepts.SealedClass

sealed class FoodOrder {
    class SuccessfulOrder(val minDeliveryTime: Int) : FoodOrder()
    class FailOrder(val reason: String) : FoodOrder()
}

fun processOrder(orderID: Int): FoodOrder {
    // Order processing
    println("Food order of order ID: $orderID is received")
    val orderIdOfSuccessPayment = listOf<Int>(13, 67)
    return if (orderIdOfSuccessPayment.contains(orderID)) {
        FoodOrder.SuccessfulOrder(25)
    } else {
        FoodOrder.FailOrder("Payment of order ID-$orderID is not received yet")
    }
}

fun main() {
    val response = processOrder(13)  //output: Food order of order ID: 13 is received
    when (response) {
        is FoodOrder.SuccessfulOrder -> {
            println("Order was successfully delivered and reach your home in ${response.minDeliveryTime} Minutes")
        }
        is FoodOrder.FailOrder -> {
            println("Failed to process order. Reason: ${response.reason}")
        }
    }  //output: Order was successfully delivered and reach your home in 25 Minutes
}