package com.creditas.trust.currencyconversion.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import com.creditas.trust.currencyconversion.models.CurrencyConversion

@RestController
class CurrencyConversionController {

    @GetMapping("/")
    fun hello() = "CURRENCY   CONVERSION!"


    @GetMapping("/currencies-conversion")
    public fun converter(userInput: String): String {

        return CurrencyConversion().currencyConverse(userInput)
    }


}