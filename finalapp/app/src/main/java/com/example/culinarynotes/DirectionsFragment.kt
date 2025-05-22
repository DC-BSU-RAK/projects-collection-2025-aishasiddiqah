package com.example.culinarynotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DirectionsFragment : Fragment() {
    companion object {
        fun newInstance(description: String): DirectionsFragment {
            val fragment = DirectionsFragment()
            val args = Bundle()
            args.putString("directions", description)
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_directions, container, false).apply {
            val data = arguments?.getString("directions") ?: "Data Unavailable"
            findViewById<TextView>(R.id.directionsText).text = data
        }
    }

}