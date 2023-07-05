package com.example.calculatorapp.unitConverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_angle_calculator.*
import kotlinx.android.synthetic.main.activity_angle_calculator.backButton
import kotlinx.android.synthetic.main.activity_angle_calculator.btn_AC

class AngleCalculatorActivity : AppCompatActivity() {
    var angletext = true
    var angle2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angle_calculator)
        backButton.setOnClickListener {
            finish()
        }
        angleSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@AngleCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_angle,
                findViewById(R.id.bottomSheetAngle)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.radian).setOnClickListener {
                textAngle.text = "Rad"
                angleNameText.text = "Radian"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.degree).setOnClickListener {
                textAngle.text = "Deg"
                angleNameText.text = "Degree"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.minute).setOnClickListener {
                textAngle.text = "Min"
                angleNameText.text = "Minute"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.second).setOnClickListener {
                textAngle.text = "Sec"
                angleNameText.text = "Second"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.sextant).setOnClickListener {
                textAngle.text = "60°"
                angleNameText.text = "Sextant"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quadrant).setOnClickListener {
                textAngle.text = "90°"
                angleNameText.text = "Quandrant"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.circle).setOnClickListener {
                textAngle.text = "360°"
                angleNameText.text = "Circle"
                angle2Text.text = "00"
                angleText.text = "00"
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
        angle2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@AngleCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_angle,
                findViewById(R.id.bottomSheetAngle)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.radian).setOnClickListener {
                text2Angle.text = "Rad"
                angle2NameText.text = "Radian"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.degree).setOnClickListener {
                text2Angle.text = "Deg"
                angle2NameText.text = "Degree"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.minute).setOnClickListener {
                text2Angle.text = "Min"
                angle2NameText.text = "Minute"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.second).setOnClickListener {
                text2Angle.text = "Sec"
                angle2NameText.text = "Second"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.sextant).setOnClickListener {
                text2Angle.text = "60°"
                angle2NameText.text = "Sextant"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quadrant).setOnClickListener {
                text2Angle.text = "90°"
                angle2NameText.text = "Quandrant"
                angle2Text.text = "00"
                angleText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.circle).setOnClickListener {
                text2Angle.text = "360°"
                angle2NameText.text = "Circle"
                angle2Text.text = "00"
                angleText.text = "00"
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

        angleText.setOnClickListener {
            angletext=true
            angle2text=false
            dotPressed=false
            angleText.setTextColor(colorYellow)
            angle2Text.setTextColor(colorGrey)
            angle2Text.text="00"
            angleText.text="00"
        }
        angle2Text.setOnClickListener {
            angletext=false
            angle2text=true
            dotPressed2=false
            angleText.setTextColor(colorGrey)
            angle2Text.setTextColor(colorYellow)
            angleText.text="00"
            angle2Text.text="00"
        }

    }
    fun onDigitClick(view: View){
        if(angletext){
            if(angleText.text.toString()=="00"){
                angleText.text=""
            }
            if (stateEror){
                angleText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    angleText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    angleText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(angle2Text.text.toString()=="00"){
                angle2Text.text=""
            }
            if (stateEror){
                angle2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    angle2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    angle2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(angletext){
            angleText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            angle2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(angletext){
            if (angleText.text.toString().isNotEmpty()) {
                val lastChar = angleText.text.toString()[angleText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                angleText.text = angleText.text.toString().dropLast(1)
            }
            if(angleText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (angle2Text.text.toString().isNotEmpty()) {
                val lastChar = angle2Text.text.toString()[angle2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                angle2Text.text = angle2Text.text.toString().dropLast(1)
            }
            if(angle2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(angletext){
            var inputSize=0.0
            if(angleText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=angleText.text.toString().toDouble()
            }
            var inputUnit=textAngle.text.toString()
            var outputUnit=text2Angle.text.toString()
            var outputSize=convertAngle(inputSize,outputUnit,inputUnit).toString()
            angle2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (angle2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=angle2Text.text.toString().toDouble()
            }
            var inputUnit=text2Angle.text.toString()
            var outputUnit=textAngle.text.toString()
            var outputArea=convertAngle(inputSize,outputUnit,inputUnit).toString()
            angleText.text=outputArea
        }



    }
    fun convertAngle(value: Double, fromUnit: String, toUnit: String): Double {
        val angleMap = mapOf(
            "Rad" to 1.0,
            "Deg" to 57.2958,
            "Min" to 3437.75,
            "Sec" to 206265.0,
            "60°" to 0.9549296586,
            "90°" to 0.64,
            "360°" to 0.16
        )

        val conversionFactor = angleMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor
        val toConversionFactor = angleMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor
    }
}