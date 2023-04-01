package com.dushane.nycschools2.network

import com.dushane.nycschools2.model.School
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface SchoolListServices {

    @GET("s3k6-pzi2.json")
    fun getSchoolList(): Single<MutableList<School>>
}