package com.example.data.university.cache.db

import androidx.room.TypeConverter
import com.example.data.university.cache.entity.CachedUniversity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object UniversityConverters {

    @TypeConverter
    @JvmStatic
    fun fromJson(json: String): List<CachedUniversity> {
        val type = object : TypeToken<List<CachedUniversity>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun toJson(list: List<CachedUniversity>): String {
        return Gson().toJson(list)
    }
}