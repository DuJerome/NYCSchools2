package com.dushane.nycschools2.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dushane.nycschools2.R
import com.dushane.nycschools2.model.School
import com.dushane.nycschools2.ui.viewmodel.SchoolViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class SchoolsListFragment: Fragment(R.layout.fragment_school_list) {
    private val schoolViewModel: SchoolViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listview = view.findViewById<RecyclerView>(R.id.recyclerViewSchoolList)
        listview.layoutManager = LinearLayoutManager(context)
        val adapter = SchoolListRecyclerViewAdapter(context)
        listview.adapter = adapter
        adapter.submitData(lifecycle, PagingData.from(getList()))
        adapter.notifyDataSetChanged()
    }

    private fun getList(): List<School>{
        return schoolViewModel.schools.subscribeOn(Schedulers.single()).blockingGet()
    }
}