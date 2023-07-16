package com.example.calculatorapp.finance

import android.app.AlertDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.NumberPicker
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_credit_calculator.A_value
import kotlinx.android.synthetic.main.activity_credit_calculator.B_value
import kotlinx.android.synthetic.main.activity_credit_calculator.backButton
import kotlinx.android.synthetic.main.activity_credit_calculator.linearLayout2
import kotlinx.android.synthetic.main.activity_credit_calculator.periodLayout
import kotlinx.android.synthetic.main.activity_credit_calculator.periodText
import kotlinx.android.synthetic.main.dialog_credit_solutions.view.*

class creditCalculatorActivity : AppCompatActivity() {
    var principal=0.0
    var rate=0.0
    var years=3
    var months=2
    var monthlyPayment=0.0
    var selectedDate ="3 Year , 2 Month"
    var oneTime=true
    var Repeated=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_calculator)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        periodLayout.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@creditCalculatorActivity,
                R.style.BottomSheetDialogTheme
            )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_investment,
                findViewById(R.id.bottomSheetInvestment)
            ) as ConstraintLayout

            val month = bottomSheetView.findViewById<NumberPicker>(R.id.month)
            val year = bottomSheetView.findViewById<NumberPicker>(R.id.year)

            month.maxValue = 11
            month.minValue = 0
            month.value= months


            year.maxValue = 30
            year.minValue = 0
            year.value= years


            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout3).setOnClickListener {
                selectedDate = "${year.value} Year , ${month.value} Month"
                periodText.text=selectedDate
                months = month.value
                years = year.value
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()
        }
        linearLayout2.setOnClickListener {
            if(A_value.text.toString()==""){
                principal=0.0
            }else{
                principal=A_value.text.toString().toDouble()
            }

            if(B_value.text.toString()==""){
                rate=0.0
            }else{
                rate=B_value.text.toString().toDouble()
            }
            monthlyPayment=calculateMonthlyPayment(principal,rate,years,months)
            val view = View.inflate(this, R.layout.dialog_credit_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.answer.text=monthlyPayment.toString()
            view.year_monthText.text="$years Year , $months Month"


            }

        }
    fun calculateMonthlyPayment(principal: Double, interestRate: Double, years: Int, months: Int): Double {
        val totalLoanPeriodInMonths = years * 12 + months
        val monthlyInterestRate = interestRate / 12 / 100
        val monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalLoanPeriodInMonths.toDouble()))
        return monthlyPayment
    }

}