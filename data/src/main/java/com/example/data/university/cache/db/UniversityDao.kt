package com.example.data.university.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.university.cache.entity.CachedUniversity


@Dao
interface UniversityDao {
    @Query("SELECT * FROM universities")
    suspend fun getAllUniversities(): List<CachedUniversity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUniversity(books: List<CachedUniversity>)

    @Query("DELETE FROM universities")
    suspend fun clearUniversities()

}

