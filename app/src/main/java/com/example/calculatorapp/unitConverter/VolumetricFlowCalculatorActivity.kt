package com.example.calculatorapp.unitConverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_volumetric_flow_calculator.*
import kotlinx.android.synthetic.main.activity_volumetric_flow_calculator.backButton
import kotlinx.android.synthetic.main.activity_volumetric_flow_calculator.btn_AC

class VolumetricFlowCalculatorActivity : AppCompatActivity() {
    var vftext = true
    var vf2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volumetric_flow_calculator)

        backButton.setOnClickListener {
            finish()
        }
        vfSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@VolumetricFlowCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_volumetricflow,
                findViewById(R.id.bottomSheetVolumetricFlow)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.m_s).setOnClickListener {
                textVf.text = "m³/s"
                vfNameText.text = "Meter³/Second"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.l_s).setOnClickListener {
                textVf.text = "l/s"
                vfNameText.text = "Liter/Second"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_s).setOnClickListener {
                textVf.text = "ft³/s"
                vfNameText.text = "Foot³/Second"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gal_s).setOnClickListener {
                textVf.text = "gal/s"
                vfNameText.text = "US Gallon/Second"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_gal_s).setOnClickListener {
                textVf.text = "gal/s "
                vfNameText.text = "IMP Gallon/Second"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.m_min).setOnClickListener {
                textVf.text = "m³/min"
                vfNameText.text = "Meter³/Minute"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.m_h).setOnClickListener {
                textVf.text = "m³/h"
                vfNameText.text = "Meter³/Hour"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.m_d).setOnClickListener {
                textVf.text = "m³/d"
                vfNameText.text = "Meter³/Day"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.l_m).setOnClickListener {
                textVf.text = "l/min"
                vfNameText.text = "Liter/Minute"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.l_h).setOnClickListener {
                textVf.text = "l/h"
                vfNameText.text = "Liter/Hour"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.l_d).setOnClickListener {
                textVf.text = "l/d"
                vfNameText.text = "Liter/Day"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_min).setOnClickListener {
                textVf.text = "ft³/min"
                vfNameText.text = "Foot³/Minute"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_h).setOnClickListener {
                textVf.text = "ft³/h"
                vfNameText.text = "Foot³/Hour"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_d).setOnClickListener {
                textVf.text = "ft³/d"
                vfNameText.text = "Foot³/Day"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gal_min).setOnClickListener {
                textVf.text = "gal/min"
                vfNameText.text = "US Gallon/Minute"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gal_h).setOnClickListener {
                textVf.text = "gal/h"
                vfNameText.text = "US Gallon/Hour"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gal_d).setOnClickListener {
                textVf.text = "gal/d"
                vfNameText.text = "US Gallon/Day"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_gal_min).setOnClickListener {
                textVf.text = "gal/min "
                vfNameText.text = "IMP Gallon/Minute"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_gal_h).setOnClickListener {
                textVf.text = "gal/h "
                vfNameText.text = "IMP Gallon/Hour"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_gal_d).setOnClickListener {
                textVf.text = "gal/d "
                vfNameText.text = "IMP Gallon/Day"
                vf2Text.text = "00"
                vfText.text = "00"
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
        vf2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@VolumetricFlowCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_volumetricflow,
                findViewById(R.id.bottomSheetVolumetricFlow)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.m_s).setOnClickListener {
                text2Vf.text = "m³/s"
                vf2NameText.text = "Meter³/Second"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.l_s).setOnClickListener {
                text2Vf.text = "l/s"
                vf2NameText.text = "Liter/Second"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_s).setOnClickListener {
                text2Vf.text = "ft³/s"
                vf2NameText.text = "Foot³/Second"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gal_s).setOnClickListener {
                text2Vf.text = "gal/s"
                vf2NameText.text = "US Gallon/Second"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_gal_s).setOnClickListener {
                text2Vf.text = "gal/s "
                vf2NameText.text = "IMP Gallon/Second"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.m_min).setOnClickListener {
                text2Vf.text = "m³/min"
                vf2NameText.text = "Meter³/Minute"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.m_h).setOnClickListener {
                text2Vf.text = "m³/h"
                vf2NameText.text = "Meter³/Hour"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.m_d).setOnClickListener {
                text2Vf.text = "m³/d"
                vf2NameText.text = "Meter³/Day"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.l_m).setOnClickListener {
                text2Vf.text = "l/min"
                vf2NameText.text = "Liter/Minute"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.l_h).setOnClickListener {
                text2Vf.text = "l/h"
                vf2NameText.text = "Liter/Hour"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.l_d).setOnClickListener {
                text2Vf.text = "l/d"
                vf2NameText.text = "Liter/Day"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_min).setOnClickListener {
                text2Vf.text = "ft³/min"
                vf2NameText.text = "Foot³/Minute"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_h).setOnClickListener {
                text2Vf.text = "ft³/h"
                vf2NameText.text = "Foot³/Hour"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_d).setOnClickListener {
                text2Vf.text = "ft³/d"
                vf2NameText.text = "Foot³/Day"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gal_min).setOnClickListener {
                text2Vf.text = "gal/min"
                vf2NameText.text = "US Gallon/Minute"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gal_h).setOnClickListener {
                text2Vf.text = "gal/h"
                vf2NameText.text = "US Gallon/Hour"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gal_d).setOnClickListener {
                text2Vf.text = "gal/d"
                vf2NameText.text = "US Gallon/Day"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_gal_min).setOnClickListener {
                text2Vf.text = "gal/min "
                vf2NameText.text = "IMP Gallon/Minute"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_gal_h).setOnClickListener {
                text2Vf.text = "gal/h "
                vf2NameText.text = "IMP Gallon/Hour"
                vf2Text.text = "00"
                vfText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_gal_d).setOnClickListener {
                text2Vf.text = "gal/d "
                vf2NameText.text = "IMP Gallon/Day"
                vf2Text.text = "00"
                vfText.text = "00"
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
        vfText.setOnClickListener {
            vftext=true
            vf2text=false
            dotPressed=false
            vfText.setTextColor(colorYellow)
            vf2Text.setTextColor(colorGrey)
            vf2Text.text="00"
            vfText.text="00"
        }
        vf2Text.setOnClickListener {
            vftext=false
            vf2text=true
            dotPressed2=false
            vfText.setTextColor(colorGrey)
            vf2Text.setTextColor(colorYellow)
            vfText.text="00"
            vf2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(vftext){
            if(vfText.text.toString()=="00"){
                vfText.text=""
            }
            if (stateEror){
                vfText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    vfText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    vfText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(vf2Text.text.toString()=="00"){
                vf2Text.text=""
            }
            if (stateEror){
                vf2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    vf2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    vf2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(vftext){
            vfText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            vf2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(vftext){
            if (vfText.text.toString().isNotEmpty()) {
                val lastChar = vfText.text.toString()[vfText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                vfText.text = vfText.text.toString().dropLast(1)
            }
            if(vfText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (vf2Text.text.toString().isNotEmpty()) {
                val lastChar = vf2Text.text.toString()[vf2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                vf2Text.text = vf2Text.text.toString().dropLast(1)
            }
            if(vf2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(vftext){
            var inputSize=0.0
            if(vfText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=vfText.text.toString().toDouble()
            }
            var inputUnit=textVf.text.toString()
            var outputUnit=text2Vf.text.toString()
            var outputSize=convertVolumetricFlow(inputSize,outputUnit,inputUnit).toString()
            vf2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (vf2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=vf2Text.text.toString().toDouble()
            }
            var inputUnit=text2Vf.text.toString()
            var outputUnit=textVf.text.toString()
            var outputArea=convertVolumetricFlow(inputSize,outputUnit,inputUnit).toString()
            vfText.text=outputArea
        }



    }
    fun convertVolumetricFlow(value: Double, fromUnit: String, toUnit: String): Double {
        val angleMap = mapOf(
            "m³/s" to 1.0,
            "l/s" to 1000,
            "ft³/s" to 35.31,
            "gal/s" to 264.17,
            "gal/s " to 219.97,
            "tbsp " to 0.06,
            "m³/min" to 60,
            "m³/h" to 3600,
            "m³/d" to 86400,
            "l/min" to 60000,
            "l/h" to 3600000,
            "l/d" to 86400000,
            "ft³/min" to 2118.88,
            "ft³/h" to 127132.8,
            "ft³/d" to 3051187.2,
            "gal/min" to 15850.32,
            "gal/h" to 951019.39,
            "gal/d" to 22824465.32,
            "gal/min " to 13198.15,
            "gal/h " to 791889.29,
            "gal/d " to 19005343.05
        )

        val conversionFactor = angleMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor.toDouble()
        val toConversionFactor = angleMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor.toDouble()
    }
}