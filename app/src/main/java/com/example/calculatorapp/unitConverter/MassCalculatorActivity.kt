package com.example.calculatorapp.unitConverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_mass_calculator.*
import kotlinx.android.synthetic.main.activity_mass_calculator.backButton
import kotlinx.android.synthetic.main.activity_mass_calculator.btn_AC

class MassCalculatorActivity : AppCompatActivity() {
    var masstext = true
    var mass2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mass_calculator)
        backButton.setOnClickListener {
            finish()
        }
        massSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@MassCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_mass,
                findViewById(R.id.bottomSheetMass)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.ton).setOnClickListener {
                textmass.text="t"
                massNameText.text="Ton"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kilogram).setOnClickListener {
                textmass.text="kg"
                massNameText.text="Kilogram"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gram).setOnClickListener {
                textmass.text="g"
                massNameText.text="Gram"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.microgram).setOnClickListener {
                textmass.text="µg"
                massNameText.text="Microgram"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quintal).setOnClickListener {
                textmass.text="q"
                massNameText.text="Quintal"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.pound).setOnClickListener {
                textmass.text="lb"
                massNameText.text="Pound"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ounce).setOnClickListener {
                textmass.text="oz"
                massNameText.text="Ounce"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.carat).setOnClickListener {
                textmass.text="ct"
                massNameText.text="Carat"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.grain).setOnClickListener {
                textmass.text="gr"
                massNameText.text="Grain"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.cwt).setOnClickListener {
                textmass.text="cwt"
                massNameText.text="Hundredweight or centum weight"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.stone).setOnClickListener {
                textmass.text="st"
                massNameText.text="Stone"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dram).setOnClickListener {
                textmass.text="dr"
                massNameText.text="Dram"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
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
        mass2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@MassCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_mass,
                findViewById(R.id.bottomSheetMass)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.ton).setOnClickListener {
                text2mass.text="t"
                mass2NameText.text="Ton"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kilogram).setOnClickListener {
                text2mass.text="kg"
                mass2NameText.text="Kilogram"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gram).setOnClickListener {
                text2mass.text="g"
                mass2NameText.text="Gram"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.microgram).setOnClickListener {
                text2mass.text="µg"
                mass2NameText.text="Microgram"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quintal).setOnClickListener {
                text2mass.text="q"
                mass2NameText.text="Quintal"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.pound).setOnClickListener {
                text2mass.text="lb"
                mass2NameText.text="Pound"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ounce).setOnClickListener {
                text2mass.text="oz"
                mass2NameText.text="Ounce"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.carat).setOnClickListener {
                text2mass.text="ct"
                mass2NameText.text="Carat"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.grain).setOnClickListener {
                text2mass.text="gr"
                mass2NameText.text="Grain"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.cwt).setOnClickListener {
                text2mass.text="cwt"
                mass2NameText.text="Hundredweight or centum weight"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.stone).setOnClickListener {
                text2mass.text="st"
                mass2NameText.text="Stone"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dram).setOnClickListener {
                text2mass.text="dr"
                mass2NameText.text="Dram"
                mass2Text.text="00"
                massText.text="00"
                dotPressed2=false
                dotPressed=false
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
        massText.setOnClickListener {
            masstext=true
            mass2text=false
            dotPressed = false
            massText.setTextColor(colorYellow)
            mass2Text.setTextColor(colorGrey)
            mass2Text.text="00"
            massText.text="00"
        }
        mass2Text.setOnClickListener {
            masstext=false
            mass2text=true
            dotPressed2=false
            massText.setTextColor(colorGrey)
            mass2Text.setTextColor(colorYellow)
            massText.text="00"
            mass2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(masstext){
            if(massText.text.toString()=="00"){
                massText.text=""
            }
            if (stateEror){
                massText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    massText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    massText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(mass2Text.text.toString()=="00"){
                mass2Text.text=""
            }
            if (stateEror){
                mass2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    mass2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    mass2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }

    fun onAcClick(view: View){
        if(masstext){
            massText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            mass2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(masstext){
            if (massText.text.toString().isNotEmpty()) {
                val lastChar = massText.text.toString()[massText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                massText.text = massText.text.toString().dropLast(1)
            }
            if(massText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (mass2Text.text.toString().isNotEmpty()) {
                val lastChar = mass2Text.text.toString()[mass2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                mass2Text.text = mass2Text.text.toString().dropLast(1)
            }
            if(mass2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(masstext){
            var inputvalue=0.0
            if(massText.text.toString()==""){
                inputvalue=0.0
            }else{
                inputvalue=massText.text.toString().toDouble()
            }
            var inputUnit=textmass.text.toString()
            var outputUnit=text2mass.text.toString()
            var outputArea=convertMass(inputvalue,inputUnit,outputUnit).toString()
            mass2Text.text=outputArea
        }else{
            var inputvalue=0.0
            if (mass2Text.text.toString()==""){
                inputvalue=0.0
            }else{
                inputvalue=mass2Text.text.toString().toDouble()
            }
            var inputUnit=text2mass.text.toString()
            var outputUnit=textmass.text.toString()
            var outputArea=convertMass(inputvalue,inputUnit,outputUnit).toString()
            massText.text=outputArea
        }
    }
    fun convertMass(inputValue: Double, inputUnit: String, outputUnit: String): Double {
        val unitConversionMap = mapOf(
            "kg" to 1.0,
            "g" to 0.001,
            "mg" to 0.000001,
            "t" to 1000.0,
            "lb" to 0.45359237,
            "oz" to 0.0283495231,
            "ct" to 0.0002,
            "q" to 100.0,
            "gr" to 6.479891e-5,
            "µg" to 1e-9,
            "cwt" to 45.359237,
            "st" to 6.35029318,
            "dr" to 0.0017718451953125
        )

        val inputConversionFactor = unitConversionMap[inputUnit]
            ?: throw IllegalArgumentException("Invalid input unit: $inputUnit")

        val outputConversionFactor = unitConversionMap[outputUnit]
            ?: throw IllegalArgumentException("Invalid output unit: $outputUnit")

        val inputValueInKilogram = inputValue * inputConversionFactor
        val outputValue = inputValueInKilogram / outputConversionFactor

        return outputValue
    }
}