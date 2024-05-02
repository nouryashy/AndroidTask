package com.example.data.university.data.store

import com.example.data.university.remote.model.UniversityResponseModel
import com.example.data.university.remote.service.UniversityServices
import com.example.domain.university.model.University


class UniversityNetworkDataSource(val apiServices: UniversityServices) {
    suspend fun getAllUniversitiesFromApi( country: String): UniversityResponseModel = apiServices.getUniversities(country)
}