package com.creditas.trust.currencyconversion.service

import com.creditas.trust.currencyconversion.data.models.ExchangeRate
import com.creditas.trust.currencyconversion.data.repository.ExchengeRateRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException


@Service
class ExchangeRageService(val repository: ExchengeRateRepository) {
    val AUD = ExchangeRate("AUD", 1.0, 4.3009, 0.6403, 32631.3775, 0.7630)
    val BRL = ExchangeRate("BRL", 0.2324, 1.0, 0.1491, 7493.7254, 0.1774)
    val EUR = ExchangeRate("EUR", 1.5616, 6.7170, 1.0, 50403.8615, 1.5615)
    val IRR = ExchangeRate("IRR", 0.0000, 0.0001, 0.0000, 1.0, 0.0000)
    val USD = ExchangeRate("USD", 1.31021, 5.6360, 0.8380, 42105.0068, 1.0)

    init {
        initData()
    }

    fun initData() {
        repository.save(AUD)
        repository.save(BRL)
        repository.save(EUR)
        repository.save(IRR)
        repository.save(USD)
    }

    fun getRate(source: String, target: String) : Double{

        val sourceRates = findById(source)

        when(target.toLowerCase()){
            "aud" -> return sourceRates.aud
            "brl" -> return sourceRates.brl
            "eur" -> return sourceRates.eur
            "irr" -> return sourceRates.irr
            "usd" -> return sourceRates.usd

        }

        return 0.0
    }


    fun findById(id: String): ExchangeRate {
        return repository.findById(id).orElseThrow {
            RuntimeException("Currency not found: $id")
        }
    }

    fun save(exchengeRate: ExchangeRate): ExchangeRate {
        return repository.save(exchengeRate)
    }

    fun findAll(): List<ExchangeRate> {
        return repository.findAll()
    }

    fun delete(id: String) {
        val source = findById(id)
        repository.delete(source)
    }
}