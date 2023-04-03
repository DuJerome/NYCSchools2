package com.dushane.nycschools2.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.dushane.nycschools2.model.SATScores
import com.dushane.nycschools2.repository.SATScoresRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SATScoresViewModel @Inject constructor(
    private val satScoresRepository: SATScoresRepository
) : ViewModel() {

    val satScores: Single<List<SATScores>> = satScoresRepository.getSATScoresList()
}