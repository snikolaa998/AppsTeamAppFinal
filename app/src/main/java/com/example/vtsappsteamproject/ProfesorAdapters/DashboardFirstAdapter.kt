package com.example.vtsappsteamproject.ProfesorAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vtsappsteamproject.DataPrototype.FirstDashboard
import com.example.vtsappsteamproject.R
import kotlinx.android.synthetic.main.dashboard_first_layout.view.*

class DashboardFirstHolder(view: View) : RecyclerView.ViewHolder(view) {

    var tvVreme: TextView = view.findViewById(R.id.tv_dashboard_first_vreme)
    var tvPredmet: TextView = view.findViewById(R.id.tv_dashboard_first_ime_predmeta)

}

class DashboardFirstAdapter(private var arrayList: List<FirstDashboard>) : RecyclerView.Adapter<DashboardFirstHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardFirstHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_first_layout_test, parent, false)
        return DashboardFirstHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: DashboardFirstHolder, position: Int) {
        val itemArray = arrayList[position]
        holder.tvPredmet.text = itemArray.predmet
        holder.tvVreme.text = itemArray.vreme
    }
}