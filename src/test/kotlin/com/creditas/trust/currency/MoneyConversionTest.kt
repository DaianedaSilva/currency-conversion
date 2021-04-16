package com.creditas.trust.currency

import org.junit.Assert.assertEquals
import org.junit.Test
<<<<<<< HEAD:src/test/kotlin/com/creditas/trust/currency/MoneyTest.kt
import org.junit.experimental.theories.suppliers.TestedOn
import java.math.BigDecimal
=======
>>>>>>> ae5ada534bced567b44092e96778e73ac2b72023:src/test/kotlin/com/creditas/trust/currency/MoneyConversionTest.kt

class MoneyConversionTest {

    @Test
    fun `Converts 100 BRL to USD currency`() {
        val result = MoneyConversion().convert("BRL", "100", "USD")

        assertEquals("563,60", result)
    }

    @Test
    fun `Converts 100 BRL to EUR currency`() {
        val result = MoneyConversion().convert("BRL", "100", "EUR")

        assertEquals("671.70", result)
    }




//    @Test
//    fun `adds its own amount to a big decimal`() {
//        val twentyTwo = Money("22.00")
//
//        //val result = twentyTwo + BigDecimal("22.00")
//
//        //assertThat(result, equalTo(Money("44.00")))
//    }
//
//
//    @Test
//    fun `adds to another money`() {
//        val ten = Money("10.00")
//        val five = Money("5.00")
//
//        //val result = ten five
//
//        //assertThat(result, equalTo(Money("15.00")))
//    }
}