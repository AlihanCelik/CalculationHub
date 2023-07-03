package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.NumberPicker
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_date_calculator.*
import kotlinx.android.synthetic.main.activity_date_calculator.backButton
import java.util.*

class DateCalculatorActivity : AppCompatActivity() {
    var start_month_value = 1
    var start_day_value = 1
    var start_year_value = 2000

    var end_month_value = 0
    var end_day_value = 0
    var end_year_value = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_calculator)
        backButton.setOnClickListener {
            finish()
        }

        dateSelect.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@DateCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_date,
                findViewById(R.id.bottomSheetDate)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.difference).setOnClickListener {
                endDateLayout.visibility=View.VISIBLE
                startDateText.text="Start Date"
                procesLayout.visibility=View.GONE
                add_subButtonVisi.visibility=View.GONE
                date_cal_name.text="Date Difference"
            }
            bottomSheetView.findViewById<View>(R.id.add_subDate).setOnClickListener {
                endDateLayout.visibility=View.GONE
                startDateText.text="Date"
                procesLayout.visibility=View.VISIBLE
                add_subButtonVisi.visibility=View.VISIBLE
                date_cal_name.text="Add / Subtract Date"
            }


            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()
            }


            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        start_dateSelect.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@DateCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_agedate,
                findViewById(R.id.bottomSheetAgeDate)
            ) as ConstraintLayout

            val month = bottomSheetView.findViewById<NumberPicker>(R.id.month)
            val year = bottomSheetView.findViewById<NumberPicker>(R.id.year)
            val date = bottomSheetView.findViewById<NumberPicker>(R.id.date)

            month.maxValue = 12
            month.minValue = 1
            month.value= start_month_value


            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            year.maxValue = 2100
            year.minValue = 1900
            year.value=start_year_value

            year.setOnValueChangedListener { _, _, yearValue ->
                val isLeapYear = yearValue % 4 == 0
                val maxDay = if (isLeapYear) 29 else 28
                if (month.value == 2) {
                    date.maxValue = maxDay
                }
            }

            month.setOnValueChangedListener { _, _, monthValue ->
                val isLeapYear = year.value % 4 == 0
                val maxDay = when (monthValue) {
                    1, 3, 5, 7, 8, 10, 12 -> 31
                    4, 6, 9, 11 -> 30
                    2 -> if (isLeapYear) 29 else 28
                    else -> 31
                }
                date.maxValue = maxDay
            }

            val isLeapYear = year.value % 4 == 0
            val maxDay = when (month.value) {
                1, 3, 5, 7, 8, 10, 12 -> 31
                4, 6, 9, 11 -> 30
                2 -> if (isLeapYear) 29 else 28
                else -> 31
            }
            date.maxValue = maxDay
            date.minValue = 1
            date.value=start_day_value

            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout3).setOnClickListener {
                val selectedDate = "${date.value} / ${getMonthName(month.value)} / ${year.value}"
                start_month_value = month.value
                start_day_value = date.value
                start_year_value = year.value
                start_date.text = selectedDate
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()
        }
    }
    private fun getMonthName(month: Int): String {
        return when (month) {
            1 -> "January"
            2 -> "February"
            3 -> "March"
            4 -> "April"
            5 -> "May"
            6 -> "June"
            7 -> "July"
            8 -> "August"
            9 -> "September"
            10 -> "October"
            11 -> "November"
            12 -> "December"
            else -> ""
        }
    }


}