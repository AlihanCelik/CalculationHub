package com.example.calculatorapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorapp.finance.*
import kotlinx.android.synthetic.main.fragment_finance_category.*


class FinanceCategoryFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finance_category, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        invest_Calculate.setOnClickListener {
            val intent=Intent(requireActivity(), InvestmentCalculateActivity::class.java)
            startActivity(intent)
        }
        credit_calculate.setOnClickListener {
            val intent=Intent(requireActivity(), creditCalculatorActivity::class.java)
            startActivity(intent)
        }
        salestax_calculate.setOnClickListener {
            val intent=Intent(requireActivity(), SalesTaxCalculateActivity::class.java)
            startActivity(intent)
        }
        unitprice_calculate.setOnClickListener {
            val intent=Intent(requireActivity(), UnitPriceCalculatorActivity::class.java)
            startActivity(intent)
        }
        tip_calculate.setOnClickListener {
            val intent=Intent(requireActivity(), TipCalculateActivity::class.java)
            startActivity(intent)
        }
        currency_calculate.setOnClickListener {
            val intent=Intent(requireActivity(), CurrencyCalculatorActivity::class.java)
            startActivity(intent)
        }
    }


}