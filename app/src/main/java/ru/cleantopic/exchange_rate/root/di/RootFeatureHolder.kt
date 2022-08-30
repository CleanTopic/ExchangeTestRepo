package ru.cleantopic.exchange_rate.root.di

import ru.cleantopic.common.di.FeatureApiHolder
import ru.cleantopic.common.di.FeatureContainer
import ru.cleantopic.common.di.scope.ApplicationScope
import ru.cleantopic.exchange_rate.navigation.Navigator
import javax.inject.Inject

@ApplicationScope
class RootFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer,
    private val navigator: Navigator
) : FeatureApiHolder(featureContainer) {

    override fun initializeDependencies(): Any {
        val rootFeatureDependencies = DaggerRootComponent_RootFeatureDependenciesComponent.builder()
            .commonApi(commonApi())
            .build()
        return DaggerRootComponent.factory()
            .create(navigator, rootFeatureDependencies)
    }
}
