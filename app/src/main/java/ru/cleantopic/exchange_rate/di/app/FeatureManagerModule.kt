package ru.cleantopic.exchange_rate.di.app

import dagger.Module
import dagger.Provides
import ru.cleantopic.common.di.FeatureApiHolder
import ru.cleantopic.common.di.scope.ApplicationScope
import ru.cleantopic.exchange_rate.di.deps.FeatureHolderManager

@Module
class FeatureManagerModule {
    @ApplicationScope
    @Provides
    fun provideFeatureHolderManager(featureApiHolderMap: @JvmSuppressWildcards Map<Class<*>, FeatureApiHolder>): FeatureHolderManager {
        return FeatureHolderManager(featureApiHolderMap)
    }
}
