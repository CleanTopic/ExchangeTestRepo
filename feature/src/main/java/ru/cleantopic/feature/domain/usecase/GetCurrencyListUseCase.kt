package ru.cleantopic.feature.domain.usecase

import ru.cleantopic.common.error.RequestResult
import ru.cleantopic.feature.domain.model.Currency
import ru.cleantopic.feature.domain.repository.FeatureRepository
import javax.inject.Inject

class GetCurrencyListUseCase @Inject constructor(private val featureRepository: FeatureRepository) {
    suspend operator fun invoke(currencyName: String): RequestResult<List<Currency>> {
        return featureRepository.getCurrencyList(currencyName)
    }
}
