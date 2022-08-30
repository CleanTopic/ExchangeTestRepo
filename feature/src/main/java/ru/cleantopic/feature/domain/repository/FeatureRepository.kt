package ru.cleantopic.feature.domain.repository

import ru.cleantopic.common.error.RequestResult
import ru.cleantopic.feature.domain.model.Currency

interface FeatureRepository {
    suspend fun getCurrencyList(currencyName: String): RequestResult<List<Currency>>
}
