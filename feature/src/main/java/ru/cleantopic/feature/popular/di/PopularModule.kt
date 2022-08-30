package ru.cleantopic.feature.popular.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.cleantopic.common.di.viewmodel.ViewModelKey
import ru.cleantopic.common.di.viewmodel.ViewModelModule
import ru.cleantopic.feature.database.repository.FavoriteCurrencyRepository
import ru.cleantopic.feature.domain.usecase.GetCurrencyListUseCase
import ru.cleantopic.feature.shared_view_model.SharedCurrencyViewModel
import javax.inject.Singleton

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class PopularModule {

    @Provides
    @IntoMap
    @ViewModelKey(SharedCurrencyViewModel::class)
    fun provideViewModel(
        repository: FavoriteCurrencyRepository,
        getCurrencyListUseCase: GetCurrencyListUseCase
    ): ViewModel {
        return SharedCurrencyViewModel(
            repository, getCurrencyListUseCase
        )
    }

    @Provides
    @Singleton
    fun provideViewModelCreator(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
    ): SharedCurrencyViewModel {
        return ViewModelProvider(fragment, viewModelFactory).get(SharedCurrencyViewModel::class.java)
    }
}
