package com.example.calculatorapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_timetime_calculator.*
import kotlinx.android.synthetic.main.activity_timetime_calculator.A_string
import kotlinx.android.synthetic.main.activity_timetime_calculator.A_value
import kotlinx.android.synthetic.main.activity_timetime_calculator.add_subButtonVisi
import kotlinx.android.synthetic.main.activity_timetime_calculator.arrayAdd
import kotlinx.android.synthetic.main.activity_timetime_calculator.arraySub
import kotlinx.android.synthetic.main.activity_timetime_calculator.backButton
import kotlinx.android.synthetic.main.activity_timetime_calculator.linearLayout2
import kotlinx.android.synthetic.main.activity_timetime_calculator.procesLayout
import kotlinx.android.synthetic.main.activity_timetime_calculator.selectSideA
import java.util.*

class TimetimeCalculatorActivity : AppCompatActivity() {
    var start_hours_value = 0
    var start_minutes_value = 0

    var end_hours_value = 0
    var end_minutes_value = 0
    var process="difference"

    var hours=0
    var minutes=0

    var value=0

    var add=true
    var sub=false
    var hours_type="24h"
    var select="hours"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetime_calculator)
        backButton.setOnClickListener {
            finish()
        }
        timeSelect.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@TimetimeCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.botom_sheet_timetime,
                findViewById(R.id.bottomSheetTimetime)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.difference).setOnClickListener {
                endTimeLayout.visibility= View.VISIBLE
                process="difference"
                startTimeText.text="Start Time"
                procesLayout.visibility= View.GONE
                add_subButtonVisi.visibility= View.GONE
                time_cal_name.text="Time Difference"
                bottomSheet.show()
            }
            bottomSheetView.findViewById<View>(R.id.add_subDate).setOnClickListener {
                endTimeLayout.visibility= View.GONE
                process="add_subDate"
                startTimeText.text="Time"
                procesLayout.visibility= View.VISIBLE
                add_subButtonVisi.visibility= View.VISIBLE
                time_cal_name.text="Add / Subtract Tİme"
                bottomSheet.show()
            }


            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()
            }


            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        selectSideA.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@TimetimeCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_timeselect,
                findViewById(R.id.bottomSheetTimeSelect)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.hours).setOnClickListener {
                select="hours"
                A_string.text="Hours"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.minutes).setOnClickListener {
                select="minutes"
                A_string.text="Minutes"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        hoursStartSelect.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@TimetimeCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_hoursselect,
                findViewById(R.id.bottomSheetHoursSelect)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.h24).setOnClickListener {
                hoursStartText.text="24H"
                hours_type="24h"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.am).setOnClickListener {
                hoursStartText.text="AM"
                hours_type="am"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.pm).setOnClickListener {
                hoursStartText.text="PM"
                hours_type="pm"
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        linearLayout2.setOnClickListener {
            if(process=="difference"){

                val endDate = Calendar.getInstance()

                if (startDate <= endDate) {
                    val differenceInMillis = endDate.timeInMillis - startDate.timeInMillis
                    val differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24)
                    hours = (differenceInDays / 365).toInt()
                     minutes= ((differenceInDays % 365) / 30).toInt()
                } else {
                    val differenceInMillis = startDate.timeInMillis - endDate.timeInMillis
                    val differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24)
                    hours = (differenceInDays / 365).toInt()
                    months = ((differenceInDays % 365) / 30).toInt()
                    remainingDays = ((differenceInDays % 365) % 30).toInt()
                }

            }else {
                if (A_value.text.toString() == "") {
                    value = 0
                } else {
                    value = A_value.text.toString().toInt()
                }
                if (select == "day") {
                    val startDate = Calendar.getInstance()
                    startDate.set(start_year_value, start_month_value - 1, start_day_value)

                    val calendar = Calendar.getInstance()
                    calendar.time = startDate.time
                    if (add) {
                        calendar.add(Calendar.DAY_OF_MONTH, value)
                    } else {
                        calendar.add(Calendar.DAY_OF_MONTH, -value)
                    }

                    years = calendar.get(Calendar.YEAR)
                    months = calendar.get(Calendar.MONTH)+1
                    remainingDays = calendar.get(Calendar.DAY_OF_MONTH)
                }
                if (select == "month") {
                    val startDate = Calendar.getInstance()
                    startDate.set(start_year_value, start_month_value - 1, start_day_value)

                    val calendar = Calendar.getInstance()
                    calendar.time = startDate.time
                    if (add) {
                        calendar.add(Calendar.MONTH, value)
                    } else {
                        calendar.add(Calendar.MONTH, -value)
                    }

                    years = calendar.get(Calendar.YEAR)
                    months = calendar.get(Calendar.MONTH)+1
                    remainingDays = calendar.get(Calendar.DAY_OF_MONTH)
                }
                if (select == "year") {
                    val startDate = Calendar.getInstance()
                    startDate.set(start_year_value, start_month_value - 1, start_day_value)

                    val calendar = Calendar.getInstance()
                    calendar.time = startDate.time
                    if (add) {
                        calendar.add(Calendar.YEAR, value)
                    } else {
                        calendar.add(Calendar.YEAR, -value)
                    }

                    years = calendar.get(Calendar.YEAR)
                    months = calendar.get(Calendar.MONTH)+1
                    remainingDays = calendar.get(Calendar.DAY_OF_MONTH)


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
}