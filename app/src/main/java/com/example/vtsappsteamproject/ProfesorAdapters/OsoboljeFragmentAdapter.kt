package com.example.vtsappsteamproject.ProfesorAdapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.vtsappsteamproject.DataPrototype.OsobljeFragmentData
import com.example.vtsappsteamproject.ProfesorFragments.OsoboljeSingleFragment
import com.example.vtsappsteamproject.ProfesorFragments.PodPredmetFragment
import com.example.vtsappsteamproject.R
import kotlinx.android.synthetic.main.osoblje_fragment_list.view.*


class OsobljeFragmentHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvIme: TextView = view.findViewById(R.id.tv_osoblje_ime)
    var tvEmail: TextView = view.findViewById(R.id.tv_osoblje_email)
    var itemLayout: ConstraintLayout = view.findViewById(R.id.fragment_osoblje_list_layout)
}

class OsoboljeFragmentAdapter(private var arrayList: List<OsobljeFragmentData>) : RecyclerView.Adapter<OsobljeFragmentHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OsobljeFragmentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.osoblje_fragment_list, parent, false)
        return OsobljeFragmentHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: OsobljeFragmentHolder, position: Int) {

        val itemArray = arrayList[position]
        holder.tvIme.text = itemArray.ime
        holder.tvEmail.text = itemArray.email
        holder.itemLayout.setOnClickListener {
            val osobljeSingleFragment = OsoboljeSingleFragment()
            val manager = (holder.itemView.context as FragmentActivity).supportFragmentManager

            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frame_layout, osobljeSingleFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit()
            val bundle = Bundle()
            bundle.putString("email", itemArray.email)
            bundle.putString("osobljeIme", itemArray.ime)
            osobljeSingleFragment.arguments = bundle
        }
    }
}