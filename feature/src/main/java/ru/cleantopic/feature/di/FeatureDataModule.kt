package ru.cleantopic.feature.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.cleantopic.common.di.scope.FeatureScope
import ru.cleantopic.feature.data.remote.api.FeatureApiService
import ru.cleantopic.feature.data.remote.source.FeatureDataSourceImpl
import ru.cleantopic.feature.data.repository.FeatureRepositoryImpl
import ru.cleantopic.feature.data.source.FeatureDataSource
import ru.cleantopic.feature.domain.repository.FeatureRepository

@Module
abstract class FeatureDataModule {
    @Binds
    @FeatureScope
    abstract fun bindFeatureRepository(featureRepositoryImpl: FeatureRepositoryImpl): FeatureRepository

    @Binds
    @FeatureScope
    abstract fun bindFeatureDataSource(featureDataSourceImpl: FeatureDataSourceImpl): FeatureDataSource

    companion object {
        @Provides
        @FeatureScope
        fun provideFeatureApiService(retrofit: Retrofit): FeatureApiService =
            retrofit.create(FeatureApiService::class.java)
    }
}
