package com.example.myapplication.kotlinconcepts.Delegation

interface Giftwrap {
    fun giftWrap()
}

class packageCookie : Giftwrap {
    override fun giftWrap() {
        println("Gift Wrapping is completed.")
    }
}

interface Transfer {
    fun transfer()
}

class Delivery : Transfer {
    override fun transfer() {
        println("Gift of cookie is left for delivery and reach at your location in some time.")
    }
}

class Cookies(transfer: Transfer, gift: Giftwrap) : Transfer by transfer, Giftwrap by gift {
    fun makeCookie() {
        println("Cookie is Ready.")
    }

    fun getCookieWithGiftPackage() {
        giftWrap()
        transfer()
    }
}

fun main() {
    val cookie = Cookies(Delivery(), packageCookie())
    cookie.makeCookie()  //Cookie is Ready.
    cookie.getCookieWithGiftPackage()
    /*
    Gift Wrapping is completed.
    Gift of cookie is left for delivery and reach at your location in some time.
    */
}