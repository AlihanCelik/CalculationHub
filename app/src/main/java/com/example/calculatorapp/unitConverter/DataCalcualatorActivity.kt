package com.example.calculatorapp.unitConverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_data_calcualator.*
import kotlinx.android.synthetic.main.activity_data_calcualator.backButton
import kotlinx.android.synthetic.main.activity_data_calcualator.btn_AC


class DataCalcualatorActivity : AppCompatActivity() {
    var datatext = true
    var data2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_calcualator)
        backButton.setOnClickListener {
            finish()
        }
        dataSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@DataCalcualatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_data,
                findViewById(R.id.bottomSheetData)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.byte1).setOnClickListener {
                textData.text="B"
                dataNameText.text="Byte"
                data2Text.text="00"
                dataText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.megabyte).setOnClickListener {
                textData.text="MB"
                dataNameText.text="Megabyte"
                data2Text.text="00"
                dataText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gigabyte).setOnClickListener {
                textData.text="GB"
                dataNameText.text="Gigabyte"
                data2Text.text="00"
                dataText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.terabyte).setOnClickListener {
                textData.text="TB"
                dataNameText.text="Terabyte"
                data2Text.text="00"
                dataText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.petabyte).setOnClickListener {
                textData.text="PB"
                dataNameText.text="Petabyte"
                data2Text.text="00"
                dataText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()

        }
        data2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@DataCalcualatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_data,
                findViewById(R.id.bottomSheetData)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.byte1).setOnClickListener {
                text2Data.text="B"
                data2NameText.text="Byte"
                data2Text.text="00"
                dataText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.megabyte).setOnClickListener {
                text2Data.text="MB"
                data2NameText.text="Megabyte"
                data2Text.text="00"
                dataText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gigabyte).setOnClickListener {
                text2Data.text="GB"
                data2NameText.text="Gigabyte"
                data2Text.text="00"
                dataText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.terabyte).setOnClickListener {
                text2Data.text="TB"
                data2NameText.text="Terabyte"
                data2Text.text="00"
                dataText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.petabyte).setOnClickListener {
                text2Data.text="PB"
                data2NameText.text="Petabyte"
                data2Text.text="00"
                dataText.text="00"
                dotPressed2=false
                dotPressed=false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()

        }
        dataText.setOnClickListener {
            datatext=true
            data2text=false
            dotPressed=false
            dataText.setTextColor(colorYellow)
            data2Text.setTextColor(colorGrey)
            data2Text.text="00"
            dataText.text="00"
        }
        data2Text.setOnClickListener {
            datatext=false
            data2text=true
            dotPressed2=false
            dataText.setTextColor(colorGrey)
            data2Text.setTextColor(colorYellow)
            dataText.text="00"
            data2Text.text="00"
        }

    }
    fun onDigitClick(view: View){
        if(datatext){
            if(dataText.text.toString()=="00"){
                dataText.text=""
            }
            if (stateEror){
                dataText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    dataText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    dataText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(data2Text.text.toString()=="00"){
                data2Text.text=""
            }
            if (stateEror){
                data2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    data2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    data2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(datatext){
            dataText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            data2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(datatext){
            if (dataText.text.toString().isNotEmpty()) {
                val lastChar = dataText.text.toString()[dataText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                dataText.text = dataText.text.toString().dropLast(1)
            }
            if(dataText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (data2Text.text.toString().isNotEmpty()) {
                val lastChar = data2Text.text.toString()[data2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                data2Text.text = data2Text.text.toString().dropLast(1)
            }
            if(data2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(datatext){
            var inputSize=0.0
            if(dataText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=dataText.text.toString().toDouble()
            }
            var inputUnit=textData.text.toString()
            var outputUnit=text2Data.text.toString()
            var outputSize=convertStorage(inputSize,inputUnit,outputUnit).toString()
            data2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (data2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=data2Text.text.toString().toDouble()
            }
            var inputUnit=text2Data.text.toString()
            var outputUnit=textData.text.toString()
            var outputArea=convertStorage(inputSize,inputUnit,outputUnit).toString()
            dataText.text=outputArea
        }



    }
    fun convertStorage(inputSize: Double, inputUnit: String, outputUnit: String): Double {
        val unitConversionMap = mapOf(
            "B" to 1.0,
            "KB" to 1024.0,
            "MB" to 1024.0 * 1024.0,
            "GB" to 1024.0 * 1024.0 * 1024.0,
            "TB" to 1024.0 * 1024.0 * 1024.0 * 1024.0,
            "PB" to 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0
        )
        val inputSizeInBytes = inputSize * unitConversionMap[inputUnit]!!
        val outputSize = inputSizeInBytes / unitConversionMap[outputUnit]!!
        return outputSize
    }
}