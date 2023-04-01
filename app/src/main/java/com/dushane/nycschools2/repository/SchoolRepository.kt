package com.dushane.nycschools2.repository

import com.dushane.nycschools2.model.School
import com.dushane.nycschools2.network.SchoolListServices
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolRepository @Inject constructor(
    private val schoolListServices: SchoolListServices
) {
    fun getSchool(): Single<MutableList<School>> {
        return schoolListServices.getSchoolList()
            .subscribeOn(Schedulers.io())
    }
}