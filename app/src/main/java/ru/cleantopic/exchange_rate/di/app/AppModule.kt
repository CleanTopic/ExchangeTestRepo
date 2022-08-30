package ru.cleantopic.exchange_rate.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.cleantopic.common.di.scope.ApplicationScope
import ru.cleantopic.exchange_rate.App

@Module
class AppModule {

    @Provides
    @ApplicationScope
    fun provideContext(application: App): Context {
        return application
    }
}
