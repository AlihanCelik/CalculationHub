package com.example.calculatorapp.unitConverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_torque_calculator.*
import kotlinx.android.synthetic.main.activity_torque_calculator.backButton
import kotlinx.android.synthetic.main.activity_torque_calculator.btn_AC

class TorqueCalculatorActivity : AppCompatActivity() {
    var tortext = true
    var tor2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_torque_calculator)
        backButton.setOnClickListener {
            finish()
        }
        torSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@TorqueCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_torque,
                findViewById(R.id.bottomSheetTorque)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.N_m).setOnClickListener {
                textTor.text = "N•m"
                torNameText.text = "Newton Meter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kgf_m).setOnClickListener {
                textTor.text = "kgf•m"
                torNameText.text = "Kilogram-Force Meter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.lbf_in).setOnClickListener {
                textTor.text = "lbf•in"
                torNameText.text = "Pound-Force Inch"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.lbf_ft).setOnClickListener {
                textTor.text = "lbf•ft"
                torNameText.text = "Pound-Force Foot"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.N_mm).setOnClickListener {
                textTor.text = "N•mm"
                torNameText.text = "Newton Millimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.N_cm).setOnClickListener {
                textTor.text = "N•cm"
                torNameText.text = "Newton Centimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kN_m).setOnClickListener {
                textTor.text = "kN•m"
                torNameText.text = "Kilonewton Meter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dyn_mm).setOnClickListener {
                textTor.text = "dyn•mm"
                torNameText.text = "Dyne Millimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dyn_cm).setOnClickListener {
                textTor.text = "dyn•cm"
                torNameText.text = "Dyne Centimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dyn_m).setOnClickListener {
                textTor.text = "dyn•m"
                torNameText.text = "Dyne Meter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kgf_mm).setOnClickListener {
                textTor.text = "kgf•mm"
                torNameText.text = "Kilogram-Force Millimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kgf_cm).setOnClickListener {
                textTor.text = "kgf•cm"
                torNameText.text = "Kilogram-Force Centimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gf_mm).setOnClickListener {
                textTor.text = "gf•mm"
                torNameText.text = "Gram-Force Millimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gf_cm).setOnClickListener {
                textTor.text = "gf•cm"
                torNameText.text = "Gram-Force Centimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gf_m).setOnClickListener {
                textTor.text = "gf•m"
                torNameText.text = "Gram-Force Meter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ozt_in).setOnClickListener {
                textTor.text = "ozt•in"
                torNameText.text = "Ounce-Force Inch"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ozt_ft).setOnClickListener {
                textTor.text = "ozt•ft"
                torNameText.text = "Ounce-Force Foot"
                tor2Text.text = "00"
                torText.text = "00"
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
        tor2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@TorqueCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_torque,
                findViewById(R.id.bottomSheetTorque)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.N_m).setOnClickListener {
                text2Tor.text = "N•m"
                tor2NameText.text = "Newton Meter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kgf_m).setOnClickListener {
                text2Tor.text = "kgf•m"
                tor2NameText.text = "Kilogram-Force Meter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.lbf_in).setOnClickListener {
                text2Tor.text = "lbf•in"
                tor2NameText.text = "Pound-Force Inch"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.lbf_ft).setOnClickListener {
                text2Tor.text = "lbf•ft"
                tor2NameText.text = "Pound-Force Foot"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.N_mm).setOnClickListener {
                text2Tor.text = "N•mm"
                tor2NameText.text = "Newton Millimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.N_cm).setOnClickListener {
                text2Tor.text = "N•cm"
                tor2NameText.text = "Newton Centimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kN_m).setOnClickListener {
                text2Tor.text = "kN•m"
                tor2NameText.text = "Kilonewton Meter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dyn_mm).setOnClickListener {
                text2Tor.text = "dyn•mm"
                tor2NameText.text = "Dyne Millimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dyn_cm).setOnClickListener {
                text2Tor.text = "dyn•cm"
                tor2NameText.text = "Dyne Centimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dyn_m).setOnClickListener {
                text2Tor.text = "dyn•m"
                tor2NameText.text = "Dyne Meter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kgf_mm).setOnClickListener {
                text2Tor.text = "kgf•mm"
                tor2NameText.text = "Kilogram-Force Millimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kgf_cm).setOnClickListener {
                text2Tor.text = "kgf•cm"
                tor2NameText.text = "Kilogram-Force Centimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gf_mm).setOnClickListener {
                text2Tor.text = "gf•mm"
                tor2NameText.text = "Gram-Force Millimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gf_cm).setOnClickListener {
                text2Tor.text = "gf•cm"
                tor2NameText.text = "Gram-Force Centimeter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gf_m).setOnClickListener {
                text2Tor.text = "gf•m"
                tor2NameText.text = "Gram-Force Meter"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ozt_in).setOnClickListener {
                text2Tor.text = "ozt•in"
                tor2NameText.text = "Ounce-Force Inch"
                tor2Text.text = "00"
                torText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ozt_ft).setOnClickListener {
                text2Tor.text = "ozt•ft"
                tor2NameText.text = "Ounce-Force Foot"
                tor2Text.text = "00"
                torText.text = "00"
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
        torText.setOnClickListener {
            tortext=true
            tor2text=false
            dotPressed=false
            torText.setTextColor(colorYellow)
            tor2Text.setTextColor(colorGrey)
            tor2Text.text="00"
            torText.text="00"
        }
        tor2Text.setOnClickListener {
            tortext=false
            tor2text=true
            dotPressed2=false
            torText.setTextColor(colorGrey)
            tor2Text.setTextColor(colorYellow)
            torText.text="00"
            tor2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(tortext){
            if(torText.text.toString()=="00"){
                torText.text=""
            }
            if (stateEror){
                torText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    torText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    torText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(tor2Text.text.toString()=="00"){
                tor2Text.text=""
            }
            if (stateEror){
                tor2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    tor2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    tor2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(tortext){
            torText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            tor2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(tortext){
            if (torText.text.toString().isNotEmpty()) {
                val lastChar = torText.text.toString()[torText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                torText.text = torText.text.toString().dropLast(1)
            }
            if(torText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (tor2Text.text.toString().isNotEmpty()) {
                val lastChar = tor2Text.text.toString()[tor2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                tor2Text.text = tor2Text.text.toString().dropLast(1)
            }
            if(tor2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(tortext){
            var inputSize=0.0
            if(torText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=torText.text.toString().toDouble()
            }
            var inputUnit=textTor.text.toString()
            var outputUnit=text2Tor.text.toString()
            var outputSize=convertTorque(inputSize,outputUnit,inputUnit).toString()
            tor2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (tor2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=tor2Text.text.toString().toDouble()
            }
            var inputUnit=text2Tor.text.toString()
            var outputUnit=textTor.text.toString()
            var outputArea=convertTorque(inputSize,outputUnit,inputUnit).toString()
            torText.text=outputArea
        }



    }
    fun convertTorque(value: Double, fromUnit: String, toUnit: String): Double {
        val angleMap = mapOf(
            "N•m" to 1.0,
            "kgf•m" to 0.1,
            "lbf•in" to 8.85,
            "lbf•ft" to 0.74,
            "N•mm" to 1000,
            "N•cm" to 100,
            "kN•m" to 0.001,
            "dyn•mm" to 100000000,
            "dyn•cm" to 10000000,
            "dyn•m" to 100000,
            "kgf•mm" to 101.97,
            "kgf•cm" to 10.2,
            "gf•mm" to 101971.62,
            "gf•cm" to 10197.16,
            "gf•m" to 101.97,
            "ozf•in" to 141.61,
            "ozf•ft" to 11.8
        )

        val conversionFactor = angleMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor.toDouble()
        val toConversionFactor = angleMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor.toDouble()
    }
}