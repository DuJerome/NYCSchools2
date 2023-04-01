package com.dushane.nycschools2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dushane.nycschools2.R
import com.dushane.nycschools2.SchoolListViewHolder
import com.dushane.nycschools2.model.School

class SchoolListRecyclerViewAdapter constructor(
    private val context: Context?,
    private val data: MutableList<School>
): RecyclerView.Adapter<SchoolListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_school_item, parent, false)
        return SchoolListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SchoolListViewHolder, position: Int) {
        val item = data[position]
        holder.borough.text = item.borough
        holder.schoolName.text = item.school_name
        holder.overviewParagraph.text = item.overview_paragraph
        holder.phoneNumber.text = item.phone_number
        holder.faxNumber.text = item.fax_number
        holder.website.text = item.website
        holder.location.text = item.location
    }

    override fun getItemCount(): Int {
        return data.size
    }
}