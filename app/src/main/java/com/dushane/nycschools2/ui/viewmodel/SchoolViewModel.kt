package com.dushane.nycschools2.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.dushane.nycschools2.model.School
import com.dushane.nycschools2.repository.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel @Inject constructor(
    private val schoolRepository: SchoolRepository
) : ViewModel() {

    val schools: Single<List<School>> = schoolRepository.getSchool()
}