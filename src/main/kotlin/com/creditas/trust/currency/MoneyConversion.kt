package com.creditas.trust.currency


import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*

class MoneyConversion {

    fun convert(s: String, s1: String, s2: String): String {
        val tax = BigDecimal(6.7170).setScale(3, RoundingMode.HALF_EVEN)
        val value = BigDecimal(100)
        val result = tax.multiply(value)

        return String.format("%.2f", result)

    }


}
