package com.creditas.trust.currencyconversion.client

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class ExchangeRatesClient {


    data class RatesExchange(
        val base: String,
        val date: String,
        val rates: Rates
    ) {

        class Deserializer : ResponseDeserializable<RatesExchange> {
            override fun deserialize(content: String) = Gson().fromJson(content, RatesExchange::class.java)
        }

    }

    data class Rates(
        val USD: Double,
        val BRL: Double,
        val EUR: Double,
        val AUD: Double,
        val ILS: Double,
    )


    fun captureSourceRates(from : String): ExchangeRatesClient.Rates {
        val URL = Fuel.get("https://api.frankfurter.app/latest", listOf("from" to from))

        val (request, response, result) = URL.responseObject(ExchangeRatesClient.RatesExchange.Deserializer())
        when(result){
            is Result.Failure -> {
                val ex = result.getException()
                println(ex)
            }
            is Result.Success ->{
                val data = result.get()
                return data.rates
            }
        }
        throw IllegalArgumentException(from)
    }
}