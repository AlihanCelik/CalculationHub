package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_area_calculator.*
import kotlinx.android.synthetic.main.activity_area_calculator.backButton
import kotlinx.android.synthetic.main.activity_area_calculator.btn_AC


class AreaCalculatorActivity : AppCompatActivity() {
    var areatext=true
    var area2text=false
    var stateEror=false
    var dotPressed = false
    var dotPressed2=false

    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area_calculator)
        backButton.setOnClickListener {
            finish()
        }
        areaSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@AreaCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheetarea1,
                findViewById(R.id.bottomSheetArea)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.squareKilometers).setOnClickListener {
                textUnit.text="km²"
                areaNameText.text="Square Kilometers"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.hectare).setOnClickListener {
                textUnit.text="ha"
                areaNameText.text="Hectare"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.ar).setOnClickListener {
                textUnit.text="a"
                areaNameText.text="Ar"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareMeters).setOnClickListener {
                textUnit.text="m²"
                areaNameText.text="Square Meters"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareDecimeter).setOnClickListener {
                textUnit.text="dm²"
                areaNameText.text="Square Decimeter"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareCentimeter).setOnClickListener {
                textUnit.text="cm²"
                areaNameText.text="Square Centimeter"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareMilimeter).setOnClickListener {
                textUnit.text="mm²"
                areaNameText.text="Square Millimeter"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareMicron).setOnClickListener {
                textUnit.text="µm²"
                areaNameText.text="Square Micron"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.acre).setOnClickListener {
                textUnit.text="ac"
                areaNameText.text="Acre"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareMile).setOnClickListener {
                textUnit.text="mm²"
                areaNameText.text="Square Mile"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareYard).setOnClickListener {
                textUnit.text="yd²"
                areaNameText.text="Square Yard"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.stepSquare).setOnClickListener {
                textUnit.text="ft²"
                areaNameText.text="Food Square"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareInch).setOnClickListener {
                textUnit.text="in²"
                areaNameText.text="Square Inch"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.rodSquare).setOnClickListener {
                textUnit.text="rd²"
                areaNameText.text="Rodsquare"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()

        }
        area2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@AreaCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheetarea1,
                findViewById(R.id.bottomSheetArea)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.squareKilometers).setOnClickListener {
                text2Unit.text="km²"
                area2NameText.text="Square Kilometers"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.hectare).setOnClickListener {
                text2Unit.text="ha"
                area2NameText.text="Hectare"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ar).setOnClickListener {
                text2Unit.text="a"
                area2NameText.text="Ar"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareMeters).setOnClickListener {
                text2Unit.text="m²"
                area2NameText.text="Square Meters"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareDecimeter).setOnClickListener {
                text2Unit.text="dm²"
                area2NameText.text="Square Decimeter"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareCentimeter).setOnClickListener {
                text2Unit.text="cm²"
                area2NameText.text="Square Centimeter"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareMilimeter).setOnClickListener {
                text2Unit.text="mm²"
                area2NameText.text="Square Millimeter"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareMicron).setOnClickListener {
                text2Unit.text="µm²"
                area2NameText.text="Square Micron"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.acre).setOnClickListener {
                text2Unit.text="ac"
                area2NameText.text="Acre"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareMile).setOnClickListener {
                text2Unit.text="mm²"
                area2NameText.text="Square Mile"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareYard).setOnClickListener {
                text2Unit.text="yd²"
                area2NameText.text="Square Yard"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.stepSquare).setOnClickListener {
                text2Unit.text="ft²"
                area2NameText.text="Food Square"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.squareInch).setOnClickListener {
                text2Unit.text="in²"
                area2NameText.text="Square Inch"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.rodSquare).setOnClickListener {
                textUnit.text="rd²"
                areaNameText.text="Rodsquare"
                area2Text.text="00"
                areaText.text="00"
                dotPressed = false
                dotPressed2=false
                bottomSheet.dismiss()
            }

            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()

        }
        areaText.setOnClickListener {
            areatext=true
            area2text=false
            dotPressed = false
            areaText.setTextColor(colorYellow)
            area2Text.setTextColor(colorGrey)
            area2Text.text="00"
            areaText.text="00"
        }
        area2Text.setOnClickListener {
            areatext=false
            area2text=true
            dotPressed2=false
            areaText.setTextColor(colorGrey)
            area2Text.setTextColor(colorYellow)
            areaText.text="00"
            area2Text.text="00"
        }

    }
    fun onDigitClick(view: View){
        if(areatext){
            if(areaText.text.toString()=="00"){
                areaText.text=""
            }
            if (stateEror){
                areaText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    areaText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    areaText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(area2Text.text.toString()=="00"){
                area2Text.text=""
            }
            if (stateEror){
                area2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    area2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    area2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(areatext){
            areaText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            area2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }
    }
    fun onClearClick(view: View){
        if(areatext){
            if (areaText.text.toString().isNotEmpty()) {
                val lastChar = areaText.text.toString()[areaText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                areaText.text = areaText.text.toString().dropLast(1)
            }
            if(areaText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (area2Text.text.toString().isNotEmpty()) {
                val lastChar = area2Text.text.toString()[area2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                area2Text.text = area2Text.text.toString().dropLast(1)
            }
            if(area2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(areatext){
            var inputArea=0.0
            if(areaText.text.toString()==""){
                inputArea=0.0
            }else{
                inputArea=areaText.text.toString().toDouble()
            }
            var inputUnit=textUnit.text.toString()
            var outputUnit=text2Unit.text.toString()
            var outputArea=convertArea(inputArea,inputUnit,outputUnit).toString()
            area2Text.text=outputArea
        }else{
            var inputArea=0.0
            if (area2Text.text.toString()==""){
                inputArea=0.0
            }else{
                inputArea=area2Text.text.toString().toDouble()
            }
            var inputUnit=text2Unit.text.toString()
            var outputUnit=textUnit.text.toString()
            var outputArea=convertArea(inputArea,inputUnit,outputUnit).toString()
            areaText.text=outputArea
        }
    }


    fun convertArea(inputArea: Double, inputUnit: String, outputUnit: String): Double {
        val squareMeter: Double = when (inputUnit.toLowerCase()) {
            "km²" -> inputArea * 1_000_000
            "ha" -> inputArea * 10_000
            "a" -> inputArea * 100
            "m²" -> inputArea
            "dm²" -> inputArea / 100
            "cm²" -> inputArea / 10_000
            "mm²" -> inputArea / 1_000_000
            "µm²" -> inputArea / Math.pow(10.0,12.0)
            "ac" -> inputArea * 4046.86
            "mile²" -> inputArea * 2_589_988.11
            "yd²" -> inputArea * 0.83612736
            "ft²" -> inputArea * 0.09290304
            "in²" -> inputArea * 0.00064516
            "rd²" -> inputArea * 25.2928526
            else -> throw IllegalArgumentException("Invalid input unit: $inputUnit")
        }

        return when (outputUnit.toLowerCase()) {
            "km²" -> squareMeter / 1_000_000
            "ha" -> squareMeter / 10_000
            "a" -> squareMeter / 100
            "m²" -> squareMeter
            "dm²" -> squareMeter * 100
            "cm²" -> squareMeter * 10_000
            "mm²" -> squareMeter * 1_000_000
            "µm²" -> squareMeter * Math.pow(10.0,12.0)
            "ac" -> squareMeter / 4046.86
            "mile²" -> squareMeter / 2_589_988.11
            "yd²" -> squareMeter / 0.83612736
            "ft²" -> squareMeter / 0.09290304
            "in²" -> squareMeter / 0.00064516
            "rd²" -> squareMeter / 25.2928526
            else -> throw IllegalArgumentException("Invalid output unit: $outputUnit")
        }
    }


}

