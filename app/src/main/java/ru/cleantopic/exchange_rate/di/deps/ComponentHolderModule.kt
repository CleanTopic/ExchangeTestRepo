package ru.cleantopic.exchange_rate.di.deps

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.cleantopic.common.di.FeatureApiHolder
import ru.cleantopic.common.di.FeatureContainer
import ru.cleantopic.common.di.scope.ApplicationScope
import ru.cleantopic.exchange_rate.App
import ru.cleantopic.exchange_rate.root.di.RootApi
import ru.cleantopic.exchange_rate.root.di.RootFeatureHolder
import ru.cleantopic.feature.di.FeatureApi
import ru.cleantopic.feature.di.FeatureFeatureHolder

@Module
interface ComponentHolderModule {

    @ApplicationScope
    @Binds
    fun provideFeatureContainer(application: App): FeatureContainer

    @ApplicationScope
    @Binds
    @ClassKey(RootApi::class)
    @IntoMap
    fun provideMainFeature(rootFeatureHolder: RootFeatureHolder): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(FeatureApi::class)
    @IntoMap
    fun provideFeatureFeature(featureHolder: FeatureFeatureHolder): FeatureApiHolder
}
