package com.example.calculatorapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tip_calculate.*
import kotlinx.android.synthetic.main.activity_tip_calculate.A_value
import kotlinx.android.synthetic.main.activity_tip_calculate.B_value
import kotlinx.android.synthetic.main.activity_tip_calculate.backButton
import kotlinx.android.synthetic.main.activity_tip_calculate.linearLayout2
import kotlinx.android.synthetic.main.dialog_tip_solutions.view.*

class TipCalculateActivity : AppCompatActivity() {
    var bill=0.0
    var people=0
    var tip=0.0
    var finalBill=0.0
    var cost_person=0.0
    var tipamount =0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_calculate)
        backButton.setOnClickListener {
            finish()
        }
        linearLayout2.setOnClickListener {
            if(A_value.text.toString()==""){
                bill=0.0
            }else{
                bill=A_value.text.toString().toDouble()
            }

            if(B_value.text.toString()==""){
                people=0
            }else{
                people=B_value.text.toString().toInt()
            }
            if(C_value.text.toString()==""){
                tip=0.0
            }else{
                tip=C_value.text.toString().toDouble()
            }
            finalBill=calculateBillCost(bill,tip,people).first
            cost_person=calculateBillCost(bill,tip,people).second
            tipamount=calculateBillCost(bill,tip,people).third

            val view = View.inflate(this, R.layout.dialog_tip_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.answer.text=finalBill.toString()
            view.answer_.text=cost_person.toString()
            view.answer_3.text=tipamount.toString()
        }
    }
    fun calculateBillCost(billAmount: Double, tipPercentage: Double, numberOfPeople: Int): Triple<Double, Double, Double> {
        val tipAmount = billAmount * tipPercentage / 100
        val finalBillCost = billAmount + tipAmount
        val costPerPerson = finalBillCost / numberOfPeople
        return Triple(finalBillCost, costPerPerson, tipAmount)
    }
}