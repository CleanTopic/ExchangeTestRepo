package ru.cleantopic.exchange_rate.di.app

import dagger.Module
import dagger.Provides
import ru.cleantopic.common.di.scope.ApplicationScope
import ru.cleantopic.exchange_rate.navigation.Navigator
import ru.cleantopic.feature.FeatureRouter
@Module
class NavigationModule {
    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideSplashRouter(navigator: Navigator): FeatureRouter = navigator
}
