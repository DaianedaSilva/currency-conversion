//package com.creditas.trust.currency
//
//import org.hamcrest.CoreMatchers.equalTo
//import org.junit.Assert.assertThat
//import org.junit.Test
//import java.math.BigDecimal
//
//class MoneyTest {
//
//    @Test
//    fun `adds its own amount to a big decimal`() {
//        val twentyTwo = Money("22.00")
//
//        val result = twentyTwo + BigDecimal("22.00")
//
//        assertThat(result, equalTo(Money("44.00")))
//    }
//
//    @Test
//    fun `adds to another money`() {
//        val ten = Money("10.00")
//        val five = Money("5.00")
//
//        val result = ten + five
//
//        assertThat(result, equalTo(Money("15.00")))
//    }
//}