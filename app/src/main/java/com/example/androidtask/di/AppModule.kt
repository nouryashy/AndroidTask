package com.example.androidtask.di

import android.app.Application
import androidx.room.Room
import com.example.androidtask.utils.Constants
import com.example.data.university.cache.db.UniversityDao
import com.example.data.university.cache.db.UniversityDatabase
import com.example.data.university.remote.service.UniversityServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    @Singleton
    fun provideUniversityApiService(retrofit: Retrofit): UniversityServices {
        return retrofit.create(UniversityServices::class.java)
    }



    @Provides
    @Singleton
    fun provideUniversityDatabase(app: Application): UniversityDatabase {
        return Room.databaseBuilder(app, UniversityDatabase::class.java, "university_database")
            .allowMainThreadQueries()
            .build()
    }



    @Provides
    @Singleton
    fun provideUniversityDao(database: UniversityDatabase): UniversityDao {
        return database.UniversityDao()
    }



}