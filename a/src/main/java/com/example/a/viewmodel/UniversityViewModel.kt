package com.example.a.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.domain.university.model.University
import com.example.domain.university.usecase.GetUniversitiesUseCase
import com.example.androidtask.state.Resource
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(
    private val getUniversitiesUseCase: GetUniversitiesUseCase
) :
    ViewModel() {
    private var _universities = MutableStateFlow<Resource<List<University>>>(Resource.Loading)
    val universities: StateFlow<Resource<List<University>>> = _universities


    private val country = "United%20Arab%20Emirates"

    fun loadUniversities() {
        _universities.value = Resource.Loading
        viewModelScope.launch {
            try {
                val universityList = getUniversitiesUseCase(country)
                Log.d(TAG, "loadBooks: $universityList")
                _universities.emit(Resource.Success(universityList))
            } catch (e: Exception) {
                _universities.emit(Resource.Error(e))
            }
        }
    }

}








