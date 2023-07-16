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
import kotlinx.android.synthetic.main.activity_force_calculator.*
import kotlinx.android.synthetic.main.activity_force_calculator.backButton
import kotlinx.android.synthetic.main.activity_force_calculator.btn_AC

class ForceCalculatorActivity : AppCompatActivity() {
    var forcetext = true
    var force2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_force_calculator)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        forceSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@ForceCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_force,
                findViewById(R.id.bottomSheetForce)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.N).setOnClickListener {
                textForce.text = "N"
                forceNameText.text = "Newton"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dyn).setOnClickListener {
                textForce.text = "dyn"
                forceNameText.text = "Dyne"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kgf).setOnClickListener {
                textForce.text = "kgf"
                forceNameText.text = "Kilogram Force"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.lbf).setOnClickListener {
                textForce.text = "lbf"
                forceNameText.text = "Pound Force"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kN).setOnClickListener {
                textForce.text = "kN"
                forceNameText.text = "Kilonewton"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gf).setOnClickListener {
                textForce.text = "gf"
                forceNameText.text = "Gram Force"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ozf).setOnClickListener {
                textForce.text = "ozf"
                forceNameText.text = "Ounce Force"
                force2Text.text = "00"
                forceText.text = "00"
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
        force2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@ForceCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_force,
                findViewById(R.id.bottomSheetForce)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.N).setOnClickListener {
                text2Force.text = "N"
                force2NameText.text = "Newton"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dyn).setOnClickListener {
                text2Force.text = "dyn"
                force2NameText.text = "Dyne"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kgf).setOnClickListener {
                text2Force.text = "kgf"
                force2NameText.text = "Kilogram Force"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.lbf).setOnClickListener {
                text2Force.text = "lbf"
                force2NameText.text = "Pound Force"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kN).setOnClickListener {
                text2Force.text = "kN"
                force2NameText.text = "Kilonewton"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gf).setOnClickListener {
                text2Force.text = "gf"
                force2NameText.text = "Gram Force"
                force2Text.text = "00"
                forceText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ozf).setOnClickListener {
                text2Force.text = "ozf"
                force2NameText.text = "Ounce Force"
                force2Text.text = "00"
                forceText.text = "00"
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
        forceText.setOnClickListener {
            forcetext=true
            force2text=false
            dotPressed=false
            forceText.setTextColor(colorYellow)
            force2Text.setTextColor(colorGrey)
            force2Text.text="00"
            forceText.text="00"
        }
        force2Text.setOnClickListener {
            forcetext=false
            force2text=true
            dotPressed2=false
            forceText.setTextColor(colorGrey)
            force2Text.setTextColor(colorYellow)
            forceText.text="00"
            force2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(forcetext){
            if(forceText.text.toString()=="00"){
                forceText.text=""
            }
            if (stateEror){
                forceText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    forceText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    forceText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(force2Text.text.toString()=="00"){
                force2Text.text=""
            }
            if (stateEror){
                force2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    force2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    force2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(forcetext){
            forceText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            force2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(forcetext){
            if (forceText.text.toString().isNotEmpty()) {
                val lastChar = forceText.text.toString()[forceText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                forceText.text = forceText.text.toString().dropLast(1)
            }
            if(forceText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (force2Text.text.toString().isNotEmpty()) {
                val lastChar = force2Text.text.toString()[force2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                force2Text.text = force2Text.text.toString().dropLast(1)
            }
            if(force2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(forcetext){
            var inputSize=0.0
            if(forceText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=forceText.text.toString().toDouble()
            }
            var inputUnit=textForce.text.toString()
            var outputUnit=text2Force.text.toString()
            var outputSize=convertForce(inputSize,outputUnit,inputUnit).toString()
            force2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (force2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=force2Text.text.toString().toDouble()
            }
            var inputUnit=text2Force.text.toString()
            var outputUnit=textForce.text.toString()
            var outputArea=convertForce(inputSize,outputUnit,inputUnit).toString()
            forceText.text=outputArea
        }



    }

    fun convertForce(value: Double, fromUnit: String, toUnit: String): Double {
        val angleMap = mapOf(
            "N" to 1.0,
            "dyn" to 100000,
            "kgf" to 0.1,
            "lbf" to 0.22,
            "kN" to 0.001,
            "gf" to 101.97,
            "ozf" to 3.6
        )

        val conversionFactor = angleMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor.toDouble()
        val toConversionFactor = angleMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor.toDouble()
    }
}