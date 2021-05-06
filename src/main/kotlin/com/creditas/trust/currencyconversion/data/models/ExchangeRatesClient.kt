package com.creditas.trust.currencyconversion.data.models

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class ExchangeRatesClient {
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


}