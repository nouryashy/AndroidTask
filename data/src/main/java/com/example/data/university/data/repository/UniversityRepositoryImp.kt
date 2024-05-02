package com.example.data.university.data.repository

import android.content.ContentValues
import android.util.Log
import com.example.data.university.cache.mapper.CachedUniversityMapper
import com.example.data.university.data.store.UniversityLocalDataSource
import com.example.data.university.data.store.UniversityNetworkDataSource
import com.example.data.university.remote.mapper.UniversityResponseModelMapper
import com.example.domain.university.model.University
import com.example.domain.university.repository.UniversityRepository


class UniversityRepositoryImp(
    private val networkDataSource: UniversityNetworkDataSource,
    private val localDataSource: UniversityLocalDataSource,
    private val mapperRemote: UniversityResponseModelMapper,
    private val mapperCached: CachedUniversityMapper
) : UniversityRepository {
    override suspend fun getUniversities(country: String): List<University> {
        return try {
            val networkUniversities = networkDataSource.getAllUniversitiesFromApi(country)
            val universities = networkUniversities.universities
            localDataSource.saveAllUniversitiesToDb(universities.map { mapperCached.mapFromCached(it) })
            universities.map { mapperRemote.mapFromEntity(it) }

        }catch (e: Exception) {
            val cashed = localDataSource.getAllUniversitiesFromDB()
            val cashedUniversities = cashed.map { mapperCached.mapToCached(it) }
            cashedUniversities.map { mapperRemote.mapFromEntity(it) }

        }
    }
}



























