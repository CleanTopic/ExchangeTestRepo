package ru.cleantopic.feature.database.repository

import ru.cleantopic.feature.database.dao.FavoriteCurrencyDao
import ru.cleantopic.feature.database.models.CurrencyEntity

class FavoriteCurrencyRepository(private val favoriteCurrencyDao: FavoriteCurrencyDao) :
    FavoriteCurrencyDao {

    override suspend fun addCurrency(currency: CurrencyEntity) {
        favoriteCurrencyDao.addCurrency(currency)
    }

    override suspend fun getFavoriteCurrencies(): List<CurrencyEntity> {
        return favoriteCurrencyDao.getFavoriteCurrencies()
    }
}
