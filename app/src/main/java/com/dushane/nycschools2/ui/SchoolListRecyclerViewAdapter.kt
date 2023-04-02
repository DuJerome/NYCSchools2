package com.dushane.nycschools2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dushane.nycschools2.R
import com.dushane.nycschools2.databinding.ListItemSchoolItemBinding
import com.dushane.nycschools2.model.School

class SchoolListRecyclerViewAdapter constructor(
    private val context: Context?,
    private val data: MutableList<School>
): PagingDataAdapter<School, SchoolListRecyclerViewAdapter.SchoolListViewHolder>(COMPARATOR) {

    class SchoolListViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding: ListItemSchoolItemBinding = DataBindingUtil.bind(view)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_school_item, parent, false)
        return SchoolListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SchoolListViewHolder, position: Int) {
        val item = data[position]
        holder.binding.borough.text = item.borough
        holder.binding.schoolName.text = item.school_name
        holder.binding.overviewParagraph.text = item.overview_paragraph
        holder.binding.phoneNumber.text = item.phone_number
        holder.binding.faxNumber.text = item.fax_number
        holder.binding.website.text = item.website
        holder.binding.location.text = item.location
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<School>() {
            override fun areItemsTheSame(oldItem: School, newItem: School): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: School, newItem: School): Boolean {
                return oldItem == newItem
            }
        }
    }
}