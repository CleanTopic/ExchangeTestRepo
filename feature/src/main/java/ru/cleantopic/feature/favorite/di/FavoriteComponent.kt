package ru.cleantopic.feature.favorite.di
import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.cleantopic.common.di.scope.ScreenScope
import ru.cleantopic.feature.favorite.presentation.FavoriteFragment
import ru.cleantopic.feature.shared_view_model.di.SharedViewModelModule

@Subcomponent(
    modules = [
        SharedViewModelModule::class,
    ]
)
@ScreenScope
interface FavoriteComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: Fragment): FavoriteComponent
    }

    fun inject(favoriteFragment: FavoriteFragment)
}
