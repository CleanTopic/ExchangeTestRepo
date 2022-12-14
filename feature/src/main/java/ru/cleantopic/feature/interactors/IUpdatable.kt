package ru.cleantopic.feature.interactors

import ru.cleantopic.feature.domain.model.FilterType

interface IUpdatable {
    fun update(currencyName: String)
    fun load(currencyName: String)
    fun filterBy(filterType: FilterType)
}
