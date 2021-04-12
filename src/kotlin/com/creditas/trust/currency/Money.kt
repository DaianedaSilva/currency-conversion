package com.creditas.trust.currency

import java.math.BigDecimal

data class Money(private val amount: BigDecimal) {

    constructor(amount: String) : this(BigDecimal(amount))

    operator fun plus(a: BigDecimal) = Money(amount + a)

    operator fun plus(other: Money) = Money(amount + other.amount)
}