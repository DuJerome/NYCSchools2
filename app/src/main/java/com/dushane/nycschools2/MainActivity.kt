package com.dushane.nycschools2

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.dushane.nycschools2.ui.SATScoresListFragment
import com.dushane.nycschools2.ui.SchoolsListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    private lateinit var navView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, SchoolsListFragment())
            .commitNow()

        navView = findViewById(R.id.nav_view)
        navView.setOnItemSelectedListener {
            if (it.itemId == R.id.navigation_schools){
                supportFragmentManager.beginTransaction()
                    .remove(SATScoresListFragment())
                    .add(R.id.fragmentContainer, SchoolsListFragment())
                    .commitNow()
                return@setOnItemSelectedListener true
            }else{
                supportFragmentManager.beginTransaction()
                    .remove(SchoolsListFragment())
                    .add(R.id.fragmentContainer, SATScoresListFragment())
                    .commitNow()
                return@setOnItemSelectedListener true
            }
        }
    }
}