package com.example.calculatorapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
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
import kotlinx.android.synthetic.main.dialog_time_solutions.view.*
import java.util.*

class TimetimeCalculatorActivity : AppCompatActivity() {
    var start_hours_value = 0
    var start_minutes_value = 0

    var end_hours_value = 0
    var end_minutes_value = 0
    var process="difference"

    var hours=""
    var minutes=""

    var value=0

    var add=true
    var sub=false
    var hours_type="24h"
    var hours_type2="24H"
    var select="hours"

    var answer=true
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
                endTimeText.visibility=View.VISIBLE
                startTimeText.text="Start Time"
                procesLayout.visibility= View.GONE
                add_subButtonVisi.visibility= View.GONE
                time_cal_name.text="Time Difference"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.add_subTime).setOnClickListener {
                endTimeLayout.visibility= View.GONE
                endTimeText.visibility=View.GONE
                process="add_subDate"
                startTimeText.text="Time"
                procesLayout.visibility= View.VISIBLE
                add_subButtonVisi.visibility= View.VISIBLE
                time_cal_name.text="Add / Subtract Tİme"
                bottomSheet.dismiss()
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
        hoursEndSelect.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this@TimetimeCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_hoursselect,
                findViewById(R.id.bottomSheetHoursSelect)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.h24).setOnClickListener {
                hoursEndText.text="24H"
                hours_type2="24h"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.am).setOnClickListener {
                hoursEndText.text="AM"
                hours_type2="am"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.pm).setOnClickListener {
                hoursEndText.text="PM"
                hours_type2="pm"
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }

        linearLayout2.setOnClickListener {
            answer=true
            if(A1_value.text.toString()==""){
                start_hours_value=0
            }else{
                start_hours_value=A1_value.text.toString().toInt()
            }
            if(B1_value.text.toString()==""){
                start_minutes_value=0
            }else{
                start_minutes_value=B1_value.text.toString().toInt()
            }
            if(A2_value.text.toString()==""){
                end_hours_value=0
            }else{
                end_hours_value=A2_value.text.toString().toInt()
            }
            if(B2_value.text.toString()==""){
                end_minutes_value=0
            }else{
                end_minutes_value=B2_value.text.toString().toInt()
            }
            if(A_value.text.toString()==""){
                value=0
            }else{
                value=A_value.text.toString().toInt()
            }
            if(hours_type=="24h"){
                if (start_hours_value < 0 || start_hours_value > 23 ||start_minutes_value < 0 || start_minutes_value > 59) {
                    answer=false
                }
            }else if(hours_type=="am" || hours_type=="pm"){
                if (start_hours_value < 1 || start_hours_value > 12 ||start_minutes_value < 0 || start_minutes_value > 59) {
                    answer=false
                }
            }
            if(hours_type2=="24h"){
                if (end_hours_value < 0 || end_hours_value > 23 ||end_minutes_value < 0 || end_minutes_value > 59) {
                    answer=false
                }
            }else if(hours_type2=="am" || hours_type2=="pm"){
                if (end_hours_value < 1 || end_hours_value > 12 ||end_minutes_value < 0 || end_minutes_value > 59) {
                    answer=false
                }
            }

            if(select == "hours"){
                if (value < 0 || value > 23) {
                    answer=false
                }
            }else{
                if (value < 0 || value > 59) {
                    answer=false
                }
            }

            if(answer){
                var startHour = start_hours_value
                var startMinute = start_minutes_value
                if(hours_type=="24h"){
                    startHour = start_hours_value
                    startMinute = start_minutes_value
                }else if(hours_type=="am"){
                    startHour = convert12to24(start_hours_value,start_minutes_value,"AM")!!.first
                    startMinute = convert12to24(start_hours_value,start_minutes_value,"AM")!!.second
                }else{
                    startHour = convert12to24(start_hours_value,start_minutes_value,"PM")!!.first
                    startMinute = convert12to24(start_hours_value,start_minutes_value,"PM")!!.second
                }


                var endHour = end_hours_value
                var endMinute = end_minutes_value
                if(hours_type2=="24h"){
                    endHour = end_hours_value
                    endMinute = end_minutes_value
                }else if(hours_type2=="am"){
                    endHour = convert12to24(end_hours_value,end_minutes_value,"AM")!!.first
                    endMinute = convert12to24(end_hours_value,end_minutes_value,"AM")!!.second
                }else{
                    endHour = convert12to24(end_hours_value,end_minutes_value,"PM")!!.first
                    endMinute = convert12to24(end_hours_value,end_minutes_value,"PM")!!.second
                }
                if(process=="difference"){


                    val startTime = Calendar.getInstance()
                    startTime.set(Calendar.HOUR_OF_DAY, startHour)
                    startTime.set(Calendar.MINUTE, startMinute)

                    val endTime = Calendar.getInstance()
                    endTime.set(Calendar.HOUR_OF_DAY, endHour)
                    endTime.set(Calendar.MINUTE, endMinute)

                    if (startTime <= endTime) {
                        val differenceInMillis = endTime.timeInMillis - startTime.timeInMillis
                        val differenceInMinutes = differenceInMillis / (1000 * 60)
                        hours = (differenceInMinutes / 60).toInt().toString()
                        minutes = (differenceInMinutes % 60).toInt().toString()
                    } else {
                        val differenceInMillis = startTime.timeInMillis - endTime.timeInMillis
                        val differenceInMinutes = differenceInMillis / (1000 * 60)
                        hours = ((24 * 60 - differenceInMinutes) / 60).toInt().toString()
                        minutes = ((24 * 60 - differenceInMinutes) % 60).toInt().toString()
                    }
                }
                else {
                    if (A_value.text.toString() == "") {
                        value = 0
                    } else {
                        value = A_value.text.toString().toInt()
                    }

                    if (select == "hours") {
                        if (add) {
                            val calendar = Calendar.getInstance()
                            calendar.set(Calendar.HOUR_OF_DAY, startHour)
                            calendar.set(Calendar.MINUTE, startMinute)
                            calendar.add(Calendar.HOUR_OF_DAY, value)

                            hours = calendar.get(Calendar.HOUR_OF_DAY).toString()
                            minutes = calendar.get(Calendar.MINUTE).toString()
                        } else {
                            val calendar = Calendar.getInstance()
                            calendar.set(Calendar.HOUR_OF_DAY, startHour)
                            calendar.set(Calendar.MINUTE, startMinute)
                            calendar.add(Calendar.HOUR_OF_DAY, -value)

                            hours = calendar.get(Calendar.HOUR_OF_DAY).toString()
                            minutes = calendar.get(Calendar.MINUTE).toString()
                        }
                    }

                    if (select == "minutes") {
                        if (add) {
                            val calendar = Calendar.getInstance()
                            calendar.set(Calendar.HOUR_OF_DAY, startHour)
                            calendar.set(Calendar.MINUTE, startMinute)
                            calendar.add(Calendar.MINUTE, value)

                            hours = calendar.get(Calendar.HOUR_OF_DAY).toString()
                            minutes = calendar.get(Calendar.MINUTE).toString()
                        } else {
                            val calendar = Calendar.getInstance()
                            calendar.set(Calendar.HOUR_OF_DAY, startHour)
                            calendar.set(Calendar.MINUTE, startMinute)
                            calendar.add(Calendar.MINUTE, -value)

                            hours = calendar.get(Calendar.HOUR_OF_DAY).toString()
                            minutes = calendar.get(Calendar.MINUTE).toString()
                        }
                    }

                }
            }else{
                hours="-"
                minutes="-"
            }


            val view = View.inflate(this, R.layout.dialog_time_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.hours_answer.text=hours.toString()
            view.minutes_answer.text=minutes.toString()

        }

    }
    fun convert12to24(hour: Int, minute: Int, amPm: String): Pair<Int, Int>? {
        if (hour < 1 || hour > 12 || minute < 0 || minute > 59) {
            return null  // Geçersiz saat değeri
        }

        val isAM = amPm.equals("AM", ignoreCase = true)
        val isPM = amPm.equals("PM", ignoreCase = true)

        if (!isAM && !isPM) {
            return null  // Geçersiz AM/PM değeri
        }

        var hour24 = hour
        if (isAM && hour == 12) {
            hour24 = 0
        } else if (isPM && hour != 12) {
            hour24 += 12
        }

        return Pair(hour24, minute)
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