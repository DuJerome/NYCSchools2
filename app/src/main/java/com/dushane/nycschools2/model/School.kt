package com.dushane.nycschools2.model

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class School(
    @Transient
    val dbn: String?,
    val school_name: String?,
    @Transient
    val boro: Char?,
    val overview_paragraph: String?,
    @Transient
    val school_10th_seats: Char?,
    @Transient
    val academicopportunities1: String?,
    @Transient
    val academicopportunities2: String?,
    @Transient
    val ell_programs: String?,
    @Transient
    val neighborhood: String?,
    @Transient
    val building_code: String?,
    val location: String?,
    val phone_number: String?,
    val fax_number: String?,
    val school_email: String?,
    val website: String?,
    @Transient
    val subway: String?,
    @Transient
    val bus: String?,
    @Transient
    val grades2018: String?,
    @Transient
    val finalgrades: String?,
    val total_students: String?,
    @Transient
    val extracurricular_activities: String?,
    @Transient
    val school_sports: String?,
    @Transient
    val attendance_rate: String?,
    @Transient
    val pct_stu_enough_variety: String?,
    @Transient
    val pct_stu_safe: String?,
    @Transient
    val school_accessibility_description: Char?,
    @Transient
    val directions1: String?,
    @Transient
    val requirement1_1: String?,
    @Transient
    val requirement2_1: String?,
    @Transient
    val requirement3_1: String?,
    @Transient
    val requirement4_1: String?,
    @Transient
    val requirement5_1: String?,
    @Transient
    val offer_rate1: String?,
    @Transient
    val program1: String?,
    @Transient
    val code1: String?,
    @Transient
    val interest1: String?,
    @Transient
    val method1: String?,
    @Transient
    val seats9ge1: String?,
    @Transient
    val grade9gefilledflag1: Char?,
    @Transient
    val grade9geapplicants1: String?,
    @Transient
    val seats9swd1: String?,
    @Transient
    val grade9swdfilledflag1: Char?,
    @Transient
    val grade9swdapplicants1: String?,
    @Transient
    val seats101: String?,
    @Transient
    val admissionspriority11: String?,
    @Transient
    val admissionspriority21: String?,
    @Transient
    val admissionspriority31: String?,
    @Transient
    val grade9geapplicantsperseat1: String?,
    @Transient
    val grade9swdapplicantsperseat1: Char?,
    @Transient
    val primary_address_line_1: String?,
    @Transient
    val city: String?,
    @Transient
    val zip: String?,
    @Transient
    val state_code: String?,
    @Transient
    val latitude: String?,
    @Transient
    val longitude: String?,
    @Transient
    val community_board: Char?,
    @Transient
    val council_district: Char?,
    @Transient
    val census_tract: String?,
    @Transient
    val bin: String?,
    @Transient
    val bbl: String?,
    @Transient
    val nta: String?,
    val borough: String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt().toChar(),
        parcel.readString(),
        parcel.readInt().toChar(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt().toChar(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt().toChar(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt().toChar(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt().toChar(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt().toChar(),
        parcel.readInt().toChar(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dbn)
        parcel.writeString(school_name)
        boro?.code?.let { parcel.writeInt(it) }
        parcel.writeString(overview_paragraph)
        school_10th_seats?.code?.let { parcel.writeInt(it) }
        parcel.writeString(academicopportunities1)
        parcel.writeString(academicopportunities2)
        parcel.writeString(ell_programs)
        parcel.writeString(neighborhood)
        parcel.writeString(building_code)
        parcel.writeString(location)
        parcel.writeString(phone_number)
        parcel.writeString(fax_number)
        parcel.writeString(school_email)
        parcel.writeString(website)
        parcel.writeString(subway)
        parcel.writeString(bus)
        parcel.writeString(grades2018)
        parcel.writeString(finalgrades)
        parcel.writeString(total_students)
        parcel.writeString(extracurricular_activities)
        parcel.writeString(school_sports)
        parcel.writeString(attendance_rate)
        parcel.writeString(pct_stu_enough_variety)
        parcel.writeString(pct_stu_safe)
        school_accessibility_description?.code?.let { parcel.writeInt(it) }
        parcel.writeString(directions1)
        parcel.writeString(requirement1_1)
        parcel.writeString(requirement2_1)
        parcel.writeString(requirement3_1)
        parcel.writeString(requirement4_1)
        parcel.writeString(requirement5_1)
        parcel.writeString(offer_rate1)
        parcel.writeString(program1)
        parcel.writeString(code1)
        parcel.writeString(interest1)
        parcel.writeString(method1)
        parcel.writeString(seats9ge1)
        grade9gefilledflag1?.code?.let { parcel.writeInt(it) }
        parcel.writeString(grade9geapplicants1)
        parcel.writeString(seats9swd1)
        grade9swdfilledflag1?.code?.let { parcel.writeInt(it) }
        parcel.writeString(grade9swdapplicants1)
        parcel.writeString(seats101)
        parcel.writeString(admissionspriority11)
        parcel.writeString(admissionspriority21)
        parcel.writeString(admissionspriority31)
        parcel.writeString(grade9geapplicantsperseat1)
        grade9swdapplicantsperseat1?.code?.let { parcel.writeInt(it) }
        parcel.writeString(primary_address_line_1)
        parcel.writeString(city)
        parcel.writeString(zip)
        parcel.writeString(state_code)
        parcel.writeString(latitude)
        parcel.writeString(longitude)
        community_board?.code?.let { parcel.writeInt(it) }
        council_district?.code?.let { parcel.writeInt(it) }
        parcel.writeString(census_tract)
        parcel.writeString(bin)
        parcel.writeString(bbl)
        parcel.writeString(nta)
        parcel.writeString(borough)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<School> {
        override fun createFromParcel(parcel: Parcel): School {
            return School(parcel)
        }

        override fun newArray(size: Int): Array<School?> {
            return arrayOfNulls(size)
        }
    }

}