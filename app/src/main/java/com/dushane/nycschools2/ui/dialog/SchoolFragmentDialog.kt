package com.dushane.nycschools2.ui.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.dushane.nycschools2.R
import com.dushane.nycschools2.model.SATScores
import com.dushane.nycschools2.model.School
import kotlinx.android.synthetic.main.dialog_fragment_school.*

class SchoolFragmentDialog(
    private val schoolData: School,
    val satScoresData: SATScores?
    ) : DialogFragment(R.layout.dialog_fragment_school) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        schoolName.text = schoolData.school_name
        borough.text = schoolData.borough
        extracurricular.text = schoolData.extracurricular_activities
        overviewParagraph.text = schoolData.overview_paragraph
        totalStudents.text = schoolData.total_students
        location.text = schoolData.location
        website.text = schoolData.website
        phoneNumber.text = schoolData.phone_number
        faxNumber.text = schoolData.fax_number
        close.setOnClickListener {
            dismiss()
        }
    }
}