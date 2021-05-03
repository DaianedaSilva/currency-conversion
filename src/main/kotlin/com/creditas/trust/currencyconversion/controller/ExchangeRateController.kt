package com.creditas.trust.currencyconversion.controller

import com.creditas.trust.currencyconversion.data.models.ExchangeRate
import com.creditas.trust.currencyconversion.service.ExchangeRageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("exchange-rate")
class ExchengeRateController(val service: ExchangeRageService) {

    @PostMapping
    fun addExchengeRates(@RequestBody exchengeRate: ExchangeRate) = ResponseEntity.ok(service.save(exchengeRate))

    @GetMapping
    fun readAllExchangeRate() = ResponseEntity.ok(service.findAll())

    @GetMapping("/{id}")
    fun getSourceRates(@PathVariable("id") id: String): ResponseEntity<ExchangeRate> {
        return ResponseEntity.ok(service.findById(id))
    }

    @GetMapping("/get-rate/{id-source}/{id-target}")
    fun getRateForConversion(
        @PathVariable("id-source") idSource: String,
        @PathVariable("id-target") idTarget: String
    ): Double {

         return service.getRate(idSource, idTarget)
    }


    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: String) {
        service.delete(id)
    }

}