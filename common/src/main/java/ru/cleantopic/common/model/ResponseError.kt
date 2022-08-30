package ru.cleantopic.common.model

import androidx.annotation.StringRes
import ru.cleantopic.common.R
import ru.cleantopic.common.error.ErrorEntity

sealed class ResponseError(@StringRes val errResId: Int) : ErrorEntity {

    object ConnectionError : ResponseError(R.string.error_connection)
    object UnknownError : ResponseError(R.string.error_unknown)
}
