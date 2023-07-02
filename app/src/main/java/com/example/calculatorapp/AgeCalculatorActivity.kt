package com.example.calculatorapp

import android.app.AlertDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.NumberPicker
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_age_calculator.*
import kotlinx.android.synthetic.main.dialog_age_solutions.view.*
import java.util.*

class AgeCalculatorActivity : AppCompatActivity() {
    var birth_month_value=0
    var birth_day_value=0
    var birth_year_value=0

    var current_month_value=0
    var current_day_value=0
    var current_year_value=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_calculator)
        var c = Calendar.getInstance()
        var cDay = c.get(Calendar.DAY_OF_MONTH)
        var cMonth = c.get(Calendar.MONTH)
        var cYear = c.get(Calendar.YEAR)
        current_date.text="$cDay / ${getMonthName(cMonth)} / $cYear"
        backButton.setOnClickListener {
            finish()
        }
        birth_dateSelect.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@AgeCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_agedate,
                findViewById(R.id.bottomSheetAgeDate)
            ) as ConstraintLayout
            val month = bottomSheetView.findViewById<NumberPicker>(R.id.month)
            val year = bottomSheetView.findViewById<NumberPicker>(R.id.year)
            val date = bottomSheetView.findViewById<NumberPicker>(R.id.date)

            month.maxValue = 12
            month.minValue = 1

            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            year.maxValue = currentYear
            year.minValue = 1900

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
            date.minValue=1

            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout3).setOnClickListener {
                val selectedDate = "${date.value} / ${getMonthName(month.value)} / ${year.value}"
                birth_month_value=month.value
                birth_day_value=date.value
                birth_year_value=year.value
                birth_date.text = selectedDate
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()
        }
        current_dateSelect.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@AgeCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_agedate,
                findViewById(R.id.bottomSheetAgeDate)
            ) as ConstraintLayout
            val month = bottomSheetView.findViewById<NumberPicker>(R.id.month)
            val year = bottomSheetView.findViewById<NumberPicker>(R.id.year)
            val date = bottomSheetView.findViewById<NumberPicker>(R.id.date)

            month.maxValue = 12
            month.minValue = 1


            year.maxValue = 2100
            year.minValue = 1900

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
            date.minValue=1

            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout3).setOnClickListener {
                val selectedDate = "${date.value} / ${getMonthName(month.value)} / ${year.value}"
                current_month_value=month.value
                current_day_value=date.value
                current_year_value=year.value
                current_date.text = selectedDate
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()
        }
        linearLayout2.setOnClickListener {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val birthDateStr = "$birth_day_value/$birth_month_value/$birth_year_value"
            val birthDate = dateFormat.parse(birthDateStr)

            val currentDateStr = "$current_day_value/$current_month_value/$current_year_value"
            val currentDate = dateFormat.parse(currentDateStr)
            val age = currentDate.time - birthDate.time
            val ageInDays = age / (1000 * 60 * 60 * 24)
            val ageInMonths = ageInDays / 30
            val ageInYears = ageInDays / 365
            val view = View.inflate(this, R.layout.dialog_age_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.age_answer.text=ageInYears.toString()
            view.ageMonth_Day.text="$ageInMonths Month / $ageInDays Day"
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