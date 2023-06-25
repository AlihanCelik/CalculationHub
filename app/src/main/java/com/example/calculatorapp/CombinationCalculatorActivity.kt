package com.example.calculatorapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_combination_calculator.*
import kotlinx.android.synthetic.main.activity_combination_calculator.linearLayout2
import kotlinx.android.synthetic.main.activity_combination_calculator.method


class CombinationCalculatorActivity : AppCompatActivity() {
    var n=0
    var r=0
    var order=true
    var repeatable=true

    var answer=""
    var solution=""

    val colorYellow=resources.getColor(R.color.yellow)
    val colorGrey=resources.getColor(R.color.grey)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combination_calculator)
        backButton.setOnClickListener {
            finish()
        }
        linearLayout2.setOnClickListener {


            if (A_value.text.toString() == "") {
                a = 0.0
            } else {
                a = A_value.text.toString().toDouble()
            }
            if (B_value.text.toString() == "") {
                b = 0.0
            } else {
                b = B_value.text.toString().toDouble()
            }
            if (X_value.text.toString() == "") {
                x = 0.0
            } else {
                x = X_value.text.toString().toDouble()
            }
            if (pro_cal_name.text == "Directly Proportion") {
                var cevap = ((x*b)/a).toDouble()
                answer = cevap.toString()
                solutions ="$a/$b = $x/y\ny = ($b * $x)/$a\n= ${b*x}/$a\n= $answer"

            }
            if (pro_cal_name.text == "Indirectly Proportion") {
                var cevap = ((a * b) / x).toDouble()
                answer = cevap.toString()
                solutions ="$a*$b = $x*y\n" +
                        "y = ($a * $b)/$x\n" +
                        "= ${a * b}/$x\n" +
                        "= $answer"

            }

            val view = View.inflate(this, R.layout.dialog_proportion_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.answer.text=answer
            view.dialog_solutions.text=solutions
        }
    }
    fun YesOrderClick(view: View){
        method.text="nʳ"
        order=true
        yesOrderedText.setTextColor(colorYellow)
        noOrderedText.setTextColor(colorGrey)

    }
    fun NoOrderClick(view: View){
        method.text="(n + r - 1)! / r! x (n - 1)!"
        order=false
        yesOrderedText.setTextColor(colorGrey)
        noOrderedText.setTextColor(colorYellow)

    }
    fun YesRepeatableClick(view: View){
        if(order){
            method.text="nʳ"
        }
        if(!order){
            method.text="(n + r - 1)! / r! x (n - 1)!"

        }
        yesRepeatableText.setTextColor(colorYellow)
        noRepeatableText.setTextColor(colorGrey)
        repeatable=true

    }
    fun NoRepeatableClick(view: View){
        if(order){
            method.text="n! / (n - r)!"
        }
        if(!order){
            method.text="n! / r! x (n - r)!"

        }
        yesRepeatableText.setTextColor(colorYellow)
        noRepeatableText.setTextColor(colorGrey)
        repeatable=false



    }

}