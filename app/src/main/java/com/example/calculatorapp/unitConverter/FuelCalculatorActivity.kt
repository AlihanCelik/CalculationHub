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
import kotlinx.android.synthetic.main.activity_fuel_calculator.*
import kotlinx.android.synthetic.main.activity_fuel_calculator.backButton
import kotlinx.android.synthetic.main.activity_fuel_calculator.btn_AC


class FuelCalculatorActivity : AppCompatActivity() {
    var fueltext = true
    var fuel2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel_calculator)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        fuelSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@FuelCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_fuel,
                findViewById(R.id.bottomSheetFuel)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.literkm).setOnClickListener {
                textFuel.text = "l/km"
                fuelNameText.text = "Liter / 100 Km"
                fuel2Text.text = "00"
                fuelText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kmliter).setOnClickListener {
                textFuel.text="km/l"
                fuelNameText.text="Km / Liter"
                fuel2Text.text="00"
                fuelText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mpg).setOnClickListener {
                textFuel.text="mpg US"
                fuelNameText.text="Mile / US Gallon"
                fuel2Text.text="00"
                fuelText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mpg_).setOnClickListener {
                textFuel.text="mpg IMP"
                fuelNameText.text="Mile / IMP Gallon"
                fuel2Text.text="00"
                fuelText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        fuel2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@FuelCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_fuel,
                findViewById(R.id.bottomSheetFuel)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.literkm).setOnClickListener {
                text2Fuel.text = "l/km"
                fuel2NameText.text = "Liter / 100 Km"
                fuel2Text.text = "00"
                fuelText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kmliter).setOnClickListener {
                text2Fuel.text="km/l"
                fuel2NameText.text="Km / Liter"
                fuel2Text.text="00"
                fuelText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mpg).setOnClickListener {
                text2Fuel.text="mpg US"
                fuel2NameText.text="Mile / US Gallon"
                fuel2Text.text="00"
                fuelText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mpg_).setOnClickListener {
                text2Fuel.text="mpg IMP"
                fuel2NameText.text="Mile / IMP Gallon"
                fuel2Text.text="00"
                fuelText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        fuelText.setOnClickListener {
            fueltext=true
            fuel2text=false
            dotPressed=false
            fuelText.setTextColor(colorYellow)
            fuel2Text.setTextColor(colorGrey)
            fuel2Text.text="00"
            fuelText.text="00"
        }
        fuel2Text.setOnClickListener {
            fueltext=false
            fuel2text=true
            dotPressed2=false
            fuelText.setTextColor(colorGrey)
            fuel2Text.setTextColor(colorYellow)
            fuelText.text="00"
            fuel2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(fueltext){
            if(fuelText.text.toString()=="00"){
                fuelText.text=""
            }
            if (stateEror){
                fuelText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    fuelText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    fuelText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(fuel2Text.text.toString()=="00"){
                fuel2Text.text=""
            }
            if (stateEror){
                fuel2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    fuel2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    fuel2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(fueltext){
            fuelText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            fuel2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(fueltext){
            if (fuelText.text.toString().isNotEmpty()) {
                val lastChar = fuelText.text.toString()[fuelText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                fuelText.text = fuelText.text.toString().dropLast(1)
            }
            if(fuelText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (fuel2Text.text.toString().isNotEmpty()) {
                val lastChar = fuel2Text.text.toString()[fuel2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                fuel2Text.text = fuel2Text.text.toString().dropLast(1)
            }
            if(fuel2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(fueltext){
            var inputSize=0.0
            if(fuelText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=fuelText.text.toString().toDouble()
            }
            var inputUnit=textFuel.text.toString()
            var outputUnit=text2Fuel.text.toString()
            var outputSize=convertFuel(inputSize,outputUnit,inputUnit).toString()
            fuel2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (fuel2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=fuel2Text.text.toString().toDouble()
            }
            var inputUnit=text2Fuel.text.toString()
            var outputUnit=textFuel.text.toString()
            var outputArea=convertFuel(inputSize,outputUnit,inputUnit).toString()
            fuelText.text=outputArea
        }



    }
    fun convertFuel(value: Double, fromUnit: String, toUnit: String): Double {
        val fuelMap = mapOf(
            "l/km" to 1.0,
            "km/l" to 1.0,
            "mpg US" to 2.35215,
            "mpg IMP" to 2.82481
        )

        val conversionFactor = fuelMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor
        val toConversionFactor = fuelMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor
    }
}