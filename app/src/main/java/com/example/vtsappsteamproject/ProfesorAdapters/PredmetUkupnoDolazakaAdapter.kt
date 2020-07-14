package com.example.vtsappsteamproject.ProfesorAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vtsappsteamproject.DataPrototype.UkupanDolazakData
import com.example.vtsappsteamproject.R

class PredmetUkupnoDolazakaHolder(view: View) : RecyclerView.ViewHolder(view) {

    var tvIme: TextView = view.findViewById(R.id.tv_fragment_ukupno_dolazaka_ime)
    var tvIndeks: TextView = view.findViewById(R.id.tv_fragment_ukupno_dolazaka_indeks)
    var ukupnoDolazaka: TextView = view.findViewById(R.id.tv_ukupno_dolazak)
}

class PredmetUkupnoDolazakaAdapter (private var arrayList: List<UkupanDolazakData>) : RecyclerView.Adapter<PredmetUkupnoDolazakaHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PredmetUkupnoDolazakaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_ukupno_dolazaka_list, parent, false)
        return PredmetUkupnoDolazakaHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: PredmetUkupnoDolazakaHolder, position: Int) {

        val itemArray = arrayList[position]
        holder.tvIndeks.text = itemArray.brojIndeksa
        holder.tvIme.text = itemArray.ime_prezime
        holder.ukupnoDolazaka.text = itemArray.brojDolaska
    }
}