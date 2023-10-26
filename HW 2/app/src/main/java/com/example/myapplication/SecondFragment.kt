package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.myapplication.databinding.FragmentSecondBinding
import java.util.Random

class SecondFragment : Fragment() {
    private var binding: FragmentSecondBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val count = requireArguments().getInt("count")
        val countText = getString(R.string.random_heading, count)
        val headerView = requireView().findViewById<TextView>(R.id.textview_header)
        headerView.text = countText
        val random = Random()
        var randomNumber = 0
        if (count > 0) {
            randomNumber = random.nextInt(count + 1)
        }
        val randomView = requireView().findViewById<TextView>(R.id.textview_random)
        randomView.text = randomNumber.toString()
        val navController = findNavController(view)
        view.findViewById<View>(R.id.buttonSecond).setOnClickListener {
            navController.navigate(
                R.id.action_SecondFragment_to_FirstFragment
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}