package com.example.vtsappsteamproject.ProfesorActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.example.vtsappsteamproject.ProfesorFragments.DashboardFragment
import com.example.vtsappsteamproject.ProfesorFragments.OsobljeFragment
import com.example.vtsappsteamproject.ProfesorFragments.PredmetiFragment
import com.example.vtsappsteamproject.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.app_bar_navigation.*

class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var dashboardFragment: DashboardFragment
    lateinit var predmetFragment: PredmetiFragment
    lateinit var osobljeFragment: OsobljeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        setSupportActionBar(toolBar)
        val actionBr = supportActionBar
        actionBr?.title = "Dashboard"
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawer_layout, toolBar, (R.string.open), (R.string.close))
        {

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        dashboardFragment = DashboardFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, dashboardFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId) {
            R.id.home -> {
                dashboardFragment = DashboardFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, dashboardFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.raspored -> {
                predmetFragment = PredmetiFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, predmetFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.osoblje -> {
                osobljeFragment = OsobljeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, osobljeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.settings -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
