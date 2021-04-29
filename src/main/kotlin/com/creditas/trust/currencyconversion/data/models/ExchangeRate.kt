package com.creditas.trust.currencyconversion.data.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class ExchangeRate(
    //AUD       BRL      EUR       IRR         USD
    @Id
    val id: String? = null,
    val AUD: String? = null,
    val BRL: String? = null,
    val EUR: String? = null,
    val IRR: String? = null,
    val USD: String? = null
)
