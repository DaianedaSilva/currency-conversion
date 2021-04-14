package com.creditas.trust.currency

import org.junit.Test
import kotlin.test.assertEquals

class InputSplitTest {

    @Test
    fun `Should split value from currency on input`(){
        val input = "BRL100 USD"

        val result = InputSplit().split(input)

        assertEquals("BRL", result[0])
        assertEquals("100", result[1])
        assertEquals("USD", result[2])
    }
}

data class Money(
    val currency: String, // "BRL"
    val amount : String // "100"

)