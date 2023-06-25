package com.example.calculatorapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_gcf_lcm_calculator.A_value
import kotlinx.android.synthetic.main.activity_gcf_lcm_calculator.B_value
import kotlinx.android.synthetic.main.activity_gcf_lcm_calculator.backButton
import kotlinx.android.synthetic.main.activity_gcf_lcm_calculator.linearLayout2
import kotlinx.android.synthetic.main.dialog_gcf_lcm_solutions.view.*

class GcfLcmCalculatorActivity : AppCompatActivity() {
    var a=0
    var b=0
    var answer=""
    var answer_=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gcf_lcm_calculator)
        backButton.setOnClickListener {
            finish()
        }
        linearLayout2.setOnClickListener {


            if(A_value.text.toString()==""){
                a=0
            }else{
                a=A_value.text.toString().toInt()
            }
            if(B_value.text.toString()==""){
                b=0
            }else{
                b=B_value.text.toString().toInt()
            }

            if (a == 0 && b == 0) {
                answer="Undefined"
                answer_="Undefined"
            }else{
                answer=findGCF(a,b).toString()
                answer_=((a * b) / findGCF(a, b)).toString()
            }


            val view = View.inflate(this, R.layout.dialog_gcf_lcm_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.x_answer.text=answer
            view.y_answer.text=answer_


        }
    }
    fun findGCF(a: Int, b: Int): Int {
        if (a == 0 && b == 0) {
            return 0
        }
        var num1 = a
        var num2 = b

        while (num2 != 0) {
            val temp = num2
            num2 = num1 % num2
            num1 = temp
        }

        return num1
    }
}