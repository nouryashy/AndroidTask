package com.example.data.university.remote.service

import com.example.data.university.remote.model.UniversityResponseModel
import retrofit2.http.GET
import retrofit2.http.Query


interface UniversityServices {
    @GET("search?country=United%20Arab%20Emirates")
    suspend fun getUniversities(@Query("country") country: String)
            : UniversityResponseModel


}