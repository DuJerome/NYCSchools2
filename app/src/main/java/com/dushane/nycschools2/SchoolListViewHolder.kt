package com.dushane.nycschools2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SchoolListViewHolder(view: View): RecyclerView.ViewHolder(view){
    val schoolName: TextView = view.findViewById(R.id.schoolName)
    val borough: TextView = view.findViewById(R.id.borough)
    val overviewParagraph: TextView = view.findViewById(R.id.overviewParagraph)
    val phoneNumber: TextView = view.findViewById(R.id.phoneNumber)
    val faxNumber: TextView = view.findViewById(R.id.faxNumber)
    val website: TextView = view.findViewById(R.id.website)
    val location: TextView = view.findViewById(R.id.location)
}