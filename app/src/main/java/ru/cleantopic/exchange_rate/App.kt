package ru.cleantopic.exchange_rate

import android.app.Application
import ru.cleantopic.common.di.CommonApi
import ru.cleantopic.common.di.FeatureContainer
import ru.cleantopic.exchange_rate.di.app.AppComponent
import ru.cleantopic.exchange_rate.di.app.DaggerAppComponent
import ru.cleantopic.exchange_rate.di.deps.FeatureHolderManager
import ru.cleantopic.exchange_rate.log.ReleaseTree
import timber.log.Timber
import javax.inject.Inject

open class App : Application(), FeatureContainer {

    @Inject
    lateinit var featureHolderManager: FeatureHolderManager

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()

        appComponent.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    override fun <T> getFeature(key: Class<*>): T {
        return featureHolderManager.getFeature<T>(key)!!
    }

    override fun releaseFeature(key: Class<*>) {
        featureHolderManager.releaseFeature(key)
    }

    override fun commonApi(): CommonApi {
        return appComponent
    }
}
