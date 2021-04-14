package com.creditas.trust.currency

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt

class Money {


    fun convert(s: String, s1: String, s2: String): String {
        val tax = BigDecimal(6.7170).setScale(3, RoundingMode.HALF_EVEN)
        val value = BigDecimal(100)
        val result = tax.multiply(value)

        val dec = DecimalFormat("####.##")


        return dec.format(result)

    }

}
