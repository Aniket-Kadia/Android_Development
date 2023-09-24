package com.example.myapplication.kotlinconcepts.ClassAndInheritance

open class RBI(val bankName: String, val bankCode: Int, open val LoanInterestRate: Double = 2.50) {
    init {
        println("New Bank Register Under RBI")
    }

    open fun getDetails() {
        println("Bank Name: $bankName \nBank Code: $bankCode \nLoan Interest Rate: $LoanInterestRate%")
    }
}

class BOB(bankName: String, bankCode: Int, LoanInterestRate: Double) :
    com.example.myapplication.kotlinconcepts.ClassAndInheritance.RBI(bankName, bankCode, LoanInterestRate) {
    init {
        println("Complete process of registration BOB bank with RBI")
    }

    override fun getDetails() {
        println("$bankName Bank is Under RBI")
        super.getDetails()
    }
}

class HDFC(bankName: String, bankCode: Int, LoanInterestRate: Double) :
    com.example.myapplication.kotlinconcepts.ClassAndInheritance.RBI(bankName, bankCode, LoanInterestRate) {
    init {
        println("Complete process of registration HDFC bank with RBI")
    }

    override fun getDetails() {
        println("$bankName Bank is Under RBI")
        super.getDetails()
    }
}

fun main() {
    val bobBank =
        com.example.myapplication.kotlinconcepts.ClassAndInheritance.BOB("Bank Of Baroda", 15, 2.40)
    bobBank.getDetails()
    /* output:
    New Bank Register Under RBI
    Complete process of registration BOB bank with RBI
    Bank Of Baroda Bank is Under RBI
    Bank Name: Bank Of Baroda
    Bank Code: 15
    Loan Interest Rate: 2.4%
    */

    val hdfcBank =
        com.example.myapplication.kotlinconcepts.ClassAndInheritance.HDFC("HDFC", 30, 3.20)
    hdfcBank.getDetails()
    /* output:
    New Bank Register Under RBI
    Complete process of registration HDFC bank with RBI
    HDFC Bank is Under RBI
    Bank Name: HDFC
    Bank Code: 30
    Loan Interest Rate: 3.2%
    */
}