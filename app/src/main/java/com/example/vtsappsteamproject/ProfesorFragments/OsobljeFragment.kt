package com.example.vtsappsteamproject.ProfesorFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vtsappsteamproject.DataPrototype.OsobljeFragmentData
import com.example.vtsappsteamproject.ProfesorActivities.NavigationActivity
import com.example.vtsappsteamproject.ProfesorAdapters.OsoboljeFragmentAdapter

import com.example.vtsappsteamproject.R
import kotlinx.android.synthetic.main.fragment_osoblje.*

/**
 * A simple [Fragment] subclass.
 */
class OsobljeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_osoblje, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as NavigationActivity).supportActionBar?.title = "Osoblje"

        val firstSpinner = view?.findViewById<Spinner>(R.id.spinner_fragment_osoblje)
        val spinnerOptions = arrayOf("Profesori", "Asistenti", "Svi")
        firstSpinner?.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, spinnerOptions)

        val profesorList = ArrayList<OsobljeFragmentData>()

        profesorList.add(OsobljeFragmentData("Dr Mirko Kosanovic", "Email:mirkokosanovic@vts.edu.rs"))
        profesorList.add(OsobljeFragmentData("Dr Zoran Velickovic", "Email:zoranvelickovic@vts.edu.rs"))
        profesorList.add(OsobljeFragmentData("Dr Mirko Kosanovic", "Email:mirkokosanovic@vts.edu.rs"))
        profesorList.add(OsobljeFragmentData("Dr Zoran Velickovic", "Email:zoranvelickovic@vts.edu.rs"))

        val asistentList = ArrayList<OsobljeFragmentData>()
        asistentList.add(OsobljeFragmentData("Nikola Vasic", "Email:nikolavasic@vts.edu.rs"))
        asistentList.add(OsobljeFragmentData("Milos Kosanovic", "Email:miloskosanovic@vts.edu.rs"))
        asistentList.add(OsobljeFragmentData("Nikola Vasic", "Email:nikolavasic@vts.edu.rs"))
        asistentList.add(OsobljeFragmentData("Milos Kosanovic", "Email:miloskosanovic@vts.edu.rs"))

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
                when(position) {
                    0 -> {
                        recyclerView_fragment_osoblje.layoutManager = LinearLayoutManager(context)
                        recyclerView_fragment_osoblje.adapter = OsoboljeFragmentAdapter(profesorList)
                    }
                    1 -> {
                        recyclerView_fragment_osoblje.layoutManager = LinearLayoutManager(context)
                        recyclerView_fragment_osoblje.adapter = OsoboljeFragmentAdapter(asistentList)
                    }
                }

            }
        }

    }
}
