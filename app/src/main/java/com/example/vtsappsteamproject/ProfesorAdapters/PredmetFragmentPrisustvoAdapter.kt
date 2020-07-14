package com.example.vtsappsteamproject.ProfesorAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vtsappsteamproject.DataPrototype.PredmetFragmentPrisustvoData
import com.example.vtsappsteamproject.R
import kotlinx.android.synthetic.main.fragment_predmet_prisustvo_list.view.*

class PredmetiFragmentPrisustvoHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvIme: TextView = view.findViewById(R.id.tv_fragment_predmet_prisustvo_list)
    val tvIndeks: TextView = view.findViewById(R.id.tv_predmet_prisustvo_list_indeks)
}

class PredmetFragmentPrisustvoAdapter (private var arrayList: List<PredmetFragmentPrisustvoData>) : RecyclerView.Adapter<PredmetiFragmentPrisustvoHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PredmetiFragmentPrisustvoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_predmet_prisustvo_list, parent, false)
        return PredmetiFragmentPrisustvoHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: PredmetiFragmentPrisustvoHolder, position: Int) {
        val itemArray = arrayList[position]
        holder.tvIme.text = itemArray.ime_prezime
        holder.tvIndeks.text = itemArray.brojIndeksa
    }
}