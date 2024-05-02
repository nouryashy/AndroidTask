package com.example.data.university.remote.mapper

import com.example.data.university.remote.model.UniversityModel
import com.example.domain.university.model.University


object
UniversityResponseModelMapper {
    fun mapFromEntity(entity: UniversityModel): University {
        return University(
            id = entity.id,
            alpha_two_code=entity.alpha_two_code,
            country=entity.country,
            domains=entity.domains,
            name=entity.name,
            state_province=entity.state_province,
            web_pages=entity.web_pages
        )
    }

    fun mapToEntity(domain: University): UniversityModel {
        return UniversityModel(
            id = domain.id,
            alpha_two_code=domain.alpha_two_code,
            country=domain.country,
            domains=domain.domains,
            name=domain.name,
            state_province=domain.state_province,
            web_pages=domain.web_pages
        )
    }
}