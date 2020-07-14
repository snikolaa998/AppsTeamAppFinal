package com.example.vtsappsteamproject.ProfesorFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vtsappsteamproject.DataPrototype.PredmetFragmentPrisustvoData
import com.example.vtsappsteamproject.ProfesorAdapters.PredmetFragmentPrisustvoAdapter

import com.example.vtsappsteamproject.R
import kotlinx.android.synthetic.main.fragment_predmet_prisustvo.*

/**
 * A simple [Fragment] subclass.
 */
class PredmetPrisustvoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_predmet_prisustvo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val studentList = ArrayList<PredmetFragmentPrisustvoData>()
        val firstSpinner = view?.findViewById<Spinner>(R.id.spinner_fragment_predmet_prisustvo)
        val secondSpinner = view?.findViewById<Spinner>(R.id.spinner_fragment_predmet_termin)

        val spinnerOptions = arrayOf("Prisustvo", "Obaveze")
        val spinnerOptionsTwo = arrayOf("Termin 1", "Termin 2", "Ukupan broj dolazaka")

        firstSpinner?.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, spinnerOptions)
        secondSpinner?.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, spinnerOptionsTwo)

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
                if (position == 1) {
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
                if (position == 2) {
                    val ukupnoDolaskaFragment = UkupnoDolaskaFragment()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.frame_layout, ukupnoDolaskaFragment)
                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ?.commit()
                }
            }
        }

        studentList.add(PredmetFragmentPrisustvoData("Jovan Jovanovic", "Rer 10/15"))
        studentList.add(PredmetFragmentPrisustvoData("Jovan Jovanovic", "Rer 10/15"))
        studentList.add(PredmetFragmentPrisustvoData("Jovan Jovanovic", "Rer 10/15"))
        studentList.add(PredmetFragmentPrisustvoData("Jovan Jovanovic", "Rer 10/15"))
        studentList.add(PredmetFragmentPrisustvoData("Jovan Jovanovic", "Rer 10/15"))

        recycler_fragment_predmet_prisustvo.layoutManager = LinearLayoutManager(context)
        recycler_fragment_predmet_prisustvo.adapter = PredmetFragmentPrisustvoAdapter(studentList)
    }
}
