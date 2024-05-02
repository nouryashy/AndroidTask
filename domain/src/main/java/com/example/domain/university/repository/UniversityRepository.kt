package com.example.domain.university.repository

import com.example.domain.university.model.University

interface UniversityRepository {
    suspend fun getUniversities(country: String): List<University>
}