package com.example.calculatorapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sales_tax_calculate.*
import kotlinx.android.synthetic.main.activity_sales_tax_calculate.backButton
import kotlinx.android.synthetic.main.dialog_salestax_solutions.view.*

class SalesTaxCalculateActivity : AppCompatActivity() {
    var price=0.0
    var tax=0.0
    var finalprice=0.0
    var taxamount=0.0
    var method="Add"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales_tax_calculate)
        backButton.setOnClickListener {
            finish()
        }

        linearLayout2.setOnClickListener {
            if(A_value.text.toString()==""){
                price=0.0
            }else{
               price=A_value.text.toString().toDouble()
            }

            if(B_value.text.toString()==""){
                tax=0.0
            }else{
                tax=B_value.text.toString().toDouble()
            }
            finalprice=calculateSalesTax(price,tax,method).first
            taxamount=calculateSalesTax(price,tax,method).second
            val view = View.inflate(this, R.layout.dialog_salestax_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.answer.text=finalprice.toString()
            view.answer_.text=taxamount.toString()
        }
    }

    fun addOnClick(view: View){
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        add.setTextColor(colorYellow)
        sub.setTextColor(colorGrey)
        method="Add"
    }
    fun subOnClick(view: View){
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        sub.setTextColor(colorYellow)
        add.setTextColor(colorGrey)
        method="Subtract"
    }
    fun calculateSalesTax(price: Double, taxPercentage: Double, method: String): Pair<Double, Double> {
        val taxAmount = price * taxPercentage / 100.0
        val finalPrice = when (method) {
            "Add" -> price + taxAmount
            "Subtract" -> price - taxAmount
            else -> price
        }
        return Pair(finalPrice, taxAmount)
    }
}