package com.example.vtsappsteamproject.ProfesorFragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import com.example.vtsappsteamproject.ProfesorActivities.TabActivity

import com.example.vtsappsteamproject.R

/**
 * A simple [Fragment] subclass.
 */
class PredavanjaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_predavanja, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val btnPotvrdi = view?.findViewById<Button>(R.id.btn_fragment_predavanja_potvrdi)
        btnPotvrdi?.setOnClickListener {
            val alert = AlertDialog.Builder(context)
            alert.setTitle("Uspesno ste dodali rad")
            alert.setCancelable(false)
            alert.setMessage("Kliknite ok da se vratite nazad")
            alert.setNegativeButton("OK", DialogInterface.OnClickListener { dialog, which ->
            })
            alert.show()
        }
    }
}
