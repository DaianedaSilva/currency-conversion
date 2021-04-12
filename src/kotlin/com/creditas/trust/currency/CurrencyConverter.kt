package com.creditas.trust.currency

object CurrencyConverter {

    private const val DEFAULT_NAME = "Nobody"

    private fun userGreet(): String {
        val nameFromStandardInput = readLine() ?: DEFAULT_NAME
        return "Hello $nameFromStandardInput"
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(userGreet())
    }
}

