package ru.cleantopic.common.di

import android.content.Context
import retrofit2.Retrofit
import ru.cleantopic.common.utils.BundleDataWrapper

interface CommonApi {

    fun context(): Context
    fun provideRetrofit(): Retrofit
    fun provideBundleDataWrapper(): BundleDataWrapper
}
