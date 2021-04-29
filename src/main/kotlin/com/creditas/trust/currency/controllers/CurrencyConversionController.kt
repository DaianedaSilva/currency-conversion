package com.creditas.trust.currency.controllers

import com.creditas.trust.currency.models.CurrencyConversion
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class CurrencyConversionController {

    @GetMapping("/")
    fun hello() = "CURRENCY   CONVERSION!"


    @GetMapping("/currencies-conversion")
    public fun converter(userInput: String): String {

        return CurrencyConversion().currencyConverse(userInput)
    }

}