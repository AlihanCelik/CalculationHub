package com.example.calculatorapp.unitConverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_acceleration_calculator.*
import kotlinx.android.synthetic.main.activity_acceleration_calculator.backButton
import kotlinx.android.synthetic.main.activity_acceleration_calculator.btn_AC


class AccelerationCalculatorActivity : AppCompatActivity() {
    var accetext = true
    var acce2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceleration_calculator)
        backButton.setOnClickListener {
            finish()
        }
        acceSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(
                    this@AccelerationCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_acceleration,
                findViewById(R.id.bottomSheetAccerelation)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.metersecond).setOnClickListener {
                textAcce.text = "m/s²"
                acceNameText.text = "Meter/Second²"
                acce2Text.text = "00"
                acceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.footsecond).setOnClickListener {
                textAcce.text = "ft/s²"
                acceNameText.text = "Foot/Second²"
                acce2Text.text = "00"
                acceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gal).setOnClickListener {
                textAcce.text = "cm/s²"
                acceNameText.text = "Gal"
                acce2Text.text = "00"
                acceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gravity).setOnClickListener {
                textAcce.text = "g"
                acceNameText.text = "Gravity"
                acce2Text.text = "00"
                acceText.text = "00"
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
        acce2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(
                    this@AccelerationCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_acceleration,
                findViewById(R.id.bottomSheetAccerelation)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.metersecond).setOnClickListener {
                text2Acce.text = "m/s²"
                acce2NameText.text = "Meter/Second²"
                acce2Text.text = "00"
                acceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.footsecond).setOnClickListener {
                text2Acce.text = "ft/s²"
                acce2NameText.text = "Foot/Second²"
                acce2Text.text = "00"
                acceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gal).setOnClickListener {
                text2Acce.text = "cm/s²"
                acce2NameText.text = "Gal"
                acce2Text.text = "00"
                acceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gravity).setOnClickListener {
                text2Acce.text = "g"
                acce2NameText.text = "Gravity"
                acce2Text.text = "00"
                acceText.text = "00"
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
        acceText.setOnClickListener {
            accetext=true
            acce2text=false
            dotPressed=false
            acceText.setTextColor(colorYellow)
            acce2Text.setTextColor(colorGrey)
            acce2Text.text="00"
            acceText.text="00"
        }
        acce2Text.setOnClickListener {
            accetext=false
            acce2text=true
            dotPressed2=false
            acceText.setTextColor(colorGrey)
            acce2Text.setTextColor(colorYellow)
            acceText.text="00"
            acce2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(accetext){
            if(acceText.text.toString()=="00"){
                acceText.text=""
            }
            if (stateEror){
                acceText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    acceText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    acceText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(acce2Text.text.toString()=="00"){
                acce2Text.text=""
            }
            if (stateEror){
                acce2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    acce2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    acce2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(accetext){
            acceText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            acce2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(accetext){
            if (acceText.text.toString().isNotEmpty()) {
                val lastChar = acceText.text.toString()[acceText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                acceText.text = acceText.text.toString().dropLast(1)
            }
            if(acceText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (acce2Text.text.toString().isNotEmpty()) {
                val lastChar = acce2Text.text.toString()[acce2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                acce2Text.text = acce2Text.text.toString().dropLast(1)
            }
            if(acce2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }

    fun onEnterClick(view: View){

        if(accetext){
            var inputSize=0.0
            if(acceText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=acceText.text.toString().toDouble()
            }
            var inputUnit=textAcce.text.toString()
            var outputUnit=text2Acce.text.toString()
            var outputSize=convertAcceleration(inputSize,outputUnit,inputUnit).toString()
            acce2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (acce2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=acce2Text.text.toString().toDouble()
            }
            var inputUnit=text2Acce.text.toString()
            var outputUnit=textAcce.text.toString()
            var outputArea=convertAcceleration(inputSize,outputUnit,inputUnit).toString()
            acceText.text=outputArea
        }



    }
    fun convertAcceleration(value: Double, fromUnit: String, toUnit: String): Double {
        val accelerationMap = mapOf(
            "m/s²" to 1.0,
            "cm/s²" to 100.0,
            "ft/s²" to 3.28084,
            "g" to 0.101972
        )

        val conversionFactor = accelerationMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor
        val toConversionFactor = accelerationMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor
    }
}