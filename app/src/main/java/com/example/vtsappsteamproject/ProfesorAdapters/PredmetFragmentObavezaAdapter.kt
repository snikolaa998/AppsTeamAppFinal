package com.example.vtsappsteamproject.ProfesorAdapters

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vtsappsteamproject.DataPrototype.PredmetFragmentObaveze
import com.example.vtsappsteamproject.R

class PredmetOdabirHolder(view: View) : RecyclerView.ViewHolder(view) {

    var tvImePrezime: TextView = view.findViewById(R.id.tv_fragment_predmet_obaveza_list_ime)
    var tvBrojIndeksa: TextView = view.findViewById(R.id.tv_fragment_predmet_obaveza_list_indeks)
    var imageView: ImageView = view.findViewById(R.id.iv_fragment_predmet_obaveze_list)
}

class PredmetFragmentObavezaAdapter(private var arrayList: List<PredmetFragmentObaveze>, private var context: Context) : RecyclerView.Adapter<PredmetOdabirHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PredmetOdabirHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_predmet_obaveze_list, parent, false)
        return PredmetOdabirHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: PredmetOdabirHolder, position: Int) {
        val itemArray = arrayList[position]
        holder.tvImePrezime.text = itemArray.ime_prezime
        holder.tvBrojIndeksa.text = itemArray.brojIndeksa
        holder.imageView.setOnClickListener {
            val alert = AlertDialog.Builder(context)
            alert.setTitle("Doslo je do greske")
            alert.setCancelable(false)
            alert.setMessage("Student nije dodao rad")
            alert.setNegativeButton("OK", DialogInterface.OnClickListener { dialog, which ->
            })
            alert.show()
        }
    }
}