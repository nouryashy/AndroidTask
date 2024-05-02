package com.example.data.university.cache.db

import androidx.room.*
import com.example.data.university.cache.entity.CachedUniversity


@Database(entities = [CachedUniversity::class], version = 1,exportSchema = true)
@TypeConverters(UniversityConverters::class)

abstract class UniversityDatabase : RoomDatabase() {
    abstract fun UniversityDao(): UniversityDao
}