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
            .replace(R.id.fragmentContainer, SchoolsListFragment())
            .commit()

        nav_view.setOnNavigationItemSelectedListener {
            if (it.title == resources.getString(R.string.title_school_list) && nav_view.selectedItemId == R.id.navigation_sat_score){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SchoolsListFragment())
                    .commit()
                return@setOnNavigationItemSelectedListener true
            }else if(it.itemId == R.id.navigation_sat_score && nav_view.selectedItemId == R.id.navigation_schools){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SATScoresListFragment())
                    .commit()
                return@setOnNavigationItemSelectedListener true
            } else return@setOnNavigationItemSelectedListener true
        }
    }


    override fun onBackPressed() {
        if (nav_view.selectedItemId == R.id.navigation_sat_score){
            nav_view.menu.getItem(0).isChecked = true
            supportFragmentManager.beginTransaction()
                .addToBackStack("")
                .replace(R.id.fragmentContainer, SchoolsListFragment())
                .commit()
        }else if(nav_view.selectedItemId == R.id.navigation_schools){
            finish()
        }
    }
}