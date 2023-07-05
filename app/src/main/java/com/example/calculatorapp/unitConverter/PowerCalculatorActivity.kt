package com.example.calculatorapp.unitConverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_power_calculator.*
import kotlinx.android.synthetic.main.activity_power_calculator.backButton
import kotlinx.android.synthetic.main.activity_power_calculator.btn_AC

class PowerCalculatorActivity : AppCompatActivity() {
    var powertext = true
    var power2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_power_calculator)
        backButton.setOnClickListener {
            finish()
        }
        powerSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@PowerCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_power,
                findViewById(R.id.bottomSheetPower)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.W).setOnClickListener {
                textPower.text = "W"
                powerNameText.text = "Watt"
                power2Text.text = "00"
                powerText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kW).setOnClickListener {
                textPower.text = "kW"
                powerNameText.text = "Kilowatt"
                power2Text.text = "00"
                powerText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.hp).setOnClickListener {
                textPower.text = "hp"
                powerNameText.text = "Horse Power"
                power2Text.text = "00"
                powerText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mW).setOnClickListener {
                textPower.text = "mW"
                powerNameText.text = "Milliwatt"
                power2Text.text = "00"
                powerText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.MW).setOnClickListener {
                textPower.text = "MW"
                powerNameText.text = "Megawatt"
                power2Text.text = "00"
                powerText.text = "00"
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
        power2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@PowerCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_power,
                findViewById(R.id.bottomSheetPower)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.W).setOnClickListener {
                text2Power.text = "W"
                power2NameText.text = "Watt"
                power2Text.text = "00"
                powerText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kW).setOnClickListener {
                text2Power.text = "kW"
                power2NameText.text = "Kilowatt"
                power2Text.text = "00"
                powerText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.hp).setOnClickListener {
                text2Power.text = "hp"
                power2NameText.text = "Horse Power"
                power2Text.text = "00"
                powerText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mW).setOnClickListener {
                text2Power.text = "mW"
                power2NameText.text = "Milliwatt"
                power2Text.text = "00"
                powerText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.MW).setOnClickListener {
                text2Power.text = "MW"
                power2NameText.text = "Megawatt"
                power2Text.text = "00"
                powerText.text = "00"
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
        powerText.setOnClickListener {
            powertext=true
            power2text=false
            dotPressed=false
            powerText.setTextColor(colorYellow)
            power2Text.setTextColor(colorGrey)
            power2Text.text="00"
            powerText.text="00"
        }
        power2Text.setOnClickListener {
            powertext=false
            power2text=true
            dotPressed2=false
            powerText.setTextColor(colorGrey)
            power2Text.setTextColor(colorYellow)
            powerText.text="00"
            power2Text.text="00"
        }
    }

    fun onDigitClick(view: View){
        if(powertext){
            if(powerText.text.toString()=="00"){
                powerText.text=""
            }
            if (stateEror){
                powerText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    powerText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    powerText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(power2Text.text.toString()=="00"){
                power2Text.text=""
            }
            if (stateEror){
                power2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    power2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    power2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(powertext){
            powerText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            power2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(powertext){
            if (powerText.text.toString().isNotEmpty()) {
                val lastChar = powerText.text.toString()[powerText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                powerText.text = powerText.text.toString().dropLast(1)
            }
            if(powerText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (power2Text.text.toString().isNotEmpty()) {
                val lastChar = power2Text.text.toString()[power2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                power2Text.text = power2Text.text.toString().dropLast(1)
            }
            if(power2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(powertext){
            var inputSize=0.0
            if(powerText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=powerText.text.toString().toDouble()
            }
            var inputUnit=textPower.text.toString()
            var outputUnit=text2Power.text.toString()
            var outputSize=convertPower(inputSize,outputUnit,inputUnit).toString()
            power2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (power2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=power2Text.text.toString().toDouble()
            }
            var inputUnit=text2Power.text.toString()
            var outputUnit=textPower.text.toString()
            var outputArea=convertPower(inputSize,outputUnit,inputUnit).toString()
            powerText.text=outputArea
        }



    }
    fun convertPower(value: Double, fromUnit: String, toUnit: String): Double {
        val angleMap = mapOf(
            "W" to 1.0,
            "kW" to 0.001,
            "hp" to 0.001341,
            "mW" to 1000,
            "MW" to 1.00E-6
        )

        val conversionFactor = angleMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor.toDouble()
        val toConversionFactor = angleMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor.toDouble()
    }
}