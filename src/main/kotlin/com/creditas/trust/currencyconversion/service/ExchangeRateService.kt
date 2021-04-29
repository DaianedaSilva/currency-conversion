package com.creditas.trust.currencyconversion.service

import org.springframework.stereotype.Service

import com.creditas.trust.currencyconversion.controller.ExchengeRateController
import com.creditas.trust.currencyconversion.data.models.ExchangeRate

@Service
class ExchangeRageService(val controller: ExchengeRateController) {
    val AUD = ExchangeRate("AUD", "1.0","4.3009" , "0.6403","32631.3775", "0.7630")
    val BRL = ExchangeRate("BRL", "0.2324","1.0" , "0.1491","7493.7254", "0.1774")
    val EUR = ExchangeRate("EUR", "1.5616","6.7170" , "1.0","50403.8615", "1.5615")
    val IRR = ExchangeRate("IRR", "0.0000","0.0001" , "0.0000","1.0", "0.0000")
    val USD = ExchangeRate("USD", "1.31021","5.6360" , "0.8380","42105.0068", "1.0")

    init {
        controller.addExchengeRates(AUD)
        controller.addExchengeRates(BRL)
        controller.addExchengeRates(EUR)
        controller.addExchengeRates(IRR)
        controller.addExchengeRates(USD)
    }
}