package ru.cleantopic.exchange_rate.root.di

import dagger.BindsInstance
import dagger.Component
import ru.cleantopic.common.di.CommonApi
import ru.cleantopic.common.di.scope.FeatureScope
import ru.cleantopic.exchange_rate.navigation.Navigator
import ru.cleantopic.exchange_rate.root.presentation.di.RootActivityComponent

@Component(
    dependencies = [
        RootDependencies::class
    ],
    modules = [
        RootFeatureModule::class
    ]
)
@FeatureScope
interface RootComponent {

    fun mainActivityComponentFactory(): RootActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance navigator: Navigator,
            deps: RootDependencies
        ): RootComponent
    }

    @Component(
        dependencies = [
            CommonApi::class,
        ]
    )
    interface RootFeatureDependenciesComponent : RootDependencies
}
