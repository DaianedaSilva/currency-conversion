//package com.creditas.trust.currencyconversion.data.models
//
//import com.github.kittinunf.fuel.Fuel
//import com.github.kittinunf.fuel.core.ResponseDeserializable
//import com.github.kittinunf.result.Result
//import com.google.gson.Gson
//
//class ExchangeRates {
//
//    data class Rates2(
//        val USD: Double = 1.0,
//        val BRL: Double = 1.0,
//        val EUR: Double = 1.0,
//        val AUD: Double = 1.0,
//        val IRR: Double = 1.0,
//    )
//
//    data class RatesExchange(
//        val base: String,
//        val date: String,
//        val rates: Rates2
//    ) {
//
//        class Deserializer : ResponseDeserializable<RatesExchange> {
//            override fun deserialize(content: String) = Gson().fromJson(content, RatesExchange::class.java)
//        }
//
//    }
//    fun captureSourceRates(from : String): Rates2 {
//        val URL = Fuel.get("https://api.frankfurter.app/latest", listOf("from" to from))
//
//        val (request, response, result) = URL.responseObject(RatesExchange.Deserializer())
//        when(result){
//            is Result.Failure -> {
//                val ex = result.getException()
//                println(ex)
//            }
//            is Result.Success ->{
//                val data = result.get()
//                return data.rates
//            }
//        }
//        throw IllegalArgumentException(from)
//    }
//}
//
//fun main (){
//    captureSourceRates("BRL")
//}