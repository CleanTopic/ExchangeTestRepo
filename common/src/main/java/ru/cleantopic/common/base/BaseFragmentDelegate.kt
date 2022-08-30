package ru.cleantopic.common.base

import android.content.Context
import androidx.viewbinding.ViewBinding

abstract class BaseDelegate(private val binding: ViewBinding) {
    val context: Context get() = binding.root.context
    open fun loadDelegate() {}
}
