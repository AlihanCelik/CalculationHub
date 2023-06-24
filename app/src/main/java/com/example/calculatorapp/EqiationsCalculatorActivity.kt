package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_eqiations_calculator.*
import kotlinx.android.synthetic.main.activity_eqiations_calculator.backButton

class EqiationsCalculatorActivity : AppCompatActivity() {
    var a1=0.0
    var b1=0.0
    var c1=0.0
    var d1=0.0

    var a2=0.0
    var b2=0.0
    var c2=0.0
    var d2=0.0

    var a3=0.0
    var b3=0.0
    var c3=0.0
    var d3=0.0

    var answer=""
    var answer_=""
    var select2x2 = true
    var select3x3 = false
    override fun onCreate(savedInstanceState: Bundle?) {

        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eqiations_calculator)
        backButton.setOnClickListener {
            finish()
        }
        eqSelect.setOnClickListener {

            val bottomSheet =
                BottomSheetDialog(this@EqiationsCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_equations,
                findViewById(R.id.bottomSheetEq)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.linear).setOnClickListener {
                eq_cal_name.text = "Linear Equation"
                eq_procces.text="ax = b"
                A1_string.text="A"
                B1_string.text="B"
                c1_lienar.visibility=View.GONE
                d1_linear.visibility=View.GONE
                method.text="ax + b = 0"
                equation_system_vis.visibility=View.GONE
                visi2.visibility=View.GONE
                visi3.visibility=View.GONE
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.qua).setOnClickListener {
                eq_cal_name.text = "Linear Equation"
                eq_procces.text="ax = b"
                A1_string.text="A"
                B1_string.text="B"
                C1_string.text="C"
                c1_lienar.visibility=View.VISIBLE
                d1_linear.visibility=View.GONE
                d2_linear.visibility=View.GONE
                method.text="ax² + bx + c = 0"
                equation_system_vis.visibility=View.GONE
                visi2.visibility=View.GONE
                visi3.visibility=View.GONE
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.equation).setOnClickListener {
                eq_cal_name.text = "Equation System"
                eq_procces.text="2x2, 3x3"
                A1_string.text="A1"
                B1_string.text="B1"
                C1_string.text="C1"
                c1_lienar.visibility=View.VISIBLE
                d1_linear.visibility=View.GONE
                d2_linear.visibility=View.GONE
                method.text="a1x + b1y = c1\na2x + b2y = c2"
                equation_system_vis.visibility=View.VISIBLE
                visi2.visibility=View.VISIBLE
                visi3.visibility=View.GONE
                bottomSheet.dismiss()

            }

            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        if(eq_cal_name.text == "Linear Equation"){
            array2.setOnClickListener {
                array2.setTextColor(colorYellow)
                array3.setTextColor(colorGrey)
                method.text="a1x + b1y = c1\na2x + b2y = c2"
                visi3.visibility=View.GONE
                d1_linear.visibility=View.GONE
                d2_linear.visibility=View.GONE
                select2x2 = true
                select3x3 = false

            }
            array3.setOnClickListener {
                array3.setTextColor(colorYellow)
                array2.setTextColor(colorGrey)
                method.text="a1x + b1y + c1z = d1\na2x + b2y + c2z = d2\na2x + b2y + c2z = d2"
                visi3.visibility=View.VISIBLE
                d1_linear.visibility=View.VISIBLE
                d2_linear.visibility=View.VISIBLE
                select2x2 = false
                select3x3 = true

            }
        }
    }
}