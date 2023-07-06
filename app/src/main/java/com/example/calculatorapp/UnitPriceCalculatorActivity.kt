package com.example.calculatorapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sales_tax_calculate.*
import kotlinx.android.synthetic.main.dialog_salestax_solutions.view.*

class UnitPriceCalculatorActivity : AppCompatActivity() {
    var price=0.0
    var qty=0
    var unitprice=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_price_calculator)
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
                qty=0
            }else{
                qty=B_value.text.toString().toInt()
            }
            unitprice=calculateUnitPrice(price,qty)
            val view = View.inflate(this, R.layout.dialog_unitprice_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.answer.text=unitprice.toString()
        }
    }
    fun calculateUnitPrice(price: Double, qty: Int): Double {
        if (qty == 0) {
            return 0.0
        }
        return price / qty
    }
}