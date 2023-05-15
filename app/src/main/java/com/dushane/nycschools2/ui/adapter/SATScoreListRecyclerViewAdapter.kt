package com.dushane.nycschools2.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dushane.nycschools2.R
import com.dushane.nycschools2.databinding.ListItemSatScoresItemBinding
import com.dushane.nycschools2.model.SATScores

class SATScoreListRecyclerViewAdapter : PagingDataAdapter<SATScores, SATScoreListRecyclerViewAdapter.ViewHolder>(COMPARATOR) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ListItemSatScoresItemBinding = DataBindingUtil.bind(view)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_sat_scores_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.schoolName.text = item?.school_name
        holder.binding.mathAvg.text = item?.sat_math_avg_score
        holder.binding.readingAvg.text = item?.sat_critical_reading_avg_score
        holder.binding.writinAvg.text = item?.sat_writing_avg_score
        holder.binding.numberOfTakers.text = item?.num_of_sat_test_takers
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<SATScores>() {
            override fun areItemsTheSame(oldItem: SATScores, newItem: SATScores): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: SATScores, newItem: SATScores): Boolean {
                return oldItem.school_name == newItem.school_name
            }
        }
    }
}