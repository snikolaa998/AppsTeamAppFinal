package com.example.vtsappsteamproject.ProfesorAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vtsappsteamproject.DataPrototype.ThirdDashboard
import com.example.vtsappsteamproject.R

class DashboardThirdHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvObavestenje: TextView = view.findViewById(R.id.tv_dashboard_third_notifikacija)
}
class DashboardThirdAdapter(private var arrayList: List<ThirdDashboard>) : RecyclerView.Adapter<DashboardThirdHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardThirdHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_third_layout_test, parent, false)
        return DashboardThirdHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: DashboardThirdHolder, position: Int) {
        val itemArray = arrayList[position]
        holder.tvObavestenje.text = itemArray.obavestenje
    }
}