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
import kotlinx.android.synthetic.main.activity_temparature_calculator.*
import kotlinx.android.synthetic.main.activity_temparature_calculator.backButton
import kotlinx.android.synthetic.main.activity_temparature_calculator.btn_AC

class TemparatureCalculatorActivity : AppCompatActivity() {
    var temptext = true
    var temp2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2 = false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow = resources.getColor(R.color.yellow)
        val colorGrey = resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temparature_calculator)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        tempSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(
                    this@TemparatureCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_temperature,
                findViewById(R.id.bottomSheetTemp)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.celsius).setOnClickListener {
                texttemp.text = "°C"
                tempNameText.text = "Celsius"
                temp2Text.text = "00"
                tempText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.fahrenheit).setOnClickListener {
                texttemp.text = "°F"
                tempNameText.text = "Fahrenheit"
                temp2Text.text = "00"
                tempText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kelvin).setOnClickListener {
                texttemp.text = "K"
                tempNameText.text = "Kelvin"
                temp2Text.text = "00"
                tempText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.rankin).setOnClickListener {
                texttemp.text = "°R"
                tempNameText.text = "Rankin"
                temp2Text.text = "00"
                tempText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.réaumur).setOnClickListener {
                texttemp.text = "°Re"
                tempNameText.text = "Réaumur"
                temp2Text.text = "00"
                tempText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        temp2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(
                    this@TemparatureCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_temperature,
                findViewById(R.id.bottomSheetTemp)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.celsius).setOnClickListener {
                text2temp.text = "°C"
                temp2NameText.text = "Celsius"
                temp2Text.text = "00"
                tempText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.fahrenheit).setOnClickListener {
                text2temp.text = "°F"
                temp2NameText.text = "Fahrenheit"
                temp2Text.text = "00"
                tempText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kelvin).setOnClickListener {
                text2temp.text = "K"
                temp2NameText.text = "Kelvin"
                temp2Text.text = "00"
                tempText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.rankin).setOnClickListener {
                text2temp.text = "°R"
                temp2NameText.text = "Rankin"
                temp2Text.text = "00"
                tempText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.réaumur).setOnClickListener {
                text2temp.text = "°Re"
                temp2NameText.text = "Réaumur"
                temp2Text.text = "00"
                tempText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        tempText.setOnClickListener {
            temptext=true
            temp2text=false
            dotPressed = false
            tempText.setTextColor(colorYellow)
            temp2Text.setTextColor(colorGrey)
            temp2Text.text="00"
            tempText.text="00"
        }
        temp2Text.setOnClickListener {
            temptext=false
            temp2text=true
            dotPressed2=false
            tempText.setTextColor(colorGrey)
            temp2Text.setTextColor(colorYellow)
            tempText.text="00"
            temp2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(temptext){
            if(tempText.text.toString()=="00"){
                tempText.text=""
            }
            if (stateEror){
                tempText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    tempText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    tempText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(temp2Text.text.toString()=="00"){
                temp2Text.text=""
            }
            if (stateEror){
                temp2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    temp2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    temp2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }

    fun onAcClick(view: View){
        if(temptext){
            tempText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            temp2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    var pone1="po"
    var pone2="po"
    fun onDigitPoNe(view:View){
        if (temptext) {
            if (tempText.text.toString().isNotEmpty()) {
                if (pone1 == "po") {
                    val currentValue = tempText.text.toString()
                    tempText.text = "-$currentValue"
                    pone1 = "ne"
                } else {
                    val currentValue = tempText.text.toString().removePrefix("-")
                    tempText.text = currentValue
                    pone1 = "po"
                }
            }

        } else {
            if (temp2Text.text.toString().isNotEmpty()) {
                if (pone2 == "po") {
                    val currentValue = temp2Text.text.toString()
                    temp2Text.text = "-$currentValue"
                    pone2 = "ne"
                } else {
                    val currentValue = temp2Text.text.toString().removePrefix("-")
                    temp2Text.text = currentValue
                    pone2 = "po"
                }
            }

        }
    }
    fun onClearClick(view: View){
        if(temptext){
            if (tempText.text.toString().isNotEmpty()) {
                val lastChar = tempText.text.toString()[tempText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                tempText.text = tempText.text.toString().dropLast(1)
            }
            if(tempText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (temp2Text.text.toString().isNotEmpty()) {
                val lastChar = temp2Text.text.toString()[temp2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                temp2Text.text = temp2Text.text.toString().dropLast(1)
            }
            if(temp2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(temptext){
            var inputvalue=0.0
            if(tempText.text.toString()==""){
                inputvalue=0.0
            }else{
                inputvalue=tempText.text.toString().toDouble()
            }
            var inputUnit=texttemp.text.toString()
            var outputUnit=text2temp.text.toString()
            var outputArea=convertTemperature(inputvalue,inputUnit,outputUnit).toString()
            temp2Text.text=outputArea
        }else{
            var inputvalue=0.0
            if (temp2Text.text.toString()==""){
                inputvalue=0.0
            }else{
                inputvalue=temp2Text.text.toString().toDouble()
            }
            var inputUnit=text2temp.text.toString()
            var outputUnit=texttemp.text.toString()
            var outputArea=convertTemperature(inputvalue,inputUnit,outputUnit).toString()
            tempText.text=outputArea
        }
    }
    fun convertTemperature(inputValue: Double, inputUnit: String, outputUnit: String): Double {
        if (inputUnit == outputUnit) {
            return inputValue
        }
        when {
            inputUnit == "°C" && outputUnit == "°F" -> return (inputValue * 9/5) + 32
            inputUnit == "°C" && outputUnit == "K" -> return inputValue + 273.15
            inputUnit == "°C" && outputUnit == "°R" -> return (inputValue + 273.15) * 9/5
            inputUnit == "°C" && outputUnit == "°Re" -> return inputValue * 0.8
            inputUnit == "°F" && outputUnit == "°C" -> return (inputValue - 32) * 5/9
            inputUnit == "°F" && outputUnit == "K" -> return (inputValue + 459.67) * 5/9
            inputUnit == "°F" && outputUnit == "°R" -> return inputValue + 459.67
            inputUnit == "°F" && outputUnit == "°Re" -> return (inputValue - 32) * 4/9
            inputUnit == "K" && outputUnit == "°C" -> return inputValue - 273.15
            inputUnit == "K" && outputUnit == "°F" -> return (inputValue * 9/5) - 459.67
            inputUnit == "K" && outputUnit == "°R" -> return inputValue * 9/5
            inputUnit == "K" && outputUnit == "°Re" -> return (inputValue - 273.15) * 0.8
            inputUnit == "°R" && outputUnit == "°C" -> return (inputValue - 491.67) * 5/9
            inputUnit == "°R" && outputUnit == "°F" -> return inputValue - 459.67
            inputUnit == "°R" && outputUnit == "K" -> return inputValue * 5/9
            inputUnit == "°R" && outputUnit == "°Re" -> return (inputValue - 491.67) * 4/9
            inputUnit == "°Re" && outputUnit == "°C" -> return inputValue * 1.25
            inputUnit == "°Re" && outputUnit == "°F" -> return (inputValue * 9/4) + 32
            inputUnit == "°Re" && outputUnit == "K" -> return (inputValue * 5/4) + 273.15
            inputUnit == "°Re" && outputUnit == "°R" -> return (inputValue * 9/4) + 491.67
            else -> throw IllegalArgumentException("Invalid input or output unit.")
        }
    }
}