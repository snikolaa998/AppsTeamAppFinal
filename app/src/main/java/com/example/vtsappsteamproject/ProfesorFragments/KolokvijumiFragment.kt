package com.example.vtsappsteamproject.ProfesorFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.vtsappsteamproject.R

/**
 * A simple [Fragment] subclass.
 */
class KolokvijumiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kolokvijumi, container, false)
    }

}
