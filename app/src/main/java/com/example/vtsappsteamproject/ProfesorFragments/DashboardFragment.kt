package com.example.vtsappsteamproject.ProfesorFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.vtsappsteamproject.DataPrototype.FirstDashboard
import com.example.vtsappsteamproject.DataPrototype.SecondDashboard
import com.example.vtsappsteamproject.DataPrototype.ThirdDashboard
import com.example.vtsappsteamproject.ProfesorActivities.NavigationActivity
import com.example.vtsappsteamproject.ProfesorAdapters.DashboardFirstAdapter
import com.example.vtsappsteamproject.ProfesorAdapters.DashboardSecondAdapter
import com.example.vtsappsteamproject.ProfesorAdapters.DashboardThirdAdapter

import com.example.vtsappsteamproject.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard_test.*

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_dashboard_test, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as NavigationActivity).supportActionBar?.title = "Dashboard"

        val dataListFirst = ArrayList<FirstDashboard>()
        val dataListSecond = ArrayList<SecondDashboard>()
        val dataListThird = ArrayList<ThirdDashboard>()

        val item1 = FirstDashboard("14:00-16:00", "Internet Tehnologije")
        val item3 = FirstDashboard("15:00-18:30", "Andorid Vikend")
        val item2 = FirstDashboard("18:00-20:00", "Matematika 2")


        val obaveza1 = SecondDashboard("Postaviti studentima zadatak!")
        val obaveza2 = SecondDashboard("Pregledati radove i poslati asistentu!")
//        val obaveza3 = SecondDashboard("Postaviti rezultate ispita")
//        val obaveza4 = SecondDashboard("Postaviti rezultate kolokvijuma!")

        val obavestenje1 = ThirdDashboard("Sutra nemate predavanja iz predmeta Matematika 2")
        val obavestenje2 = ThirdDashboard("Od 05.09.2020 do 05.11.2020 casovi ce biti skraceni")
//        val obavestenje3 = ThirdDashboard("Sutra nemate predavanja iz predmeta Matematika 2")
//

        dataListFirst.add(item1)
        dataListFirst.add(item3)
        dataListFirst.add(item2)

        dataListSecond.add(obaveza1)
        dataListSecond.add(obaveza2)
//        dataListSecond.add(obaveza3)
//        dataListSecond.add(obaveza4)
//
        dataListThird.add(obavestenje1)
        dataListThird.add(obavestenje2)
//        dataListThird.add(obavestenje3)
//
        val firstRecycler = recylcer_first_dashboard_test
//        firstRecycler.layoutManager = LinearLayoutManager(context)
//        firstRecycler.adapter = DashboardFirstAdapter(dataListFirst)
        firstRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        firstRecycler.adapter = DashboardFirstAdapter(dataListFirst)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(firstRecycler)

//
        val secondRecycler = recycler_second_dashboard_test
        secondRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        secondRecycler.adapter = DashboardSecondAdapter(dataListSecond)
        val snapHelperSecond: SnapHelper = LinearSnapHelper()
        snapHelperSecond.attachToRecyclerView(secondRecycler)

        val thirdRecycler = recylcer_third_dashboard_test
        thirdRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        thirdRecycler.adapter = DashboardThirdAdapter(dataListThird)
        val snapHelperThird: SnapHelper = LinearSnapHelper()
        snapHelperThird.attachToRecyclerView(thirdRecycler)
    }
}
