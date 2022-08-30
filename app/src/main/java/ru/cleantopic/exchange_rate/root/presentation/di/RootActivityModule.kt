package ru.cleantopic.exchange_rate.root.presentation.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.cleantopic.common.di.viewmodel.ViewModelKey
import ru.cleantopic.common.di.viewmodel.ViewModelModule
import ru.cleantopic.exchange_rate.navigation.Navigator
import ru.cleantopic.exchange_rate.root.presentation.MainActivityViewModel

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class RootActivityModule {

    @Provides
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun provideViewModel(router: Navigator): ViewModel {
        return MainActivityViewModel(router)
    }

    @Provides
    fun provideViewModelCreator(
        activity: AppCompatActivity,
        viewModelFactory: ViewModelProvider.Factory
    ): MainActivityViewModel {
        return ViewModelProvider(activity, viewModelFactory).get(MainActivityViewModel::class.java)
    }
}
