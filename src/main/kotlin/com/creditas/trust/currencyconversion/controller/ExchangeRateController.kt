package com.creditas.trust.currencyconversion.controller

import com.creditas.trust.currencyconversion.data.repository.ExchengeRateRepository
import com.creditas.trust.currencyconversion.data.models.ExchangeRate

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("exchange-rate")
class ExchengeRateController (val repository: ExchengeRateRepository){

    @PostMapping
    fun addExchengeRates(@RequestBody exchengeRate: ExchangeRate) = ResponseEntity.ok(repository.save(exchengeRate))


    @GetMapping
    fun readAllExchangeRate() = ResponseEntity.ok(repository.findAll())


    @GetMapping("/{idSoucer}")
    fun getSouceRates(@PathVariable("idSoucer") idSoucer:String) = ResponseEntity.ok(repository.findById(idSoucer))


    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: String){
        val exchangeRate = repository.findById(id)
            .ifPresent{ repository.delete(it)}
    }

}