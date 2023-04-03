package com.dushane.nycschools2.model

data class School(
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
    val extracurricular_activities: String?,
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
)