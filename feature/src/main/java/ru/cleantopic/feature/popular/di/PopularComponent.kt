package ru.cleantopic.feature.popular.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.cleantopic.common.di.scope.ScreenScope
import ru.cleantopic.feature.popular.presentation.PopularFragment
import ru.cleantopic.feature.shared_view_model.di.SharedViewModelModule

@Subcomponent(
    modules = [
        SharedViewModelModule::class,
    ]
)
@ScreenScope
interface PopularComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: Fragment): PopularComponent
    }

    fun inject(popularFragment: PopularFragment)
}
