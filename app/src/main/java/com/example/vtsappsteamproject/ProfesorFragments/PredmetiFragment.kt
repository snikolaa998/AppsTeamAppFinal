package com.example.vtsappsteamproject.ProfesorFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vtsappsteamproject.DataPrototype.PredmetiFragmentData
import com.example.vtsappsteamproject.ProfesorActivities.NavigationActivity
import com.example.vtsappsteamproject.ProfesorAdapters.PredmetiFragmentAdapter
import com.example.vtsappsteamproject.R
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.fragment_predmeti.*


/**
 * A simple [Fragment] subclass.
 */
class PredmetiFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_predmeti, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as NavigationActivity).supportActionBar?.title = "Predmeti"

        val arrayPredmet = ArrayList<PredmetiFragmentData>()
        val arrayPredmet2 = ArrayList<PredmetiFragmentData>()

        arrayPredmet.add(PredmetiFragmentData("Algoritmi i struktura podataka"))
        arrayPredmet.add(PredmetiFragmentData("Osnovi Programiranja"))

        arrayPredmet2.add(PredmetiFragmentData("Matematika 1"))
        arrayPredmet2.add(PredmetiFragmentData("Baze Podataka"))

        val predmetiFragmentSpinner = view?.findViewById<Spinner>(R.id.spinner_fragment_predmeti)
        val spinnerOptions = arrayOf("Skolska godina 2019/2020", "Skolska godina 2018/2019")
        predmetiFragmentSpinner?.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, spinnerOptions)
        predmetiFragmentSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context, "Odaberite godinu", Toast.LENGTH_SHORT).show()
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {
                    recycler_fragment_predmeti.layoutManager = LinearLayoutManager(context)
                    recycler_fragment_predmeti.adapter = PredmetiFragmentAdapter(arrayPredmet, context!!)
                } else if (position == 1) {
                    recycler_fragment_predmeti.layoutManager = LinearLayoutManager(context)
                    recycler_fragment_predmeti.adapter = PredmetiFragmentAdapter(arrayPredmet2, context!!)
                }
            }
        }
    }
}
