package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_length_calculator.*
import kotlinx.android.synthetic.main.activity_length_calculator.backButton
import kotlinx.android.synthetic.main.activity_length_calculator.btn_AC

class LengthCalculatorActivity : AppCompatActivity() {
    var lengthtext = true
    var length2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length_calculator)
        backButton.setOnClickListener {
            finish()
        }
        lengthSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@LengthCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_length,
                findViewById(R.id.bottomSheetLength)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.kilometer).setOnClickListener {
                textlength.text="km"
                lengthNameText.text="Kilometer"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.metre).setOnClickListener {
                textlength.text="m"
                lengthNameText.text="Metre"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.decimeter).setOnClickListener {
                textlength.text="dm"
                lengthNameText.text="Decimeter"
                length2Text.text="00"
                lengthText.text="00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.centimeter).setOnClickListener {
                textlength.text="cm"
                lengthNameText.text="Centimeter"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.millimeter).setOnClickListener {
                textlength.text="mm"
                lengthNameText.text="Millimeter"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.micrometer).setOnClickListener {
                textlength.text="µm"
                lengthNameText.text="Micrometer"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.nanometer).setOnClickListener {
                textlength.text="nm"
                lengthNameText.text="Nanometer"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.picometer).setOnClickListener {
                textlength.text="pm"
                lengthNameText.text="Picometer"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.nauticalMile).setOnClickListener {
                textlength.text="nmi"
                lengthNameText.text="Nautical Mile"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.yard).setOnClickListener {
                textlength.text="yd"
                lengthNameText.text="Yard"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.foot).setOnClickListener {
                textlength.text="ft"
                lengthNameText.text="Foot"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Inch).setOnClickListener {
                textlength.text="in"
                lengthNameText.text="Inch"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mile).setOnClickListener {
                textlength.text="mi"
                lengthNameText.text="Mile"
                length2Text.text="00"
                lengthText.text="00"
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
        length2Select.setOnClickListener{
            val bottomSheet =
                BottomSheetDialog(this@LengthCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_length,
                findViewById(R.id.bottomSheetLength)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.kilometer).setOnClickListener {
                text2Length.text="km"
                length2NameText.text="Kilometer"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.metre).setOnClickListener {
                text2Length.text="m"
                length2NameText.text="Metre"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.decimeter).setOnClickListener {
                text2Length.text="dm"
                length2NameText.text="Decimeter"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.centimeter).setOnClickListener {
                text2Length.text="cm"
                length2NameText.text="Centimeter"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.millimeter).setOnClickListener {
                text2Length.text="mm"
                length2NameText.text="Millimeter"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mile).setOnClickListener {
                text2Length.text="mi"
                length2NameText.text="Mile"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.micrometer).setOnClickListener {
                text2Length.text="µm"
                length2NameText.text="Micrometer"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.nanometer).setOnClickListener {
                text2Length.text="nm"
                length2NameText.text="Nanometer"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.picometer).setOnClickListener {
                text2Length.text="pm"
                length2NameText.text="Picometer"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.nauticalMile).setOnClickListener {
                text2Length.text="nmi"
                length2NameText.text="Nautical Mile"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.yard).setOnClickListener {
                text2Length.text="yd"
                length2NameText.text="Yard"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.foot).setOnClickListener {
                text2Length.text="ft"
                length2NameText.text="Foot"
                length2Text.text="00"
                lengthText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Inch).setOnClickListener {
                text2Length.text="in"
                length2NameText.text="Inch"
                length2Text.text="00"
                lengthText.text="00"
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
        lengthText.setOnClickListener {
            lengthtext=true
            length2text=false
            dotPressed = false
            lengthText.setTextColor(colorYellow)
            length2Text.setTextColor(colorGrey)
            length2Text.text="00"
            lengthText.text="00"
        }
        length2Text.setOnClickListener {
            lengthtext=false
            length2text=true
            dotPressed2=false
            lengthText.setTextColor(colorGrey)
            length2Text.setTextColor(colorYellow)
            lengthText.text="00"
            length2Text.text="00"
        }
    }

    fun onDigitClick(view: View){
        if(lengthtext){
            if(lengthText.text.toString()=="00"){
                lengthText.text=""
            }
            if (stateEror){
                lengthText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    lengthText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    lengthText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(length2Text.text.toString()=="00"){
                length2Text.text=""
            }
            if (stateEror){
                length2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    length2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    length2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(lengthtext){
            lengthText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            length2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(lengthtext){
            if (lengthText.text.toString().isNotEmpty()) {
                val lastChar = lengthText.text.toString()[lengthText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                lengthText.text = lengthText.text.toString().dropLast(1)
            }
            if(lengthText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (length2Text.text.toString().isNotEmpty()) {
                val lastChar = length2Text.text.toString()[length2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                length2Text.text = length2Text.text.toString().dropLast(1)
            }
            if(length2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(lengthtext){
            var inputvalue=0.0
            if(lengthText.text.toString()==""){
                inputvalue=0.0
            }else{
                inputvalue=lengthText.text.toString().toDouble()
            }
            var inputUnit=textlength.text.toString()
            var outputUnit=text2Length.text.toString()
            var outputArea=convertLength(inputvalue,inputUnit,outputUnit).toString()
            length2Text.text=outputArea
        }else{
            var inputvalue=0.0
            if (length2Text.text.toString()==""){
                inputvalue=0.0
            }else{
                inputvalue=length2Text.text.toString().toDouble()
            }
            var inputUnit=text2Length.text.toString()
            var outputUnit=textlength.text.toString()
            var outputArea=convertLength(inputvalue,inputUnit,outputUnit).toString()
            lengthText.text=outputArea
        }
    }
    fun convertLength(inputValue: Double, inputUnit: String, outputUnit: String): Double {
        val unitConversionMap = mapOf(
            "mm" to 0.001,
            "cm" to 0.01,
            "m" to 1.0,
            "km" to 1000.0,
            "in" to 0.0254,
            "ft" to 0.3048,
            "yd" to 0.9144,
            "mi" to 1609.344,
            "nm" to 1e-9,
            "nmi" to 1852.0,
            "dm" to 0.1,
            "pm" to 1e-12,
            "µm" to 1e-6
        )

        val inputValueInMeter = inputValue * unitConversionMap[inputUnit]!!
        val outputValue = inputValueInMeter / unitConversionMap[outputUnit]!!


        return outputValue
    }
}