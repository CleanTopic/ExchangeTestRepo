package ru.cleantopic.feature.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.cleantopic.common.error.RequestResult
import ru.cleantopic.feature.data.source.FeatureDataSource
import ru.cleantopic.feature.domain.model.Currency
import ru.cleantopic.feature.domain.repository.FeatureRepository
import javax.inject.Inject

class FeatureRepositoryImpl @Inject constructor(private val featureDataSource: FeatureDataSource) :
    FeatureRepository {
    override suspend fun getCurrencyList(currencyName: String): RequestResult<List<Currency>> =
        withContext(Dispatchers.IO) {
            return@withContext featureDataSource.getCurrencyList(currencyName)
        }
}
