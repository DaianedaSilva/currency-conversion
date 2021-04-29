package com.creditas.trust.currencyconversion.data.repository

import com.creditas.trust.currencyconversion.data.models.ExchangeRate

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ExchengeRateRepository : MongoRepository<ExchangeRate, String> {
}