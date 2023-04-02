package com.dushane.nycschools2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dushane.nycschools2.R
import com.dushane.nycschools2.ui.viewmodel.SchoolViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class SchoolsListFragment(): Fragment(R.layout.fragment_school_list) {

    private val schoolViewModel: SchoolViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val data = schoolViewModel.schools.observeOn(Schedulers.io()).blockingGet()
        val adapter = SchoolListRecyclerViewAdapter(context, data)
        adapter.notifyDataSetChanged()
        return inflater.inflate(R.layout.fragment_school_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}