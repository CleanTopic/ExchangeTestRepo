package ru.cleantopic.feature.main_screen.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.cleantopic.common.base.BaseViewModel
import ru.cleantopic.common.error.RequestResult
import ru.cleantopic.common.model.ResponseState
import ru.cleantopic.feature.domain.usecase.GetCurrencyListUseCase

class MainScreenViewModel(
    private val getCurrencyListUseCase: GetCurrencyListUseCase
) : BaseViewModel() {

    private val _currencyTitles: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val currencyTitles: StateFlow<List<String>> get() = _currencyTitles

    init {
        getCurrencyTitles()
    }

    private fun getCurrencyTitles() {
        viewModelScope.launch {
            setEventState(ResponseState.Initial)
            when (val call = getCurrencyListUseCase.invoke("AED")) {
                is RequestResult.Success -> {
                    _currencyTitles.value = call.data.map { it.name }
                    setEventState(ResponseState.Success)
                }
                is RequestResult.Error -> {
                    setEventState(ResponseState.Error(call.error))
                }
            }
        }
    }
}
