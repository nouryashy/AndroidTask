package com.example.androidtask.di

import com.example.data.university.cache.db.UniversityDao
import com.example.data.university.cache.db.UniversityDatabase
import com.example.data.university.cache.mapper.CachedUniversityMapper
import com.example.data.university.data.repository.UniversityRepositoryImp
import com.example.data.university.data.store.UniversityLocalDataSource
import com.example.data.university.data.store.UniversityNetworkDataSource
import com.example.data.university.remote.mapper.UniversityResponseModelMapper
import com.example.data.university.remote.service.UniversityServices
import com.example.domain.university.repository.UniversityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UniversityRepositoryModule {

    @Provides
    fun provideUniversityNetworkDataSource(apiService: UniversityServices): UniversityNetworkDataSource {
        return UniversityNetworkDataSource(apiService)
    }

    @Provides
    fun provideUniversityLocalDataSource(dao: UniversityDao): UniversityLocalDataSource {
        return UniversityLocalDataSource(dao)
    }

    @Provides
    fun provideCachedUniversityMapper(): CachedUniversityMapper {
        return CachedUniversityMapper
    }


    @Provides
    fun provideUniversityMapper(): UniversityResponseModelMapper {
        return UniversityResponseModelMapper
    }


    @Provides
    fun provideUniversityRepository(
        networkDataSource: UniversityNetworkDataSource,
        localDataSource: UniversityLocalDataSource,
        mapperRemote: UniversityResponseModelMapper,
        mapperCached: CachedUniversityMapper

    ): UniversityRepository {
        return UniversityRepositoryImp(networkDataSource, localDataSource, mapperRemote, mapperCached)
    }
}