package com.example.calculatorapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.calculatorapp.databinding.FragmentSimpleCalculationBinding
import kotlinx.android.synthetic.main.fragment_simple_calculation.*


class SimpleCalculationFragment : Fragment(R.layout.fragment_simple_calculation) {
    private var _binding: FragmentSimpleCalculationBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSimpleCalculationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        change_screen.setOnClickListener{
            val intent=Intent(requireActivity(),AdvancedCalculatorActivity::class.java)
            startActivity(intent)
        }


    }



}