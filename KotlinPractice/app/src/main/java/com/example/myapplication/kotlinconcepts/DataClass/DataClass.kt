package com.example.myapplication.kotlinconcepts.DataClass

data class WeatherData(val location: String, val temperature: Double, val windSpeed: Double) {
    fun weatherUpdate() {
        println("Location: $location, Temperature: $temperature C, Wind Speed: $windSpeed km/h")
    }
}

data class WebPageState(
    val isSuccess: Boolean, val isFail: Boolean, val errorMessage: String
)

fun getCurrentWebPageStatus(state: WebPageState) {
    if (state.isSuccess) {
        println("Loading... Login successful.")
    } else if (state.isFail) {
        println("Login Unsuccessful.")
    } else {
        println(state.errorMessage)
    }
}

fun main() {
    val weatherOfAhmedabad = WeatherData("Ahmedabad", 35.7, 10.5)
    val weatherOfSurat = WeatherData("Surat", 33.2, 8.5)
    weatherOfSurat.weatherUpdate()  //output: Location: Surat, Temperature: 33.2 C, Wind Speed: 8.5 km/h

    //Data class toString()
    println(weatherOfAhmedabad.toString())  //output: WeatherData(location=Ahmedabad, temperature=35.7, windSpeed=10.5)

    //Copy Object
    val weatherOfBaroda = weatherOfSurat.copy()

    //equals()
    println("Weather of Baroda is same as Surat:  ${weatherOfBaroda.equals(weatherOfSurat)}")  //output: Weather of Baroda is same as Surat:  true

    //destructuring declarations
    val (city, temperature) = weatherOfAhmedabad
    println("$city temperature is $temperature celsius")  //output: Ahmedabad temperature is 35.7 celsius

    var loginPage = WebPageState(false, true, "Login Page Service Unavailable")
    getCurrentWebPageStatus(loginPage) //output: Login Unsuccessful.
    loginPage = loginPage.copy(isSuccess = true)
    getCurrentWebPageStatus(loginPage)  //output: Loading... Login successful.
    loginPage = loginPage.copy(false, false)
    getCurrentWebPageStatus(loginPage)  //output: Login Page Service Unavailable
}