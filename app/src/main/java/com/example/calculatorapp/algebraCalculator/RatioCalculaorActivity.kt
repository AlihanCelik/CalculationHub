package com.example.calculatorapp.algebraCalculator

import android.app.AlertDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_ratio_calculaor.*
import kotlinx.android.synthetic.main.activity_ratio_calculaor.A_value
import kotlinx.android.synthetic.main.activity_ratio_calculaor.B_value
import kotlinx.android.synthetic.main.activity_ratio_calculaor.backButton
import kotlinx.android.synthetic.main.activity_ratio_calculaor.linearLayout2
import kotlinx.android.synthetic.main.dialog_ratio_solutions.view.*

class RatioCalculaorActivity : AppCompatActivity() {
    var a=0.0
    var b=0.0
    var x=0.0
    var y=0.0
    var answer=""
    var answer_=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratio_calculaor)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        raSelect.setOnClickListener {

            val bottomSheet =
                BottomSheetDialog(this@RatioCalculaorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_ratio_solutions,
                findViewById(R.id.bottomSheetRatio)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.ratio).setOnClickListener {
                ra_cal_name.text = "Ratio"
                ra_procces.text="a/b = x/y"
                A_string.text="A"
                B_string.text="B"
                visi.visibility=View.GONE
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.numerator).setOnClickListener {
                ra_cal_name.text = "Numerator"
                ra_procces.text="a = (b * x)/y"
                A_string.text="B"
                B_string.text="X"
                visi.visibility=View.VISIBLE
                x_string.text="Y"
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.deminator).setOnClickListener {
                ra_cal_name.text = "Denominator"
                ra_procces.text="b = (a * y)/x"
                A_string.text="A"
                B_string.text="X"
                visi.visibility=View.VISIBLE
                x_string.text="Y"
                bottomSheet.dismiss()

            }

            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        linearLayout2.setOnClickListener {
            if(ra_cal_name.text == "Ratio"){
                if(A_value.text.toString()==""){
                    a=0.0
                }else{
                    a=A_value.text.toString().toDouble()
                }
                if(B_value.text.toString()==""){
                    b=0.0
                }else{
                    b=B_value.text.toString().toDouble()
                }

                var ortak=findEBOB(a,b)
                var cevap1=(a/ortak).toDouble()
                var cevap2=(b/ortak).toDouble()
                answer=cevap1.toString()
                answer_=cevap2.toString()
            }
            if(ra_cal_name.text == "Numerator"){
                if(A_value.text.toString()==""){
                    b=0.0
                }else{
                    b=A_value.text.toString().toDouble()
                }
                if(B_value.text.toString()==""){
                    x=0.0
                }else{
                    x=B_value.text.toString().toDouble()
                }
                if(XY_value.text.toString()==""){
                    y=0.0
                }else{
                    y=XY_value.text.toString().toDouble()
                }

                var result=(b/y).toDouble()
                var cevap1=(x*result).toDouble()
                answer=cevap1.toString()
            }
            if(ra_cal_name.text == "Denominator"){
                if(A_value.text.toString()==""){
                    a=0.0
                }else{
                    a=A_value.text.toString().toDouble()
                }
                if(B_value.text.toString()==""){
                    x=0.0
                }else{
                    x=B_value.text.toString().toDouble()
                }
                if(XY_value.text.toString()==""){
                    y=0.0
                }else{
                    y=XY_value.text.toString().toDouble()
                }
                var result=(a/x).toDouble()
                var cevap1=(y*result).toDouble()
                answer=cevap1.toString()
            }



            val view = View.inflate(this, R.layout.dialog_ratio_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            if(ra_cal_name.text == "Ratio"){
                view.dialog_a_string.text="X"
                view.visib.visibility=View.VISIBLE
                view.a_answer.text=answer
                view.dialog_x_string.text="Y"
                view.x_answer.text=answer_

            }
            if(ra_cal_name.text == "Numerator"){
                view.dialog_a_string.text="A"
                view.visib.visibility=View.GONE
                view.a_answer.text=answer
            }
            if(ra_cal_name.text == "Denominator"){
                view.dialog_a_string.text="B"
                view.visib.visibility=View.GONE
                view.a_answer.text=answer
            }

        }
    }
    fun findEBOB(a: Double, b: Double): Double {
        var num1 = a
        var num2 = b

        while (num1 != num2) {
            if (num1 > num2)
                num1 -= num2
            else
                num2 -= num1
        }

        return num1
    }
}