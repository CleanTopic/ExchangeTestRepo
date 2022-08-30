package ru.cleantopic.feature.di

import dagger.BindsInstance
import dagger.Component
import ru.cleantopic.common.di.CommonApi
import ru.cleantopic.common.di.scope.FeatureScope
import ru.cleantopic.feature.FeatureRouter
import ru.cleantopic.feature.favorite.di.FavoriteComponent
import ru.cleantopic.feature.main_screen.di.MainScreenComponent
import ru.cleantopic.feature.popular.di.PopularComponent

@Component(
    dependencies = [
        FeatureDependencies::class,
    ],
    modules = [
        FeatureModule::class,
        FeatureDataModule::class,
        RoomDatabaseModule::class,
    ]
)
@FeatureScope
interface FeatureComponent {

    fun mainScreenComponentFactory(): MainScreenComponent.Factory
    fun popularComponentFactory(): PopularComponent.Factory
    fun favoriteComponentFactory(): FavoriteComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance featureRouter: FeatureRouter,
            deps: FeatureDependencies
        ): FeatureComponent
    }

    @Component(
        dependencies = [
            CommonApi::class,
        ]
    )
    interface FeatureDependenciesComponent : FeatureDependencies
}
