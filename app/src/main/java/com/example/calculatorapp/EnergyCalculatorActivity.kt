package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_energy_calculator.*
import kotlinx.android.synthetic.main.activity_energy_calculator.backButton
import kotlinx.android.synthetic.main.activity_energy_calculator.btn_AC

class EnergyCalculatorActivity : AppCompatActivity() {
    var energytext = true
    var energy2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_energy_calculator)
        backButton.setOnClickListener {
            finish()
        }
        energySelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@EnergyCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_enegry,
                findViewById(R.id.bottomSheetEnergy)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.BTU).setOnClickListener {
                textEnergy.text = "BTU"
                energyNameText.text = "British thermal Unit"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kcal).setOnClickListener {
                textEnergy.text = "kcal"
                energyNameText.text = "Kilocalorie"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kJ).setOnClickListener {
                textEnergy.text = "kJ"
                energyNameText.text = "Kilojoule"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kWh).setOnClickListener {
                textEnergy.text = "kWh"
                energyNameText.text = "Kilowatt Hour"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.cal).setOnClickListener {
                textEnergy.text = "cal"
                energyNameText.text = "Calorie"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.eV).setOnClickListener {
                textEnergy.text = "eV"
                energyNameText.text = "Electronvolt"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.erg).setOnClickListener {
                textEnergy.text = "erg"
                energyNameText.text = "Erg"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_lbf).setOnClickListener {
                textEnergy.text = "ft-lbf"
                energyNameText.text = "Foot Pound"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.J).setOnClickListener {
                textEnergy.text = "J"
                energyNameText.text = "Joule"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.MJ).setOnClickListener {
                textEnergy.text = "MJ"
                energyNameText.text = "Megajoule"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Wh).setOnClickListener {
                textEnergy.text = "Wh"
                energyNameText.text = "Watt Hour"
                energy2Text.text = "00"
                energyText.text = "00"
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
        energy2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@EnergyCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_enegry,
                findViewById(R.id.bottomSheetEnergy)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.BTU).setOnClickListener {
                text2Energy.text = "BTU"
                energy2NameText.text = "British thermal Unit"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kcal).setOnClickListener {
                text2Energy.text = "kcal"
                energy2NameText.text = "Kilocalorie"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kJ).setOnClickListener {
                text2Energy.text = "kJ"
                energy2NameText.text = "Kilojoule"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kWh).setOnClickListener {
                text2Energy.text = "kWh"
                energy2NameText.text = "Kilowatt Hour"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.cal).setOnClickListener {
                text2Energy.text = "cal"
                energy2NameText.text = "Calorie"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.eV).setOnClickListener {
                text2Energy.text = "eV"
                energy2NameText.text = "Electronvolt"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.erg).setOnClickListener {
                text2Energy.text = "erg"
                energy2NameText.text = "Erg"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_lbf).setOnClickListener {
                text2Energy.text = "ft-lbf"
                energy2NameText.text = "Foot Pound"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.J).setOnClickListener {
                text2Energy.text = "J"
                energy2NameText.text = "Joule"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.MJ).setOnClickListener {
                text2Energy.text = "MJ"
                energy2NameText.text = "Megajoule"
                energy2Text.text = "00"
                energyText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Wh).setOnClickListener {
                text2Energy.text = "Wh"
                energy2NameText.text = "Watt Hour"
                energy2Text.text = "00"
                energyText.text = "00"
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
        energyText.setOnClickListener {
            energytext=true
            energy2text=false
            dotPressed=false
            energyText.setTextColor(colorYellow)
            energy2Text.setTextColor(colorGrey)
            energy2Text.text="00"
            energyText.text="00"
        }
        energy2Text.setOnClickListener {
            energytext=false
            energy2text=true
            dotPressed2=false
            energyText.setTextColor(colorGrey)
            energy2Text.setTextColor(colorYellow)
            energyText.text="00"
            energy2Text.text="00"
        }

    }
    fun onDigitClick(view: View){
        if(energytext){
            if(energyText.text.toString()=="00"){
                energyText.text=""
            }
            if (stateEror){
                energyText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    energyText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    energyText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(energy2Text.text.toString()=="00"){
                energy2Text.text=""
            }
            if (stateEror){
                energy2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    energy2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    energy2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(energytext){
            energyText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            energy2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(energytext){
            if (energyText.text.toString().isNotEmpty()) {
                val lastChar = energyText.text.toString()[energyText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                energyText.text = energyText.text.toString().dropLast(1)
            }
            if(energyText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (energy2Text.text.toString().isNotEmpty()) {
                val lastChar = energy2Text.text.toString()[energy2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                energy2Text.text = energy2Text.text.toString().dropLast(1)
            }
            if(energy2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(energytext){
            var inputSize=0.0
            if(energyText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=energyText.text.toString().toDouble()
            }
            var inputUnit=textEnergy.text.toString()
            var outputUnit=text2Energy.text.toString()
            var outputSize=convertEnergy(inputSize,outputUnit,inputUnit).toString()
            energy2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (energy2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=energy2Text.text.toString().toDouble()
            }
            var inputUnit=text2Energy.text.toString()
            var outputUnit=textEnergy.text.toString()
            var outputArea=convertEnergy(inputSize,outputUnit,inputUnit).toString()
            energyText.text=outputArea
        }



    }
    fun convertEnergy(value: Double, fromUnit: String, toUnit: String): Double {
        val angleMap = mapOf(
            "BTU" to 1.0,
            "kcal" to 0.25,
            "kJ" to 1.06,
            "kWh" to 0.000293,
            "cal" to 252.16,
            "eV" to 6.59E-21,
            "erg" to 10550558526.2,
            "ft-lbf" to 778.17,
            "J" to 1055.06,
            "MJ" to 0.001055,
            "Wh" to 0.29
        )

        val conversionFactor = angleMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor
        val toConversionFactor = angleMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor
    }
}