package ru.cleantopic.exchange_rate.di.app

import dagger.BindsInstance
import dagger.Component
import ru.cleantopic.common.di.CommonApi
import ru.cleantopic.common.di.modules.CommonModule
import ru.cleantopic.common.di.modules.NetworkModule
import ru.cleantopic.common.di.scope.ApplicationScope
import ru.cleantopic.exchange_rate.App
import ru.cleantopic.exchange_rate.di.deps.ComponentHolderModule

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        CommonModule::class,
        NetworkModule::class,
        ComponentHolderModule::class,
        FeatureManagerModule::class,
        NavigationModule::class
    ]
)
interface AppComponent : CommonApi {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
