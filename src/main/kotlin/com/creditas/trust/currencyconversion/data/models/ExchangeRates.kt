package com.creditas.trust.currencyconversion.data.models

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.result.Result
import com.google.gson.Gson

class ExchangeRates {

    data class Rates(
        val USD: Double = 1.0,
        val BRL: Double = 1.0,
        val EUR: Double = 1.0,
        val AUD: Double = 1.0,
        val IRR: Double = 1.0,
    )

    data class RatesExchange(
        val base: String,
        val date: String,
        val rates: Rates
    ) {

        class Deserializer : ResponseDeserializable<RatesExchange> {
            override fun deserialize(content: String) = Gson().fromJson(content, RatesExchange::class.java)
        }

    }
    fun captureSourceRates(from : String): Rates {
        val URL = Fuel.get("https://api.frankfurter.app/latest", listOf("from" to from))

        val (request, response, result) = URL.responseObject(RatesExchange.Deserializer())

        if (result is Result.Failure) {
            val ex = result.getException()
            println(ex)
        }

        val data = result.get()
        println(data)
        return data.rates
    }
}

fun main (){
    captureSourceRates("BRL")
}