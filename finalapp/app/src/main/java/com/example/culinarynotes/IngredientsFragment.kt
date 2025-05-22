package com.example.culinarynotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class IngredientsFragment : Fragment() {

    companion object {
        fun newInstance(ingredients: String): IngredientsFragment {
            val fragment = IngredientsFragment()
            val args = Bundle()
            args.putString("ingredients", ingredients)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ingredients, container, false).apply {
            val data = arguments?.getString("ingredients") ?: "Data Unavailable"
            findViewById<TextView>(R.id.ingredientsText).text = data
        }
    }
}