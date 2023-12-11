package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var binding: FragmentFirstBinding? = null
    private var showCountTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize showCountTextView
        showCountTextView = view.findViewById(R.id.textview_first)

        view.findViewById<View>(R.id.randomButton).setOnClickListener {
            // Get the current count from showCountTextView
            val countString = showCountTextView!!.text.toString()
            var count = countString.toInt()

            // Update the showCountTextView
            showCountTextView!!.text = count.toString()

            // Navigate to SecondFragment with the updated count as an argument
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(count)
            findNavController().navigate(action)
        }

        view.findViewById<View>(R.id.toast_button).setOnClickListener {
            val myToast = Toast.makeText(requireContext(), "Hello toast!", Toast.LENGTH_SHORT)
            myToast.show()
        }

        // Set a click listener on the "Count" button
        view.findViewById<View>(R.id.Count).setOnClickListener { v -> countMe(v) }
    }

    // Increment the count and display it in the TextView
    private fun countMe(view: View) {
        // Get the value of the text view
        val countString = showCountTextView!!.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count++
        // Display the new value in the text view.
        showCountTextView!!.text = count.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
