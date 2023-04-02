package com.dushane.nycschools2.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.dushane.nycschools2.R
import com.dushane.nycschools2.databinding.FragmentSchoolListBinding
import com.dushane.nycschools2.model.School
import com.dushane.nycschools2.ui.viewmodel.SchoolViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class SchoolsListFragment: Fragment(R.layout.fragment_school_list) {
    private lateinit var binding: FragmentSchoolListBinding
    private val schoolViewModel: SchoolViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SchoolListRecyclerViewAdapter(context)
        binding = DataBindingUtil.bind(view)!!
        binding.recyclerViewSchoolList.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewSchoolList.adapter = adapter
        schoolViewModel.schools.subscribe { data->
            adapter.submitData(lifecycle, PagingData.from(data))
        }
    }
}