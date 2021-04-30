package com.creditas.trust.currencyconversion.data.models

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class ExchangeRate(
    @Id
    val id: String? = null,
    val aud: Double = 0.0,
    val brl: Double = 0.0,
    val eur: Double = 0.0,
    val irr: Double = 0.0,
    val usd: Double = 0.0
)
