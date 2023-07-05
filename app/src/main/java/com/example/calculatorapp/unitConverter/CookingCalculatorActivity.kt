package com.example.calculatorapp.unitConverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog

import kotlinx.android.synthetic.main.activity_cooking_calculator.*
import kotlinx.android.synthetic.main.activity_cooking_calculator.backButton
import kotlinx.android.synthetic.main.activity_cooking_calculator.btn_AC

class CookingCalculatorActivity : AppCompatActivity() {
    var cooktext = true
    var cook2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cooking_calculator)
        backButton.setOnClickListener {
            finish()
        }
        cookSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@CookingCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_cooking,
                findViewById(R.id.bottomSheetCooking)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.mililiter).setOnClickListener {
                textCook.text = "mil"
                cookNameText.text = "Mililiter"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_teaspoon).setOnClickListener {
                textCook.text = "tsp"
                cookNameText.text = "US Teaspoon"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_tablespoon).setOnClickListener {
                textCook.text = "tbsp"
                cookNameText.text = "US Tablespoon"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_cup).setOnClickListener {
                textCook.text = "c"
                cookNameText.text = "US Cup"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_teaspoon).setOnClickListener {
                textCook.text = "tsp "
                cookNameText.text = "IMP Teaspoon"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_tablespoon).setOnClickListener {
                textCook.text = "tbsp "
                cookNameText.text = "IMP Tablespoon"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_cup).setOnClickListener {
                textCook.text = "c "
                cookNameText.text = "IMP Cup"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.liter).setOnClickListener {
                textCook.text = "l"
                cookNameText.text = "Liter"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_ounce).setOnClickListener {
                textCook.text = "oz"
                cookNameText.text = "US Ounce"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_pint).setOnClickListener {
                textCook.text = "pt"
                cookNameText.text = "US Pint"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_quart).setOnClickListener {
                textCook.text = "qt"
                cookNameText.text = "US Quart"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gallon).setOnClickListener {
                textCook.text = "gal"
                cookNameText.text = "US Gallon"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_ounce).setOnClickListener {
                textCook.text = "oz "
                cookNameText.text = "IMP Ounce"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_pint).setOnClickListener {
                textCook.text = "pt "
                cookNameText.text = "IMP Pint"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_quart).setOnClickListener {
                textCook.text = "qt "
                cookNameText.text = "IMP Quart"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_gallon).setOnClickListener {
                textCook.text = "gal "
                cookNameText.text = "IMP Gallon"
                cook2Text.text = "00"
                CookText.text = "00"
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
        cook2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@CookingCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_cooking,
                findViewById(R.id.bottomSheetCooking)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.mililiter).setOnClickListener {
                text2Cook.text = "mil"
                cook2NameText.text = "Mililiter"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_teaspoon).setOnClickListener {
                text2Cook.text = "tsp"
                cook2NameText.text = "US Teaspoon"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_tablespoon).setOnClickListener {
                text2Cook.text = "tbsp"
                cook2NameText.text = "US Tablespoon"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_cup).setOnClickListener {
                text2Cook.text = "c"
                cook2NameText.text = "US Cup"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_teaspoon).setOnClickListener {
                text2Cook.text = "tsp "
                cook2NameText.text = "IMP Teaspoon"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_tablespoon).setOnClickListener {
                text2Cook.text = "tbsp "
                cook2NameText.text = "IMP Tablespoon"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_cup).setOnClickListener {
                text2Cook.text = "c "
                cook2NameText.text = "IMP Cup"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.liter).setOnClickListener {
                text2Cook.text = "l"
                cook2NameText.text = "Liter"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_ounce).setOnClickListener {
                text2Cook.text = "oz"
                cookNameText.text = "US Ounce"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_pint).setOnClickListener {
                text2Cook.text = "pt"
                cook2NameText.text = "US Pint"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_quart).setOnClickListener {
                text2Cook.text = "qt"
                cook2NameText.text = "US Quart"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gallon).setOnClickListener {
                text2Cook.text = "gal"
                cook2NameText.text = "US Gallon"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_ounce).setOnClickListener {
                text2Cook.text = "oz "
                cook2NameText.text = "IMP Ounce"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_pint).setOnClickListener {
                text2Cook.text = "pt "
                cook2NameText.text = "IMP Pint"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_quart).setOnClickListener {
                text2Cook.text = "qt "
                cook2NameText.text = "IMP Quart"
                cook2Text.text = "00"
                CookText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_gallon).setOnClickListener {
                text2Cook.text = "gal "
                cook2NameText.text = "IMP Gallon"
                cook2Text.text = "00"
                CookText.text = "00"
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
        CookText.setOnClickListener {
            cooktext=true
            cook2text=false
            dotPressed=false
            CookText.setTextColor(colorYellow)
            cook2Text.setTextColor(colorGrey)
            cook2Text.text="00"
            CookText.text="00"
        }
        cook2Text.setOnClickListener {
            cooktext=false
            cook2text=true
            dotPressed2=false
            CookText.setTextColor(colorGrey)
            cook2Text.setTextColor(colorYellow)
            CookText.text="00"
            cook2Text.text="00"
        }

    }
    fun onDigitClick(view: View){
        if(cooktext){
            if(CookText.text.toString()=="00"){
                CookText.text=""
            }
            if (stateEror){
                CookText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    CookText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    CookText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(cook2Text.text.toString()=="00"){
                cook2Text.text=""
            }
            if (stateEror){
                cook2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    cook2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    cook2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(cooktext){
            CookText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            cook2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(cooktext){
            if (CookText.text.toString().isNotEmpty()) {
                val lastChar = CookText.text.toString()[CookText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                CookText.text = CookText.text.toString().dropLast(1)
            }
            if(CookText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (cook2Text.text.toString().isNotEmpty()) {
                val lastChar = cook2Text.text.toString()[cook2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                cook2Text.text = cook2Text.text.toString().dropLast(1)
            }
            if(cook2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(cooktext){
            var inputSize=0.0
            if(CookText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=CookText.text.toString().toDouble()
            }
            var inputUnit=textCook.text.toString()
            var outputUnit=text2Cook.text.toString()
            var outputSize=convertCooking(inputSize,outputUnit,inputUnit).toString()
            cook2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (cook2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=cook2Text.text.toString().toDouble()
            }
            var inputUnit=text2Cook.text.toString()
            var outputUnit=textCook.text.toString()
            var outputArea=convertCooking(inputSize,outputUnit,inputUnit).toString()
            CookText.text=outputArea
        }



    }

    fun convertCooking(value: Double, fromUnit: String, toUnit: String): Double {
        val angleMap = mapOf(
            "ml" to 1.0,
            "tsp" to 0.2,
            "tbsp" to 0.07,
            "c" to 0.004227,
            "tsp " to 0.17,
            "tbsp " to 0.06,
            "c " to 0.00352,
            "l" to 0.001,
            "oz" to 0.03,
            "pt" to 0.002113,
            "qt" to 0.001057,
            "gal" to 0.000264,
            "oz " to 0.04,
            "pt " to 0.00176,
            "qt " to 0.00088,
            "gal " to 0.00022
        )

        val conversionFactor = angleMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor
        val toConversionFactor = angleMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor
    }

}