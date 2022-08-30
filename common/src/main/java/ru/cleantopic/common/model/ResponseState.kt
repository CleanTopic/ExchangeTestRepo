package ru.cleantopic.common.model

import ru.cleantopic.common.error.ErrorEntity

sealed class ResponseState {
    object Initial : ResponseState()
    object Progress : ResponseState()
    object Success : ResponseState()
    data class Error(val error: ErrorEntity) : ResponseState()
    data class Failure(val error: ResponseError) : ResponseState()
}
