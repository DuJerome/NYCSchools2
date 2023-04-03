package com.dushane.nycschools2.repository

import com.dushane.nycschools2.model.SATScores
import com.dushane.nycschools2.network.SATScoresListServices
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SATScoresRepository @Inject constructor(
    private val satScoresListServices: SATScoresListServices
) {
    fun getSATScoresList(): Single<List<SATScores>> {
        return satScoresListServices.getSATScoresList()
    }
}