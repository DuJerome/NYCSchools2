package com.dushane.nycschools2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dushane.nycschools2.ui.SchoolsListFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(SchoolsListFragment::class.java, null, null)
            .commitNow()
    }
}