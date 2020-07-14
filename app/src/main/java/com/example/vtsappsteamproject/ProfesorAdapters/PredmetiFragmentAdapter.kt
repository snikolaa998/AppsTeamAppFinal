package com.example.vtsappsteamproject.ProfesorAdapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.vtsappsteamproject.DataPrototype.PredmetiFragmentData
import com.example.vtsappsteamproject.ProfesorFragments.PodPredmetFragment
import com.example.vtsappsteamproject.R

class PredmetDataHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvPredmet: TextView = view.findViewById(R.id.tv_predmeti_fragment_list)
    val itemConstraint: ConstraintLayout = view.findViewById(R.id.predmeti_layout)
}

class PredmetiFragmentAdapter(private var arrayList: List<PredmetiFragmentData>, private var context: Context) : RecyclerView.Adapter<PredmetDataHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PredmetDataHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.predmeti_fragment_list_layout, parent, false)
        return PredmetDataHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: PredmetDataHolder, position: Int) {

        val itemArray = arrayList[position]
        holder.tvPredmet.text = itemArray.predmet
        holder.itemConstraint.setOnClickListener {
            val podPredmetFragment = PodPredmetFragment()
            val manager = (holder.itemView.context as FragmentActivity).supportFragmentManager

            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frame_layout, podPredmetFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
            val bundle = Bundle()
            bundle.putString("ime", itemArray.predmet)
            podPredmetFragment.arguments = bundle
        }
    }
}