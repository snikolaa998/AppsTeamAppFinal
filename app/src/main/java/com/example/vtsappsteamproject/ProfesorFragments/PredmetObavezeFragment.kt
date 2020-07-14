package com.example.vtsappsteamproject.ProfesorFragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vtsappsteamproject.DataPrototype.PredmetFragmentObaveze
import com.example.vtsappsteamproject.ProfesorAdapters.PredmetFragmentObavezaAdapter

import com.example.vtsappsteamproject.R
import kotlinx.android.synthetic.main.fragment_predmet_obaveze.*

/**
 * A simple [Fragment] subclass.
 */
class PredmetObavezeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_predmet_obaveze, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val spinner1 = view?.findViewById<Spinner>(R.id.spinner_fragment_predmet_obaveza)
        val spinner2 = view?.findViewById<Spinner>(R.id.spinner_fragment_predmet_test)

        val spinnerOptionsOne = arrayOf("Obaveze", "Prisustvo", "Domaci")
        val spinnerOptionsTwo = arrayOf("Test 1 - 1.5.2020", "Test 2 - 10.5.2020")

        spinner1?.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, spinnerOptionsOne)
        spinner2?.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, spinnerOptionsTwo)

        spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context, "Odaberite godinu", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 1) {
                    val predmetPrisustvoFragment = PredmetPrisustvoFragment()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.frame_layout, predmetPrisustvoFragment)
                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ?.commit()
                }
            }
        }

        val studentList = ArrayList<PredmetFragmentObaveze>()

        studentList.add(PredmetFragmentObaveze("Petar Petrovic", "Rer 22/19"))
        studentList.add(PredmetFragmentObaveze("Petar Petrovic", "Rer 22/19"))
        studentList.add(PredmetFragmentObaveze("Petar Petrovic", "Rer 22/19"))
        studentList.add(PredmetFragmentObaveze("Petar Petrovic", "Rer 22/19"))

        recycler_fragment_predmet_obaveza.layoutManager = LinearLayoutManager(context)
        recycler_fragment_predmet_obaveza.adapter = PredmetFragmentObavezaAdapter(studentList, context!!)
    }

}
