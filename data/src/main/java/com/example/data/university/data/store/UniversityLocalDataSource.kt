package com.example.data.university.data.store

import com.example.data.university.cache.entity.CachedUniversity
import com.example.data.university.cache.db.UniversityDao

class UniversityLocalDataSource(val universityDao: UniversityDao) {
    suspend  fun getAllUniversitiesFromDB(): List<CachedUniversity> {
        return universityDao.getAllUniversities()
    }

    suspend  fun saveAllUniversitiesToDb(university: List<CachedUniversity>) {
        universityDao.insertUniversity(university)
    }

    suspend  fun deleteUniversity (){
        return universityDao.clearUniversities()
    }

}