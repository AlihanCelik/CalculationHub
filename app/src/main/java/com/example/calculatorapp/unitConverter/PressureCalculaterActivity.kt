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
import kotlinx.android.synthetic.main.activity_pressure_calculater.*
import kotlinx.android.synthetic.main.activity_pressure_calculater.backButton
import kotlinx.android.synthetic.main.activity_pressure_calculater.btn_AC

class PressureCalculaterActivity : AppCompatActivity() {
    var pressuretext = true
    var pressure2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pressure_calculater)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        pressureSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@PressureCalculaterActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_pressure,
                findViewById(R.id.bottomSheetPressure)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.atm).setOnClickListener {
                textPressure.text = "atm"
                pressureNameText.text = "Atmosphere"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.bar).setOnClickListener {
                textPressure.text = "bar"
                pressureNameText.text = "Bar"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.pascal).setOnClickListener {
                textPressure.text = "N/m²"
                pressureNameText.text = "Pascal"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.psi).setOnClickListener {
                textPressure.text = "psi"
                pressureNameText.text = "Pound/Inch²"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kilopascal).setOnClickListener {
                textPressure.text = "kN/m²"
                pressureNameText.text = "Kilopascal"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.megapascal).setOnClickListener {
                textPressure.text = "MN/m²"
                pressureNameText.text = "Megapascal"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.millimetre_of_mercury).setOnClickListener {
                textPressure.text = "mmHg"
                pressureNameText.text = "Millimeter of Mercury"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.millimetre_of_water).setOnClickListener {
                textPressure.text = "mmH²O"
                pressureNameText.text = "Millimeter of Water"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.inch_of_water).setOnClickListener {
                textPressure.text = "inH²O"
                pressureNameText.text = "Inch of Water"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.inch_of_mercury).setOnClickListener {
                textPressure.text = "inHg"
                pressureNameText.text = "Inch of Mercury"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kilogram_centimeter).setOnClickListener {
                textPressure.text = "kgf/cm²"
                pressureNameText.text = "Kilogram/Centimeter²"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.psf).setOnClickListener {
                textPressure.text = "psf"
                pressureNameText.text = "Pound/Foot²"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.torr).setOnClickListener {
                textPressure.text = "torr"
                pressureNameText.text = "Torr"
                pressure2Text.text = "00"
                pressureText.text = "00"
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
        pressure2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@PressureCalculaterActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_pressure,
                findViewById(R.id.bottomSheetPressure)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.atm).setOnClickListener {
                text2Pressure.text = "atm"
                pressure2NameText.text = "Atmosphere"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.bar).setOnClickListener {
                text2Pressure.text = "bar"
                pressure2NameText.text = "Bar"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.pascal).setOnClickListener {
                text2Pressure.text = "N/m²"
                pressure2NameText.text = "Pascal"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.psi).setOnClickListener {
                text2Pressure.text = "psi"
                pressure2NameText.text = "Pound/Inch²"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kilopascal).setOnClickListener {
                text2Pressure.text = "kN/m²"
                pressure2NameText.text = "Kilopascal"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.megapascal).setOnClickListener {
                text2Pressure.text = "MN/m²"
                pressure2NameText.text = "Megapascal"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.millimetre_of_mercury).setOnClickListener {
                text2Pressure.text = "mmHg"
                pressure2NameText.text = "Millimeter of Mercury"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.millimetre_of_water).setOnClickListener {
                text2Pressure.text = "mmH²O"
                pressure2NameText.text = "Millimeter of Water"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.inch_of_water).setOnClickListener {
                text2Pressure.text = "inH²O"
                pressure2NameText.text = "Inch of Water"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.inch_of_mercury).setOnClickListener {
                text2Pressure.text = "inHg"
                pressure2NameText.text = "Inch of Mercury"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kilogram_centimeter).setOnClickListener {
                text2Pressure.text = "kgf/cm²"
                pressure2NameText.text = "Kilogram/Centimeter²"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.psf).setOnClickListener {
                text2Pressure.text = "psf"
                pressure2NameText.text = "Pound/Foot²"
                pressure2Text.text = "00"
                pressureText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.torr).setOnClickListener {
                text2Pressure.text = "torr"
                pressure2NameText.text = "Torr"
                pressure2Text.text = "00"
                pressureText.text = "00"
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
        pressureText.setOnClickListener {
            pressuretext=true
            pressure2text=false
            dotPressed=false
            pressureText.setTextColor(colorYellow)
            pressure2Text.setTextColor(colorGrey)
            pressure2Text.text="00"
            pressureText.text="00"
        }
        pressure2Text.setOnClickListener {
            pressuretext=false
            pressure2text=true
            dotPressed2=false
            pressureText.setTextColor(colorGrey)
            pressure2Text.setTextColor(colorYellow)
            pressureText.text="00"
            pressure2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(pressuretext){
            if(pressureText.text.toString()=="00"){
                pressureText.text=""
            }
            if (stateEror){
                pressureText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    pressureText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    pressureText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(pressure2Text.text.toString()=="00"){
                pressure2Text.text=""
            }
            if (stateEror){
                pressure2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    pressure2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    pressure2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(pressuretext){
            pressureText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            pressure2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(pressuretext){
            if (pressureText.text.toString().isNotEmpty()) {
                val lastChar = pressureText.text.toString()[pressureText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                pressureText.text = pressureText.text.toString().dropLast(1)
            }
            if(pressureText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (pressure2Text.text.toString().isNotEmpty()) {
                val lastChar = pressure2Text.text.toString()[pressure2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                pressure2Text.text = pressure2Text.text.toString().dropLast(1)
            }
            if(pressure2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(pressuretext){
            var inputSize=0.0
            if(pressureText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=pressureText.text.toString().toDouble()
            }
            var inputUnit=textPressure.text.toString()
            var outputUnit=text2Pressure.text.toString()
            var outputSize=convertPressure(inputSize,outputUnit,inputUnit).toString()
            pressure2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (pressure2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=pressure2Text.text.toString().toDouble()
            }
            var inputUnit=text2Pressure.text.toString()
            var outputUnit=textPressure.text.toString()
            var outputArea=convertPressure(inputSize,outputUnit,inputUnit).toString()
            pressureText.text=outputArea
        }



    }
    fun convertPressure(value: Double, fromUnit: String, toUnit: String): Double {
        val angleMap = mapOf(
            "atm" to 1.0,
            "bar" to 1.01,
            "N/m²" to 101325,
            "psi" to 14.7,
            "kN/m²" to 101.32,
            "MN/m²" to 0.1,
            "mmH²O" to 10332.27,
            "mmHg" to 760,
            "inH²O" to 406.79,
            "inHg" to 29.92,
            "kgf/cm²" to 1.03,
            "psf" to 2116.22,
            "torr" to 760
        )

        val conversionFactor = angleMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor.toDouble()
        val toConversionFactor = angleMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor.toDouble()
    }
}