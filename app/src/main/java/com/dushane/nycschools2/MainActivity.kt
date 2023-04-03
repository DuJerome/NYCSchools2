package com.dushane.nycschools2

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.dushane.nycschools2.ui.SATScoresListFragment
import com.dushane.nycschools2.ui.SchoolsListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, SchoolsListFragment())
            .commitNow()

        nav_view.setOnItemSelectedListener {
            if (it.title == resources.getString(R.string.title_school_list)){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SchoolsListFragment())
                    .commitNow()
                return@setOnItemSelectedListener true
            }else{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SATScoresListFragment())
                    .commitNow()
                return@setOnItemSelectedListener true
            }
        }
    }
}