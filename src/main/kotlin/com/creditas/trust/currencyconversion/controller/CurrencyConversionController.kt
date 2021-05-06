package com.creditas.trust.currencyconversion.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import com.creditas.trust.currencyconversion.service.CurrencyConversionService
//import com.creditas.trust.currencyconversion.service.ExchangeRageService

@RestController
class CurrencyConversionController(val service: CurrencyConversionService) {

    @GetMapping("/")
    fun hello() = "CURRENCY   CONVERSION!"


    @GetMapping("/currencies-conversion")
    public fun converter(userInput: String): String {

        return service.currencyConverse(userInput)
    }


}