package com.example.domain.university.usecase

import com.example.domain.university.repository.UniversityRepository
import javax.inject.Inject

class GetUniversitiesUseCase @Inject constructor(
    private val universityRepository: UniversityRepository
) {
    suspend operator fun invoke(country: String) = universityRepository.getUniversities(country)
}