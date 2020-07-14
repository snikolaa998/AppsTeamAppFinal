package com.example.vtsappsteamproject.ProfesorActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.vtsappsteamproject.ProfesorFragments.*
import com.example.vtsappsteamproject.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tab.*

class TabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        val tabAdapter = MyViewPagerAdapter(supportFragmentManager)
        tabAdapter.addFragment(PredavanjaFragment(), "PREDAVANJA")
        tabAdapter.addFragment(VezbeFragment(), "VEZBE")
        tabAdapter.addFragment(RezultatiFragment(), "REZULTATI")
        tabAdapter.addFragment(KolokvijumiFragment(), "KOLOKVIJUMI")
        tabAdapter.addFragment(IspitiFragment(), "ISPITI")
        viewPager.adapter = tabAdapter
        tabs.setupWithViewPager(viewPager)
    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}
