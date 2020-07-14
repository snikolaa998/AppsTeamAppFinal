package com.example.vtsappsteamproject.ProfesorFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.vtsappsteamproject.ProfesorActivities.NavigationActivity

import com.example.vtsappsteamproject.R

/**
 * A simple [Fragment] subclass.
 */
class PodPredmetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pod_predmet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val ime = arguments?.getString("ime")
        (activity as NavigationActivity).supportActionBar?.title = ime
        val podPredmetSpinner = view?.findViewById<Spinner>(R.id.spinner_fragment_pod_predmet)
        val spinnerOptions = arrayOf("Literatura", "Zadaci za vezbu", "Obaveze", "Prisustvo", "Rezultati")
        podPredmetSpinner?.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, spinnerOptions)
        podPredmetSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
                    val predmetObavezeFragment = PredmetObavezeFragment()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.frame_layout, predmetObavezeFragment)
                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ?.commit()
                } else if(position == 3) {
                    val predmetPrisustvoFragment = PredmetPrisustvoFragment()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.frame_layout, predmetPrisustvoFragment)
                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ?.commit()
                }
            }
        }
    }
}
