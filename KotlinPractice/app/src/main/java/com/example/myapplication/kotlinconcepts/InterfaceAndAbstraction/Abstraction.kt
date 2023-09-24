package com.example.myapplication.kotlinconcepts.InterfaceAndAbstraction

abstract class Employee(val employeeId: String, val name: String) {
    abstract fun calculateMonthlySalary(): Int

    fun displayEmployeeSalary() {
        println("$name Salary is: ${calculateMonthlySalary()}")
    }
}

class Manager(employeeId: String, name: String, val baseSalary: Int, val bonus: Int) :
    Employee(employeeId, name) {
    override fun calculateMonthlySalary(): Int {
        return baseSalary + bonus
    }
}

class Developer(employeeId: String, name: String, val baseSalary: Int, val overtimePay: Int) :
    Employee(employeeId, name) {
    override fun calculateMonthlySalary(): Int {
        return baseSalary + overtimePay
    }
}

fun main() {
    val developer = Developer("E123", "Shiva", 50000, 5000)
    developer.displayEmployeeSalary()  //output: Shiva Salary is: 55000

    val manager = Manager("M12", "Krishna", 70000, 7000)
    manager.displayEmployeeSalary()  //output: Krishna Salary is: 77000
}