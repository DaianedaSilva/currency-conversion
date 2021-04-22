package com.creditas.trust.currency

import com.creditas.trust.currency.controllers.CurrencyConversion
import org.junit.Assert.assertEquals
import org.junit.Test


class CurrencyConversionTest {

    @Test
    fun `Get taxa X to Y`(){
        val result = CurrencyConversion().currencyConverse("BRL100 USD")
        assertEquals( "R$100.00 -> $17.74", result)
    }

    @Test
    fun `Get taxa BRL to BRL`(){
        val result = CurrencyConversion().currencyConverse("BRL100 BRL")

        assertEquals("R\$100.00 -> R\$100.00", result)
    }

    @Test
    fun `Get taxa BRL to EUR`(){
        val result = CurrencyConversion().currencyConverse("BRL100 EUR")

        assertEquals("R\$100.00 -> €14.91", result)
    }

    @Test
    fun `Get taxa BRL to IRR`(){
        val result = CurrencyConversion().currencyConverse("BRL100 IRR")

        assertEquals("R\$100.00 -> IRR749,372.54", result)
    }
    @Test
    fun `Get taxa BRL to USD`(){
        val result = CurrencyConversion().currencyConverse("BRL100 USD")

        assertEquals("R\$100.00 -> $17.64", result)
    }
}