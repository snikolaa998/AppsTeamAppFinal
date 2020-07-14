package com.example.vtsappsteamproject.ProfesorFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vtsappsteamproject.DataPrototype.UkupanDolazakData
import com.example.vtsappsteamproject.ProfesorActivities.TabActivity
import com.example.vtsappsteamproject.ProfesorAdapters.PredmetUkupnoDolazakaAdapter

import com.example.vtsappsteamproject.R
import kotlinx.android.synthetic.main.fragment_ukupno_dolaska.*

/**
 * A simple [Fragment] subclass.
 */
class UkupnoDolaskaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ukupno_dolaska, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val tabButton = view?.findViewById<Button>(R.id.btn_tab_layout)
        val firstSpinner = view?.findViewById<Spinner>(R.id.spinner_ukupno_dolaza_first)
        val secondSpinner = view?.findViewById<Spinner>(R.id.spinner_ukupno_dolazaka_second)

        val firstSpinnerOptions = arrayOf("Prisustvo", "Obaveze")
        val secondSpinnerOptions = arrayOf("Ukupno dolazaka", "Termin 1", "Termin 2")

        firstSpinner?.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, firstSpinnerOptions)
        secondSpinner?.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, secondSpinnerOptions)

        firstSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context, "Odaberite godinu", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(position == 1) {
                    val predmetObavezeFragment = PredmetObavezeFragment()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.frame_layout, predmetObavezeFragment)
                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ?.commit()
                }
            }
        }

        secondSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context, "Odaberite godinu", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 1 || position == 2) {
                    val predmetPrisustvoFragment = PredmetPrisustvoFragment()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.frame_layout, predmetPrisustvoFragment)
                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ?.commit()
                }
            }
        }


        val studentList = ArrayList<UkupanDolazakData>()
        studentList.add(UkupanDolazakData("Jovan Jovanovic", "Rer 10/15", "7/10"))
        studentList.add(UkupanDolazakData("Jovan Jovanovic", "Rer 10/15", "7/10"))
        studentList.add(UkupanDolazakData("Jovan Jovanovic", "Rer 10/15", "7/10"))
        studentList.add(UkupanDolazakData("Jovan Jovanovic", "Rer 10/15", "7/10"))
        studentList.add(UkupanDolazakData("Jovan Jovanovic", "Rer 10/15", "7/10"))

        recycler_ukupno_dolazaka.layoutManager = LinearLayoutManager(context)
        recycler_ukupno_dolazaka.adapter = PredmetUkupnoDolazakaAdapter(studentList)

        tabButton?.setOnClickListener {
            val intent = Intent(context, TabActivity::class.java)
            startActivity(intent)
        }
    }
}
