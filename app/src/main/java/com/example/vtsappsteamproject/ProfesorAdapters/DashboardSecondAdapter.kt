package com.example.vtsappsteamproject.ProfesorAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vtsappsteamproject.DataPrototype.SecondDashboard
import com.example.vtsappsteamproject.R

class DashboardSecondHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvObaveza: TextView = view.findViewById(R.id.tv_dashboard_second_obaveza)
}
class DashboardSecondAdapter(private var arrayList: List<SecondDashboard>) : RecyclerView.Adapter<DashboardSecondHolder>() {
    override fun getItemCount(): Int {
        return 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardSecondHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_second_layout_test, parent, false)
        return DashboardSecondHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardSecondHolder, position: Int) {
        val itemArray = arrayList[position]
        holder.tvObaveza.text = itemArray.obaveza
    }
}