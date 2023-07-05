package com.example.calculatorapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.NumberPicker
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_investment_calculate.*
import kotlinx.android.synthetic.main.activity_investment_calculate.A_value
import kotlinx.android.synthetic.main.activity_investment_calculate.backButton
import kotlinx.android.synthetic.main.activity_investment_calculate.linearLayout2
import kotlinx.android.synthetic.main.dialog_investment_solutions.view.*

class InvestmentCalculateActivity : AppCompatActivity() {
    var principal=0.0
    var rate=0.0
    var years=3
    var months=2
    var totalInvestment=0.0
    var interestEarned=0.0
    var selectedDate ="3 Year , 2 Month"
    var oneTime=true
    var Repeated=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investment_calculate)
        backButton.setOnClickListener {
            finish()
        }
        periodLayout.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@InvestmentCalculateActivity,
                R.style.BottomSheetDialogTheme
            )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_investment,
                findViewById(R.id.bottomSheetInvestment)
            ) as ConstraintLayout

            val month = bottomSheetView.findViewById<NumberPicker>(R.id.month)
            val year = bottomSheetView.findViewById<NumberPicker>(R.id.year)

            month.maxValue = 12
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

            val totalMonths = years * 12 + months

            if (oneTime) {
                val monthlyInterestRate = (rate / 100.0) / 12
                totalInvestment = principal

                for (i in 1..totalMonths) {
                    val monthlyInterest = totalInvestment * monthlyInterestRate
                    totalInvestment += monthlyInterest
                }
                interestEarned = totalInvestment - principal
            } else {
                totalInvestment = principal

                for (i in 1..years) {
                    val yearlyInterest = totalInvestment * (rate / 100.0)
                    totalInvestment += yearlyInterest

                    for (j in 1..12) {
                        val monthlyInterest = totalInvestment * (rate / 100.0) / 12
                        totalInvestment += monthlyInterest
                    }
                }

                val remainingMonthsInterest = totalInvestment * (rate / 100.0) / 12 * months
                totalInvestment += remainingMonthsInterest

                interestEarned = totalInvestment - principal
            }
            val view = View.inflate(this, R.layout.dialog_investment_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.answer.text=totalInvestment.toString()
            view.answer_.text=interestEarned.toString()
            view.year_month.text="$years Year , $months Month"
        }
    }

    fun oneTimeOnClick(view: View){
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        one_time.setTextColor(colorYellow)
        repeated.setTextColor(colorGrey)
        oneTime= true
        Repeated = false
    }
    fun repeatedOnClick(view: View){
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        repeated.setTextColor(colorYellow)
        one_time.setTextColor(colorGrey)
        Repeated = true
        oneTime= false
    }
}