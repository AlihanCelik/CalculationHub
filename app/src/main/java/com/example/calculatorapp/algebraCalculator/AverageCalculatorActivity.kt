package com.example.calculatorapp.algebraCalculator

import android.app.AlertDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculatorapp.R
import kotlinx.android.synthetic.main.activity_average_calculator.A_value
import kotlinx.android.synthetic.main.activity_average_calculator.B_value
import kotlinx.android.synthetic.main.activity_average_calculator.backButton
import kotlinx.android.synthetic.main.activity_average_calculator.linearLayout2
import kotlinx.android.synthetic.main.dialog_average_solutions.view.*
import kotlinx.android.synthetic.main.dialog_percentage_solutions.view.cancel

class AverageCalculatorActivity : AppCompatActivity() {
    var a=0.0
    var b=0.0
    var ave_answer=""
    var geo_answer=""
    var har_answer=""
    var ave_solutions=""
    var geo_solutions=""
    var har_solutions=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_average_calculator)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        linearLayout2.setOnClickListener {


            if(A_value.text.toString()==""){
                a=0.0
            }else{
                a = A_value.text.toString().toDouble()
            }
            if(B_value.text.toString()==""){
                b=0.0
            }else{
                b=B_value.text.toString().toDouble()
            }
            var cevap1=((a+b)/2).toDouble()
            var cevap2=Math.sqrt(a*b).toDouble()
            var cevap3=2/((1/a)+(1/b)).toDouble()
            ave_answer=cevap1.toString()
            geo_answer=cevap2.toString()
            har_answer=cevap3.toString()
            ave_solutions="A = (x1 + x2 + ... + xn)/n \n= ($a + $b)/2 \n= ${a+b}/2\n= $ave_answer"
            geo_solutions="G = ⁿ√(x1 * x2 * ... * xn)\n= ²√($a x $b)\n= ²√${a*b} \n= $geo_answer"
            har_solutions="H = n/((1/x1) + (1/x2) + .... + (1/xn))\n= 2/((1/$a)+(1/$b))\n= 2/${(1/a)+(1/b)}\n= $har_answer"
            val view = View.inflate(this, R.layout.dialog_average_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.a_answer.text=ave_answer
            view.g_answer.text=geo_answer
            view.h_answer.text=har_answer
            view.a_solutions.text=ave_solutions
            view.g_solutions.text=geo_solutions
            view.h_solutions.text=har_solutions


        }
    }
}