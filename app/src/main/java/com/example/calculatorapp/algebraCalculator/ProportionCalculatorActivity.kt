package com.example.calculatorapp.algebraCalculator

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_proportion_calculator.*
import kotlinx.android.synthetic.main.activity_proportion_calculator.A_value
import kotlinx.android.synthetic.main.activity_proportion_calculator.B_value
import kotlinx.android.synthetic.main.activity_proportion_calculator.backButton
import kotlinx.android.synthetic.main.activity_proportion_calculator.linearLayout2
import kotlinx.android.synthetic.main.dialog_proportion_solutions.view.*

class ProportionCalculatorActivity : AppCompatActivity() {
    var a=0.0
    var b=0.0
    var x=0.0
    var answer=""
    var solutions=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proportion_calculator)
        backButton.setOnClickListener {
            finish()
        }
        proSelect.setOnClickListener {

            val bottomSheet =
                BottomSheetDialog(this@ProportionCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_proportion,
                findViewById(R.id.bottomSheetPro)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.directly).setOnClickListener {
                pro_cal_name.text = "Directly Proportion"
                pro_procces.text="(x * b) / a = y"
                method.text="a/b = x/y"
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.indirectly).setOnClickListener {
                pro_cal_name.text = "Indirectly Proportion"
                pro_procces.text="(a * b) / x = y"
                method.text="a*b = x*y"
                bottomSheet.dismiss()

            }

            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
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
}