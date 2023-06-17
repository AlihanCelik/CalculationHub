package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_time_calculator.*
import kotlinx.android.synthetic.main.activity_time_calculator.backButton
import kotlinx.android.synthetic.main.activity_time_calculator.btn_AC

class TimeCalculatorActivity : AppCompatActivity() {
    var timetext = true
    var time2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2 = false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow = resources.getColor(R.color.yellow)
        val colorGrey = resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_calculator)
        backButton.setOnClickListener {
            finish()
        }
        timeSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(
                    this@TimeCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_time,
                findViewById(R.id.bottomSheetTime)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.year).setOnClickListener {
                texttime.text = "a"
                timeNameText.text = "Year"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.week).setOnClickListener {
                texttime.text = "wk"
                timeNameText.text = "Week"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.hour).setOnClickListener {
                texttime.text = "h"
                timeNameText.text = "Hour"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.minute).setOnClickListener {
                texttime.text = "min"
                timeNameText.text = "Minute"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.second).setOnClickListener {
                texttime.text = "s"
                timeNameText.text = "Second"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.microsecond).setOnClickListener {
                texttime.text = "μs"
                timeNameText.text = "Microsecond"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.millisecond).setOnClickListener {
                texttime.text = "μs"
                timeNameText.text = "Millisecond"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.picosecond).setOnClickListener {
                texttime.text = "ps"
                timeNameText.text = "Picosecond"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()
        }
        time2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(
                    this@TimeCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_time,
                findViewById(R.id.bottomSheetTime)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.year).setOnClickListener {
                text2time.text = "a"
                time2NameText.text = "Year"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.week).setOnClickListener {
                text2time.text = "wk"
                time2NameText.text = "Week"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.hour).setOnClickListener {
                text2time.text = "h"
                time2NameText.text = "Hour"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.minute).setOnClickListener {
                text2time.text = "min"
                time2NameText.text = "Minute"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.second).setOnClickListener {
                text2time.text = "s"
                time2NameText.text = "Second"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.microsecond).setOnClickListener {
                text2time.text = "μs"
                time2NameText.text = "Microsecond"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.millisecond).setOnClickListener {
                text2time.text = "ms"
                time2NameText.text = "Millisecond"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.picosecond).setOnClickListener {
                text2time.text = "ps"
                time2NameText.text = "Picosecond"
                time2Text.text = "00"
                timeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()
        }
        timeText.setOnClickListener {
            timetext=true
            time2text=false
            dotPressed = false
            timeText.setTextColor(colorYellow)
            time2Text.setTextColor(colorGrey)
            time2Text.text="00"
            timeText.text="00"
        }
        time2Text.setOnClickListener {
            timetext=false
            time2text=true
            dotPressed2=false
            timeText.setTextColor(colorGrey)
            time2Text.setTextColor(colorYellow)
            timeText.text="00"
            time2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(timetext){
            if(timeText.text.toString()=="00"){
                timeText.text=""
            }
            if (stateEror){
                timeText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    timeText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    timeText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(time2Text.text.toString()=="00"){
                time2Text.text=""
            }
            if (stateEror){
                time2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    time2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    time2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }

    fun onAcClick(view: View){
        if(timetext){
            timeText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            time2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(timetext){
            if (timeText.text.toString().isNotEmpty()) {
                val lastChar = timeText.text.toString()[timeText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                timeText.text = timeText.text.toString().dropLast(1)
            }
            if(timeText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (time2Text.text.toString().isNotEmpty()) {
                val lastChar = time2Text.text.toString()[time2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                time2Text.text = time2Text.text.toString().dropLast(1)
            }
            if(time2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(timetext){
            var inputvalue=0.0
            if(timeText.text.toString()==""){
                inputvalue=0.0
            }else{
                inputvalue=timeText.text.toString().toDouble()
            }
            var inputUnit=texttime.text.toString()
            var outputUnit=text2time.text.toString()
            var outputArea=convertTime(inputvalue,inputUnit,outputUnit).toString()
            time2Text.text=outputArea
        }else{
            var inputvalue=0.0
            if (time2Text.text.toString()==""){
                inputvalue=0.0
            }else{
                inputvalue=time2Text.text.toString().toDouble()
            }
            var inputUnit=text2time.text.toString()
            var outputUnit=texttime.text.toString()
            var outputArea=convertTime(inputvalue,inputUnit,outputUnit).toString()
            timeText.text=outputArea
        }
    }

    fun convertTime(inputValue: Double, inputUnit: String, outputUnit: String): Double {
        val timeConversionMap = mapOf(
            "s" to 1.0,
            "min" to 60.0,
            "h" to 3600.0,
            "d" to 86400.0,
            "wk" to 604800.0,
            "a" to 31536000.0,
            "ms" to 0.001,
            "μs" to 0.000001,
            "ps" to 1e-12
        )

        val inputConversionFactor = timeConversionMap[inputUnit]
            ?: throw IllegalArgumentException("Invalid input unit: $inputUnit")

        val outputConversionFactor = timeConversionMap[outputUnit]
            ?: throw IllegalArgumentException("Invalid output unit: $outputUnit")

        val inputValueInSeconds = inputValue * inputConversionFactor
        val outputValue = inputValueInSeconds / outputConversionFactor

        return outputValue
    }
}