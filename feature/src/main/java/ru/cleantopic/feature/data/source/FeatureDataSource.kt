package ru.cleantopic.feature.data.source

import ru.cleantopic.common.error.RequestResult
import ru.cleantopic.feature.domain.model.Currency

interface FeatureDataSource {
    suspend fun getCurrencyList(currencyName: String): RequestResult<List<Currency>>
}
