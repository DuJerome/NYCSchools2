package com.dushane.nycschools2.ui.adapter

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
    private val context: Context?
): PagingDataAdapter<School, SchoolListRecyclerViewAdapter.ViewHolder>(COMPARATOR) {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding: ListItemSchoolItemBinding = DataBindingUtil.bind(view)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_school_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.borough.text = item?.borough
        holder.binding.schoolName.text = item?.school_name
        holder.binding.overviewParagraph.text = item?.overview_paragraph
        holder.binding.phoneNumber.text = item?.phone_number
        holder.binding.faxNumber.text = item?.fax_number
        holder.binding.website.text = item?.website
        holder.binding.location.text = item?.location
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<School>() {
            override fun areItemsTheSame(oldItem: School, newItem: School): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: School, newItem: School): Boolean {
                return oldItem.school_name == newItem.school_name
            }
        }
    }
}