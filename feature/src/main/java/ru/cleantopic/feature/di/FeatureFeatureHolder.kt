package ru.cleantopic.feature.di

import ru.cleantopic.common.di.FeatureApiHolder
import ru.cleantopic.common.di.FeatureContainer
import ru.cleantopic.common.di.scope.ApplicationScope
import ru.cleantopic.feature.FeatureRouter
import javax.inject.Inject

@ApplicationScope
class FeatureFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer,
    private val featureRouter: FeatureRouter
) : FeatureApiHolder(featureContainer) {
    override fun initializeDependencies(): Any {
        val deps = DaggerFeatureComponent_FeatureDependenciesComponent.builder()
            .commonApi(commonApi())
            .build()
        return DaggerFeatureComponent.factory()
            .create(featureRouter, deps)
    }
}
