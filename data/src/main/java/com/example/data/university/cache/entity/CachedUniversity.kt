package com.example.data.university.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "universities")
data class CachedUniversity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    val state_province: String,
    val web_pages: List<String>
)


