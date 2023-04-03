package com.dushane.nycschools2.network

import com.dushane.nycschools2.model.SATScores
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface SATScoresListServices {

    @GET("/resource/f9bf-2cp4.json")
    fun getSATScoresList(): Single<List<SATScores>>
}