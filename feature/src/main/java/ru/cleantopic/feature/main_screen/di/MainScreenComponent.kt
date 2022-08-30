package ru.cleantopic.feature.main_screen.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.cleantopic.common.di.scope.ScreenScope
import ru.cleantopic.feature.main_screen.presentation.MainScreenFragment

@Subcomponent(
    modules = [
        MainScreenModule::class,
    ]
)
@ScreenScope
interface MainScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: Fragment): MainScreenComponent
    }

    fun inject(mainScreenFragment: MainScreenFragment)
}
