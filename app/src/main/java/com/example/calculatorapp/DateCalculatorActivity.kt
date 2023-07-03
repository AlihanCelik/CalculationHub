package com.example.calculatorapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.NumberPicker
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_date_calculator.*
import kotlinx.android.synthetic.main.activity_date_calculator.backButton
import kotlinx.android.synthetic.main.activity_date_calculator.linearLayout2
import kotlinx.android.synthetic.main.dialog_date_solutions.view.*
import java.util.*

class DateCalculatorActivity : AppCompatActivity() {
    var start_month_value = 1
    var start_day_value = 1
    var start_year_value = 2000

    var end_month_value = 1
    var end_day_value = 1
    var end_year_value = 2000
    var process="difference"

    var years=0
    var months=0
    var remainingDays=0

    var value=0

    var add=true
    var sub=false

    var select="day"

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
                process="difference"
                startDateText.text="Start Date"
                procesLayout.visibility=View.GONE
                add_subButtonVisi.visibility=View.GONE
                date_cal_name.text="Date Difference"
            }
            bottomSheetView.findViewById<View>(R.id.add_subDate).setOnClickListener {
                endDateLayout.visibility=View.GONE
                process="add_subDate"
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
        end_dateSelect.setOnClickListener {
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
            month.value=end_month_value

            year.maxValue = 2100
            year.minValue = 1900
            year.value=end_year_value

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
            date.value=end_day_value

            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout3).setOnClickListener {
                val selectedDate = "${date.value} / ${getMonthName(month.value)} / ${year.value}"
                end_month_value = month.value
                end_day_value = date.value
                end_year_value = year.value
                end_date.text = selectedDate
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()
        }
        selectSideA.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@DateCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_dateselect,
                findViewById(R.id.bottomSheetDateSelect)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.day).setOnClickListener {
                select="day"
                A_string.text="Day"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.month).setOnClickListener {
                select="month"
                A_string.text="Month"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.year).setOnClickListener {
                select="year"
                A_string.text="Year"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        linearLayout2.setOnClickListener {
            if(process=="difference"){
                val startDate = Calendar.getInstance()
                startDate.set(start_year_value, start_month_value - 1, start_day_value)

                val endDate = Calendar.getInstance()
                endDate.set(end_year_value, end_month_value - 1, end_day_value)

                if (startDate <= endDate) {
                    val differenceInMillis = endDate.timeInMillis - startDate.timeInMillis
                    val differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24)
                    years = (differenceInDays / 365).toInt()
                    months = (differenceInDays / 30).toInt()
                    remainingDays = (differenceInDays % 365 % 30).toInt()


                } else {
                    val differenceInMillis =  startDate.timeInMillis - endDate.timeInMillis
                    val differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24)
                    years = (differenceInDays / 365).toInt()
                    months = (differenceInDays / 30).toInt()
                    remainingDays = (differenceInDays % 365 % 30).toInt()

                }

            }else{
                if(A_value.text.toString()==""){
                    value=0
                }else{
                    value=A_value.text.toString().toInt()
                }
                if(add){
                    if(select=="day"){

                        val startDate = Calendar.getInstance()
                        startDate.set(start_year_value, start_month_value - 1, start_day_value)

                        val daySelect = Calendar.getInstance()
                        daySelect.set(0, 0, value)

                        val differenceInMillis =  startDate.timeInMillis + daySelect.timeInMillis
                        val differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24)
                        years = (differenceInDays / 365).toInt()
                        months = (differenceInDays / 30).toInt()
                        remainingDays = (differenceInDays % 365 % 30).toInt()
                    }
                    if(select=="month"){

                        val startDate = Calendar.getInstance()
                        startDate.set(start_year_value, start_month_value - 1, start_day_value)

                        val monthSelect = Calendar.getInstance()
                        monthSelect.set(0, value-1, 0)

                        val differenceInMillis =  startDate.timeInMillis + monthSelect.timeInMillis
                        val differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24)
                        years = (differenceInDays / 365).toInt()
                        months = (differenceInDays / 30).toInt()
                        remainingDays = (differenceInDays % 365 % 30).toInt()
                    }
                    if(select=="year"){

                        val startDate = Calendar.getInstance()
                        startDate.set(start_year_value, start_month_value - 1, start_day_value)

                        val yearSelect = Calendar.getInstance()
                        yearSelect.set(value, 0, 0)

                        val differenceInMillis =  startDate.timeInMillis + yearSelect.timeInMillis
                        val differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24)
                        years = (differenceInDays / 365).toInt()
                        months = (differenceInDays / 30).toInt()
                        remainingDays = (differenceInDays % 365 % 30).toInt()
                    }
                }else{
                    if(select=="day"){

                        val startDate = Calendar.getInstance()
                        startDate.set(start_year_value, start_month_value - 1, start_day_value)

                        val daySelect = Calendar.getInstance()
                        daySelect.set(0, 0, value)

                        val differenceInMillis =  startDate.timeInMillis - daySelect.timeInMillis
                        val differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24)
                        years = (differenceInDays / 365).toInt()
                        months = (differenceInDays / 30).toInt()
                        remainingDays = (differenceInDays % 365 % 30).toInt()
                    }
                    if(select=="month"){

                        val startDate = Calendar.getInstance()
                        startDate.set(start_year_value, start_month_value - 1, start_day_value)

                        val monthSelect = Calendar.getInstance()
                        monthSelect.set(0, value-1, 0)

                        val differenceInMillis =  startDate.timeInMillis - monthSelect.timeInMillis
                        val differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24)
                        years = (differenceInDays / 365).toInt()
                        months = (differenceInDays / 30).toInt()
                        remainingDays = (differenceInDays % 365 % 30).toInt()
                    }
                    if(select=="year"){

                        val startDate = Calendar.getInstance()
                        startDate.set(start_year_value, start_month_value - 1, start_day_value)

                        val yearSelect = Calendar.getInstance()
                        yearSelect.set(value, 0, 0)

                        val differenceInMillis =  startDate.timeInMillis - yearSelect.timeInMillis
                        val differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24)
                        years = (differenceInDays / 365).toInt()
                        months = (differenceInDays / 30).toInt()
                        remainingDays = (differenceInDays % 365 % 30).toInt()
                    }
                }


            }
            val view = View.inflate(this, R.layout.dialog_date_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.year_answer.text=years.toString()
            view.month_answer.text=months.toString()
            view.day_answer.text=remainingDays.toString()
        }


    }
    fun AddOnCLick(view: View){
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        arrayAdd.setTextColor(colorYellow)
        arraySub.setTextColor(colorGrey)
        add= true
        sub = false
    }
    fun SubstractOnClick(view: View){
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        arraySub.setTextColor(colorYellow)
        arrayAdd.setTextColor(colorGrey)
        sub = true
        add = false
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