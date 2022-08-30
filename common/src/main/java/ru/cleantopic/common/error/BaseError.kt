package ru.cleantopic.common.error

import androidx.annotation.StringRes
import ru.cleantopic.common.R

sealed class BaseError(@StringRes val errResId: Int) : ErrorEntity {
    object Error : BaseError(R.string.error_unknown)
    object Unknown : BaseError(R.string.error_unknown)
}
