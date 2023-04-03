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
import com.dushane.nycschools2.ui.adapter.SATScoreListRecyclerViewAdapter
import com.dushane.nycschools2.ui.viewmodel.SATScoresViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_sat_scores_list.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class SATScoresListFragment : Fragment(R.layout.fragment_sat_scores_list) {

    private val satViewModel:SATScoresViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewSATScoresList.layoutManager = LinearLayoutManager(context)
        val adapter = SATScoreListRecyclerViewAdapter(context)
        recyclerViewSATScoresList.adapter = adapter
        adapter.submitData(lifecycle, PagingData.from(getList()))
        adapter.notifyDataSetChanged()
    }

    private fun getList(): List<SATScores> = satViewModel.satScores.subscribeOn(Schedulers.single()).blockingGet()
}