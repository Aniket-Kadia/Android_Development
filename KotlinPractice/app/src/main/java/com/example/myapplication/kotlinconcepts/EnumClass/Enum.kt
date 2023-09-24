package com.example.myapplication.kotlinconcepts.EnumClass

enum class Country(val countryDialCode: Int) {
    INDIA(91), USA(1), AUSTRALIA(61), NEPAL(977), RUSSIA(7)
}

enum class DatabaseAction {
    CONNECT, REQUEST, RESPONSE, DISCONNECT
}

class DatbaseHandler {
    fun ManageAction(action: DatabaseAction) {
        when (action) {
            DatabaseAction.CONNECT -> println("Connection Established successful.")
            DatabaseAction.REQUEST -> println("Send Data Request To Server")
            DatabaseAction.RESPONSE -> println("Get Response from Server")
            DatabaseAction.DISCONNECT -> println("Connection Terminated")
        }
    }
}

fun main() {

    val currentCountry = Country.INDIA
    println("Dial Code of ${currentCountry.name} is ${currentCountry.countryDialCode}")  //output: Dial Code of INDIA is 91
    for (countryList in Country.values()) {
        println("${countryList.name} Dial Code: ${countryList.countryDialCode}")
    }
    /*
    INDIA Dial Code: 91
    USA Dial Code: 1
    AUSTRALIA Dial Code: 61
    NEPAL Dial Code: 977
    RUSSIA Dial Code: 7
    */

    val requestHandler = DatbaseHandler()
    requestHandler.ManageAction(DatabaseAction.CONNECT)  //output: Connection Established successful.
    requestHandler.ManageAction(DatabaseAction.REQUEST)  //output: Send Data Request To Server
    requestHandler.ManageAction(DatabaseAction.RESPONSE)  //output: Get Response from Server
    requestHandler.ManageAction(DatabaseAction.DISCONNECT)  //output: Connection Terminated
}