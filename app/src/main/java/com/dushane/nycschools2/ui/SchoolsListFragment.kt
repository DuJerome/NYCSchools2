package com.dushane.nycschools2.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.dushane.nycschools2.R
import com.dushane.nycschools2.model.SATScores
import com.dushane.nycschools2.model.School
import com.dushane.nycschools2.ui.adapter.SchoolListRecyclerViewAdapter
import com.dushane.nycschools2.ui.viewmodel.SATScoresViewModel
import com.dushane.nycschools2.ui.viewmodel.SchoolViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_school_list.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class SchoolsListFragment: Fragment(R.layout.fragment_school_list) {
    private val schoolViewModel: SchoolViewModel by viewModels()
    private val satScoreViewModel: SATScoresViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewSchoolList.layoutManager = LinearLayoutManager(context)
        val adapter = SchoolListRecyclerViewAdapter(parentFragmentManager, getSATList())
        recyclerViewSchoolList.adapter = adapter
        adapter.submitData(lifecycle, PagingData.from(getList()))
    }

    private fun getList(): List<School> =
        schoolViewModel.schools.subscribeOn(Schedulers.single())
            .blockingGet().sortedBy { it.school_name }
    private fun getSATList(): List<SATScores> =
        satScoreViewModel.satScores.subscribeOn(Schedulers.single())
            .blockingGet().sortedBy { it.school_name }
}