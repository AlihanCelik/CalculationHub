package com.example.calculatorapp.unitConverter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_speed_calculator.*
import kotlinx.android.synthetic.main.activity_speed_calculator.backButton
import kotlinx.android.synthetic.main.activity_speed_calculator.btn_AC

class SpeedCalculatorActivity : AppCompatActivity() {
    var speedtext = true
    var speed2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2 = false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow = resources.getColor(R.color.yellow)
        val colorGrey = resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speed_calculator)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        speedSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@SpeedCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_speed,
                findViewById(R.id.bottomSheetSpeed)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.speed_of_light).setOnClickListener {
                textspeed.text = "c"
                speedNameText.text = "Speed Of Light"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mach).setOnClickListener {
                textspeed.text = "Ma"
                speedNameText.text = "Mach"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.meter_per_second).setOnClickListener {
                textspeed.text = "m/s"
                speedNameText.text = "Meter/Second"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.km_per_hour).setOnClickListener {
                textspeed.text = "km/h"
                speedNameText.text = "Kilometer/Hour"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.km_per_second).setOnClickListener {
                textspeed.text = "km/s"
                speedNameText.text = "Kilometer/Second"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.knot).setOnClickListener {
                textspeed.text = "kn"
                speedNameText.text = "Knot"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mile_per_hour).setOnClickListener {
                textspeed.text = "mph"
                speedNameText.text = "Mile/Hour"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.foot_pound_second).setOnClickListener {
                textspeed.text = "fps"
                speedNameText.text = "Foot Pound Second"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.inch_per_second).setOnClickListener {
                textspeed.text = "ips"
                speedNameText.text = "Inch/Second"
                speed2Text.text = "00"
                speedText.text = "00"
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
        speed2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@SpeedCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_speed,
                findViewById(R.id.bottomSheetSpeed)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.speed_of_light).setOnClickListener {
                text2speed.text = "c"
                speed2NameText.text = "Speed Of Light"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mach).setOnClickListener {
                text2speed.text = "Ma"
                speed2NameText.text = "Mach"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.meter_per_second).setOnClickListener {
                text2speed.text = "m/s"
                speed2NameText.text = "Meter/Second"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.km_per_hour).setOnClickListener {
                text2speed.text = "km/h"
                speed2NameText.text = "Kilometer/Hour"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.km_per_second).setOnClickListener {
                text2speed.text = "km/s"
                speed2NameText.text = "Kilometer/Second"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.knot).setOnClickListener {
                text2speed.text = "kn"
                speed2NameText.text = "Knot"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mile_per_hour).setOnClickListener {
                text2speed.text = "mph"
                speed2NameText.text = "Mile/Hour"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.foot_pound_second).setOnClickListener {
                text2speed.text = "fps"
                speed2NameText.text = "Foot Pound Second"
                speed2Text.text = "00"
                speedText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.inch_per_second).setOnClickListener {
                text2speed.text = "ips"
                speed2NameText.text = "Inch/Second"
                speed2Text.text = "00"
                speedText.text = "00"
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

        speedText.setOnClickListener {
            speedtext=true
            speed2text=false
            dotPressed = false
            speedText.setTextColor(colorYellow)
            speed2Text.setTextColor(colorGrey)
            speed2Text.text="00"
            speedText.text="00"
        }
        speed2Text.setOnClickListener {
            speedtext=false
            speed2text=true
            dotPressed2=false
            speedText.setTextColor(colorGrey)
            speed2Text.setTextColor(colorYellow)
            speedText.text="00"
            speed2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(speedtext){
            if(speedText.text.toString()=="00"){
                speedText.text=""
            }
            if (stateEror){
                speedText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    speedText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    speedText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(speed2Text.text.toString()=="00"){
                speed2Text.text=""
            }
            if (stateEror){
                speed2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    speed2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    speed2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }

    fun onAcClick(view: View){
        if(speedtext){
            speedText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            speed2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(speedtext){
            if (speedText.text.toString().isNotEmpty()) {
                val lastChar = speedText.text.toString()[speedText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                speedText.text = speedText.text.toString().dropLast(1)
            }
            if(speedText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (speed2Text.text.toString().isNotEmpty()) {
                val lastChar = speed2Text.text.toString()[speed2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                speed2Text.text = speed2Text.text.toString().dropLast(1)
            }
            if(speed2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(speedtext){
            var inputvalue=0.0
            if(speedText.text.toString()==""){
                inputvalue=0.0
            }else{
                inputvalue=speedText.text.toString().toDouble()
            }
            var inputUnit=textspeed.text.toString()
            var outputUnit=text2speed.text.toString()
            var outputArea=convertSpeed(inputvalue,inputUnit,outputUnit).toString()
            speed2Text.text=outputArea
        }else{
            var inputvalue=0.0
            if (speed2Text.text.toString()==""){
                inputvalue=0.0
            }else{
                inputvalue=speed2Text.text.toString().toDouble()
            }
            var inputUnit=text2speed.text.toString()
            var outputUnit=textspeed.text.toString()
            var outputArea=convertSpeed(inputvalue,inputUnit,outputUnit).toString()
            speedText.text=outputArea
        }
    }

    fun convertSpeed(inputValue: Double, inputUnit: String, outputUnit: String): Double {
        val unitConversionMap = mapOf(
            "m/s" to 1.0,
            "km/h" to 0.277778,
            "mph" to 0.44704,
            "c" to 299792458.0,
            "km/s" to 1000.0,
            "Ma" to 340.3,
            "kn" to 0.514444444,
            "fps" to 0.3048,
            "ips" to 0.0254
        )

        val inputConversionFactor = unitConversionMap[inputUnit]
            ?: throw IllegalArgumentException("Invalid input unit: $inputUnit")

        val outputConversionFactor = unitConversionMap[outputUnit]
            ?: throw IllegalArgumentException("Invalid output unit: $outputUnit")

        val inputValueInMeterPerSecond = inputValue * inputConversionFactor
        val outputValue = inputValueInMeterPerSecond / outputConversionFactor

        return outputValue
    }
}