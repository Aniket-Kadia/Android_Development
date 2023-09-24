package com.example.myapplication.kotlinconcepts.NestedAndInnerClass

class FoodFranchise {
    private val name: String = "PizzaPoint"
    private val transpotationCompany: String = "FastSpeed"

    //Nested Class
    class RanipBranch {
        val branchName = "Ranip"
        val todayProfit = 20000

        //Nested Class
        fun getProfitDetails() {
            println("$branchName today profit is $todayProfit")
        }
    }

    //Inner Class
    inner class IskonBranch {
        val branchName = "Ranip"
        val todayProfit = 20000

        fun getProfitDetails() {
            println("$transpotationCompany delivered raw items within time and $name $branchName branch today profit is $todayProfit ")
        }
    }
}

fun main() {
    FoodFranchise.RanipBranch().getProfitDetails()  //output: Ranip today profit is 20000
    FoodFranchise().IskonBranch().getProfitDetails()  //output: FastSpeed delivered raw items within time and PizzaPoint Ranip branch today profit is 20000
}