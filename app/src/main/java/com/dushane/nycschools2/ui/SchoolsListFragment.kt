package com.dushane.nycschools2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
    private lateinit var data: MutableList<School>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = schoolViewModel.schools.subscribeOn(Schedulers.io()).blockingGet()
        val adapter = SchoolListRecyclerViewAdapter(context, data)
        val recyclerView: RecyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewSchoolList)
        adapter.notifyDataSetChanged()
    }
}