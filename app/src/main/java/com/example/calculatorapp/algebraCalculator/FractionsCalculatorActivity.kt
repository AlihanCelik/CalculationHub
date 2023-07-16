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
import kotlinx.android.synthetic.main.activity_fractions_calculator.*
import kotlinx.android.synthetic.main.activity_fractions_calculator.A_value
import kotlinx.android.synthetic.main.activity_fractions_calculator.B_value
import kotlinx.android.synthetic.main.activity_fractions_calculator.backButton
import kotlinx.android.synthetic.main.activity_fractions_calculator.linearLayout2
import kotlinx.android.synthetic.main.dialog_fractions_solutions.view.*

class FractionsCalculatorActivity : AppCompatActivity() {
    var a=0.0
    var b=0.0
    var answer=""
    var answer_=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fractions_calculator)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        fraSelect.setOnClickListener {

            val bottomSheet =
                BottomSheetDialog(this@FractionsCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_fractions,
                findViewById(R.id.bottomSheetFra)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.fractions).setOnClickListener {
                fra_cal_name.text = "Fraction Simplifier"
                fra_procces.text="a/b → x/y"
                B_linear.visibility= View.VISIBLE
                method.text="a/b → x/y"
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.decimal).setOnClickListener {
                fra_cal_name.text = "Decimal to Fraction"
                fra_procces.text="a → x/y"
                B_linear.visibility= View.GONE
                method.text="a → x/y"
                bottomSheet.dismiss()

            }


            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        linearLayout2.setOnClickListener {
            if(fra_cal_name.text == "Fraction Simplifier"){
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
                val gcd = findGCD(a.toInt(), b.toInt())
                val x = a / gcd
                val y = b / gcd
                answer=x.toString()
                answer_=y.toString()
            }
            if(fra_cal_name.text == "Decimal to Fraction"){
                if(A_value.text.toString()==""){
                    a=0.0
                }else{
                    a=A_value.text.toString().toDouble()
                }
                var numerator = a
                var denominator = 1.0

                while (numerator % 1 != 0.0) {
                    numerator *= 10
                    denominator *= 10
                }

                val gcd = findGCD(numerator.toInt(), denominator.toInt())
                numerator /= gcd
                denominator /= gcd

                answer=numerator.toString()
                answer_=numerator.toString()


            }



            val view = View.inflate(this, R.layout.dialog_fractions_solutions, null)
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

    fun findGCD(a: Int, b: Int): Int {
        return if (b == 0) a else findGCD(b, a % b)
    }
}