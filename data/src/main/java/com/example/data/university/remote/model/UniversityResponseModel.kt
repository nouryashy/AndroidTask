package com.example.data.university.remote.model

import com.google.gson.annotations.SerializedName

data class UniversityResponseModel(
    @SerializedName("universities")
    val universities: List<UniversityModel>
)