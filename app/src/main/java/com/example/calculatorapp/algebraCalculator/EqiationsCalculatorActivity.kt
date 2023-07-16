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
import kotlinx.android.synthetic.main.activity_eqiations_calculator.*
import kotlinx.android.synthetic.main.activity_eqiations_calculator.backButton
import kotlinx.android.synthetic.main.activity_eqiations_calculator.linearLayout2
import kotlinx.android.synthetic.main.activity_eqiations_calculator.method
import kotlinx.android.synthetic.main.dialog_equations_solutions.view.*
import kotlin.math.sqrt

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
    var answer_3=""
    var select2x2 = true
    var select3x3 = false
    var solutions=""

    override fun onCreate(savedInstanceState: Bundle?) {

        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eqiations_calculator)
        window.navigationBarColor = Color.BLACK
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
                eq_cal_name.text = "Quadratic Equation"
                eq_procces.text="ax² + bx + c = 0"
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
                array2.setTextColor(colorYellow)
                array3.setTextColor(colorGrey)
                visi3.visibility=View.GONE
                d1_linear.visibility=View.GONE
                d2_linear.visibility=View.GONE
                select2x2 = true
                select3x3 = false
                bottomSheet.dismiss()

            }

            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }

        linearLayout2.setOnClickListener {
            if(eq_cal_name.text == "Linear Equation"){
                if(A1_value.text.toString()==""){
                    a1=0.0
                }else{
                    a1=A1_value.text.toString().toDouble()
                }
                if(B1_value.text.toString()==""){
                    b1=0.0
                }else{
                    b1=B1_value.text.toString().toDouble()
                }
                val x = (-b1 / a1).toDouble()
                answer=x.toString()
                solutions="($a1) x + ($b1) = 0\n($a1) x = -($b1)\nx = -($b1 / $a1)\n= $x"


            }
            if(eq_cal_name.text == "Quadratic Equation"){
                if(A1_value.text.toString()==""){
                    a1=0.0
                }else{
                    a1=A1_value.text.toString().toDouble()
                }
                if(B1_value.text.toString()==""){
                    b1=0.0
                }else{
                    b1=B1_value.text.toString().toDouble()
                }
                if(C1_value.text.toString()==""){
                    c1=0.0
                }else{
                    c1=C1_value.text.toString().toDouble()
                }
                val diskriminant = (b1 * b1 - 4 * a1 * c1)
                if (diskriminant < 0) {
                    answer="-"
                    answer_="-"
                    solutions="No real root"
                } else if (diskriminant == 0.0) {
                    val x = -b1/ (2 * a1).toDouble()
                    answer=x.toString()
                    answer_=x.toString()
                    solutions="($a1 )x² +( $b1 )x + ($c1) = 0\nDiscriminant = ($b1)² - (4 * ($a1) * ($c1)\nDiscriminant = $diskriminant\n" +
                            "x1 = (-($b1) + √($diskriminant)) / $a1 * $b1\nx1 = $x\n" +
                            "x2 = (-($b1) - √($diskriminant)) / $a1 * $b1\n" +
                            "x2 = $x\n"
                } else {
                    // İki gerçel kök var
                    val x1 = ((-b1 + sqrt(diskriminant)) / (2 * a1) ).toDouble()
                    val x2 = ((-b1 - sqrt(diskriminant)) / (2 * a1)).toDouble()
                    answer=x1.toString()
                    answer_=x2.toString()
                    solutions="($a1 )x² +( $b1 )x + ($c1) = 0\nDiscriminant = ($b1)² - (4 * ($a1) * ($c1)\nDiscriminant = $diskriminant\n" +
                            "x1 = (-($b1) + √($diskriminant)) / $a1 * $b1\nx1 = $x1\n" +
                            "x2 = (-($b1) - √($diskriminant)) / $a1 * $b1\n" +
                            "x2 = $x2\n"
                }


            }
            if(eq_cal_name.text == "Equation System"){
                if(select2x2){
                    if(A1_value.text.toString()==""){
                        a1=0.0
                    }else{
                        a1=A1_value.text.toString().toDouble()
                    }
                    if(B1_value.text.toString()==""){
                        b1=0.0
                    }else{
                        b1=B1_value.text.toString().toDouble()
                    }
                    if(C1_value.text.toString()==""){
                        c1=0.0
                    }else{
                        c1=C1_value.text.toString().toDouble()
                    }
                    if(A2_value.text.toString()==""){
                        a2=0.0
                    }else{
                        a2=A2_value.text.toString().toDouble()
                    }
                    if(B2_value.text.toString()==""){
                        b2=0.0
                    }else{
                        b2=B2_value.text.toString().toDouble()
                    }
                    if(C2_value.text.toString()==""){
                        c2=0.0
                    }else{
                        c2=C2_value.text.toString().toDouble()
                    }
                    val determinant = a1 * b2 - a2 * b1

                    // Determinant kontrolü
                    if (determinant == 0.0) {
                        answer="Equations have no solution"
                        answer_="Equations have no solution"
                    } else {
                        val x = ((c1 * b2 - c2 * b1) / determinant).toDouble()
                        val y = ((a1 * c2 - a2 * c1) / determinant).toDouble()
                        answer=x.toString()
                        answer_=y.toString()
                    }


                }
                if(select3x3){
                    if(A1_value.text.toString()==""){
                        a1=0.0
                    }else{
                        a1=A1_value.text.toString().toDouble()
                    }
                    if(B1_value.text.toString()==""){
                        b1=0.0
                    }else{
                        b1=B1_value.text.toString().toDouble()
                    }
                    if(C1_value.text.toString()==""){
                        c1=0.0
                    }else{
                        c1=C1_value.text.toString().toDouble()
                    }
                    if(D1_value.text.toString()==""){
                        d1=0.0
                    }else{
                        d1=D1_value.text.toString().toDouble()
                    }
                    if(A2_value.text.toString()==""){
                        a2=0.0
                    }else{
                        a2=A2_value.text.toString().toDouble()
                    }
                    if(B2_value.text.toString()==""){
                        b2=0.0
                    }else{
                        b2=B2_value.text.toString().toDouble()
                    }
                    if(C2_value.text.toString()==""){
                        c2=0.0
                    }else{
                        c2=C2_value.text.toString().toDouble()
                    }
                    if(D2_value.text.toString()==""){
                        d2=0.0
                    }else{
                        d2=D2_value.text.toString().toDouble()
                    }
                    if(A3_value.text.toString()==""){
                        a3=0.0
                    }else{
                        a3=A3_value.text.toString().toDouble()
                    }
                    if(B3_value.text.toString()==""){
                        b3=0.0
                    }else{
                        b3=B3_value.text.toString().toDouble()
                    }
                    if(C3_value.text.toString()==""){
                        c3=0.0
                    }else{
                        c3=C3_value.text.toString().toDouble()
                    }
                    if(D3_value.text.toString()==""){
                        d3=0.0
                    }else{
                        d3=D3_value.text.toString().toDouble()
                    }
                    val determinant = (a1 * (b2 * c3 - b3 * c2) - b1 * (a2 * c3 - a3 * c2) + c1 * (a2 * b3 - a3 * b2)).toDouble()

                    // Determinant kontrolü
                    if (determinant == 0.0) {
                        answer="Equations have no solution"
                        answer_="Equations have no solution"
                        answer_3="Equations have no solution"
                    } else {
                        val x = ((d1 * (b2 * c3 - b3 * c2) - b1 * (d2 * c3 - d3 * c2) + c1 * (d2 * b3 - d3 * b2)) / determinant).toDouble()
                        val y = ((a1 * (d2 * c3 - d3 * c2) - d1 * (a2 * c3 - a3 * c2) + c1 * (a2 * d3 - a3 * d2)) / determinant).toDouble()
                        val z = ((a1 * (b2 * d3 - b3 * d2) - b1 * (a2 * d3 - a3 * d2) + d1 * (a2 * b3 - a3 * b2)) / determinant).toDouble()
                        answer=x.toString()
                        answer_=y.toString()
                        answer_3=z.toString()
                    }

                }



            }

            val view = View.inflate(this, R.layout.dialog_equations_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            if(eq_cal_name.text == "Linear Equation"){
                view.x1_string.text="X"
                view.x2_value.visibility=View.GONE
                view.x3_value.visibility=View.GONE
                view.x1_answer.text=answer
                view.solutions_string.visibility=View.VISIBLE
                view.a_solutions.text=solutions

            }
            if(eq_cal_name.text == "Quadratic Equation"){
                view.x1_string.text="X1"
                view.x2_string.text="X2"
                view.x2_value.visibility=View.VISIBLE
                view.x3_value.visibility=View.GONE
                view.x1_answer.text=answer
                view.x2_answer.text=answer_
                view.solutions_string.visibility=View.VISIBLE
                view.a_solutions.text=solutions
            }
            if(eq_cal_name.text == "Equation System"){
                view.x1_string.text="X"
                view.x2_string.text="Y"
                view.x3_string.text="Z"
                view.x2_value.visibility=View.VISIBLE
                view.x3_value.visibility=View.VISIBLE
                view.x1_answer.text=answer
                view.x2_answer.text=answer_
                if(select2x2){
                    view.x3_value.visibility=View.GONE
                }
                if(select3x3){
                    view.x3_value.visibility=View.VISIBLE
                    view.x3_answer.text=answer_3
                }

                view.solutions_string.visibility=View.GONE
                view.a_solutions.visibility=View.GONE
            }

        }
    }
    fun Array2x2(view:View){

        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        array2.setTextColor(colorYellow)
        array3.setTextColor(colorGrey)
        method.text="a1x + b1y = c1\na2x + b2y = c2"
        visi3.visibility=View.GONE
        d1_linear.visibility=View.GONE
        d2_linear.visibility=View.GONE
        select2x2 = true
        select3x3 = false
    }
    fun Array3x3(view:View){

        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        array3.setTextColor(colorYellow)
        array2.setTextColor(colorGrey)
        method.text="a1x + b1y + c1z = d1\na2x + b2y + c2z = d2\na3x + b3y + c3z = d3"
        visi3.visibility=View.VISIBLE
        d1_linear.visibility=View.VISIBLE
        d2_linear.visibility=View.VISIBLE
        select2x2 = false
        select3x3 = true

    }

}