package com.creditas.trust.currency.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloAplication {

    @RequestMapping("/")
    fun hello() = "CURRENCY   CONVERSION!"
}