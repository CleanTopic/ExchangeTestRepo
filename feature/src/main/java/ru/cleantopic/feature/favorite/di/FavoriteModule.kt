package ru.cleantopic.feature.favorite.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.cleantopic.common.di.viewmodel.ViewModelKey
import ru.cleantopic.common.di.viewmodel.ViewModelModule
import ru.cleantopic.feature.database.repository.FavoriteCurrencyRepository
import ru.cleantopic.feature.domain.usecase.GetCurrencyListUseCase
import ru.cleantopic.feature.shared_view_model.SharedCurrencyViewModel

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class FavoriteModule {

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
}
