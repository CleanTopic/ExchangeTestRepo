package ru.cleantopic.feature.main_screen.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.cleantopic.common.di.viewmodel.ViewModelKey
import ru.cleantopic.common.di.viewmodel.ViewModelModule
import ru.cleantopic.feature.domain.usecase.GetCurrencyListUseCase
import ru.cleantopic.feature.main_screen.presentation.MainScreenViewModel

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class MainScreenModule {

    @Provides
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    fun provideViewModel(
        getCurrencyList: GetCurrencyListUseCase
    ): ViewModel {
        return MainScreenViewModel(
            getCurrencyList
        )
    }

    @Provides
    fun provideViewModelCreator(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
    ): MainScreenViewModel {
        return ViewModelProvider(fragment, viewModelFactory).get(MainScreenViewModel::class.java)
    }
}
