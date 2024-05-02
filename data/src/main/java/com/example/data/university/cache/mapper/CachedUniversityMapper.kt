package com.example.data.university.cache.mapper

import com.example.data.university.cache.entity.CachedUniversity
import com.example.data.university.remote.model.UniversityModel


object CachedUniversityMapper {
    fun mapFromCached(type: UniversityModel): CachedUniversity {

    return CachedUniversity(
        id = type.id,
        alpha_two_code=type.alpha_two_code,
        country=type.country,
        domains=type.domains,
        name=type.name,
        state_province=type.state_province,
        web_pages=type.web_pages
    )
}

fun mapToCached(entity: CachedUniversity): UniversityModel {
    return UniversityModel(
        id = entity.id,
        alpha_two_code=entity.alpha_two_code,
        country=entity.country,
        domains=entity.domains,
        name=entity.name,
        state_province=entity.state_province,
        web_pages=entity.web_pages
    )
}
}