package com.example.vtsappsteamproject.ProfesorFragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.vtsappsteamproject.ProfesorActivities.NavigationActivity

import com.example.vtsappsteamproject.R

/**
 * A simple [Fragment] subclass.
 */
class OsoboljeSingleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_osobolje_single, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as NavigationActivity).supportActionBar?.title = "Osoblje"

        val imeOsobljeTextView = view?.findViewById<TextView>(R.id.tv_fragment_osobolje_single_ime)
        val emailTextView = view?.findViewById<TextView>(R.id.tv_fragment_osoblje_singl_email)
        val emailView = view?.findViewById<View>(R.id.view8)
        val callView = view?.findViewById<View>(R.id.view9)

        val number = "+381694401292"
        val email = arguments?.getString("email")
        val ime = arguments?.getString("osobljeIme")
        imeOsobljeTextView?.text = ime
        emailTextView?.text = email

        emailView?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null))
            startActivity(Intent.createChooser(intent, "Posaljite email"))
        }
        callView?.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$number")
            startActivity(Intent.createChooser(intent, "Pozovite!"))
        }

    }
}
