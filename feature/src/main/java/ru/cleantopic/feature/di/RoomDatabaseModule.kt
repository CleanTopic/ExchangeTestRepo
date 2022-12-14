package ru.cleantopic.feature.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.cleantopic.common.di.scope.FeatureScope
import ru.cleantopic.feature.database.FavoriteCurrencyDB
import ru.cleantopic.feature.database.repository.FavoriteCurrencyRepository

@Module
abstract class RoomDatabaseModule {

    companion object {
        @Provides
        @FeatureScope
        fun provideRoomDBInstance(context: Context): FavoriteCurrencyDB {
            return FavoriteCurrencyDB.getDatabase(context)
        }

        @Provides
        @FeatureScope
        fun provideFavoriteRepository(context: Context): FavoriteCurrencyRepository {
            val userDao = FavoriteCurrencyDB.getDatabase(context).favoriteCurrencyDao()
            return FavoriteCurrencyRepository(userDao)
        }
    }
}
