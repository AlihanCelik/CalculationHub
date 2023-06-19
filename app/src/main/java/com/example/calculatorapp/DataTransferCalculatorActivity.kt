package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_data_transfer_calculator.*
import kotlinx.android.synthetic.main.activity_data_transfer_calculator.backButton
import kotlinx.android.synthetic.main.activity_data_transfer_calculator.btn_AC

class DataTransferCalculatorActivity : AppCompatActivity() {
    var transtext = true
    var trans2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_transfer_calculator)
        backButton.setOnClickListener {
            finish()
        }
        transSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@DataTransferCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_datatransfer,
                findViewById(R.id.bottomSheetDataTransfer)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.mb_s).setOnClickListener {
                textTrans.text = "Mb/s"
                transNameText.text = "Megabit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gb_s).setOnClickListener {
                textTrans.text = "Gb/s"
                transNameText.text = "Gigabit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.MB_s).setOnClickListener {
                textTrans.text = "MB/s"
                transNameText.text = "Megabyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.GB_s).setOnClickListener {
                textTrans.text = "GB/s"
                transNameText.text = "Gigabyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.b_s).setOnClickListener {
                textTrans.text = "b/s"
                transNameText.text = "Bit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.MiB_s).setOnClickListener {
                textTrans.text = "MiB/s"
                transNameText.text = "Mebibyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Kb_s).setOnClickListener {
                textTrans.text = "Kb/s"
                transNameText.text = "Kilobit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.KiB_s).setOnClickListener {
                textTrans.text = "KiB/s"
                transNameText.text = "Kibibit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Mib_s).setOnClickListener {
                textTrans.text = "Mib/s"
                transNameText.text = "Mebibit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Gib_s).setOnClickListener {
                textTrans.text = "Gib/s"
                transNameText.text = "Gibibit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Tb_s).setOnClickListener {
                textTrans.text = "Tb/s"
                transNameText.text = "Terabit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Tib_s).setOnClickListener {
                textTrans.text = "Tib/s"
                transNameText.text = "Tebibit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Pb_s).setOnClickListener {
                textTrans.text = "Pb/s"
                transNameText.text = "Petabit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Pib_s).setOnClickListener {
                textTrans.text = "Pib/s"
                transNameText.text = "Pebibit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.B_s).setOnClickListener {
                textTrans.text = "B/s"
                transNameText.text = "Byte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.KB_s).setOnClickListener {
                textTrans.text = "KB/s"
                transNameText.text = "Kilobyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.KiB_s).setOnClickListener {
                textTrans.text = "KiB/s"
                transNameText.text = "Kibibyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.GiB_s).setOnClickListener {
                textTrans.text = "GiB/s"
                transNameText.text = "Gibibyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.TiB_s).setOnClickListener {
                textTrans.text = "TiB/s"
                transNameText.text = "Tebibyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.TB_s).setOnClickListener {
                textTrans.text = "TB/s"
                transNameText.text = "Terabyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.PB_s).setOnClickListener {
                textTrans.text = "PB/s"
                transNameText.text = "Petabyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.PiB_s).setOnClickListener {
                textTrans.text = "PiB/s"
                transNameText.text = "Pebibyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
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
        trans2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@DataTransferCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_datatransfer,
                findViewById(R.id.bottomSheetDataTransfer)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.mb_s).setOnClickListener {
                text2Trans.text = "Mb/s"
                trans2NameText.text = "Megabit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.gb_s).setOnClickListener {
                text2Trans.text = "Gb/s"
                trans2NameText.text = "Gigabit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.MB_s).setOnClickListener {
                text2Trans.text = "MB/s"
                trans2NameText.text = "Megabyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.GB_s).setOnClickListener {
                text2Trans.text = "GB/s"
                trans2NameText.text = "Gigabyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.b_s).setOnClickListener {
                text2Trans.text = "b/s"
                trans2NameText.text = "Bit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.MiB_s).setOnClickListener {
                text2Trans.text = "MiB/s"
                trans2NameText.text = "Mebibyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Kb_s).setOnClickListener {
                text2Trans.text = "Kb/s"
                trans2NameText.text = "Kilobit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.KiB_s).setOnClickListener {
                text2Trans.text = "KiB/s"
                trans2NameText.text = "Kibibit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Mib_s).setOnClickListener {
                text2Trans.text = "Mib/s"
                trans2NameText.text = "Mebibit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Gib_s).setOnClickListener {
                text2Trans.text = "Gib/s"
                trans2NameText.text = "Gibibit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Tb_s).setOnClickListener {
                text2Trans.text = "Tb/s"
                trans2NameText.text = "Terabit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Tib_s).setOnClickListener {
                text2Trans.text = "Tib/s"
                trans2NameText.text = "Tebibit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Pb_s).setOnClickListener {
                text2Trans.text = "Pb/s"
                trans2NameText.text = "Petabit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Pib_s).setOnClickListener {
                text2Trans.text = "Pib/s"
                trans2NameText.text = "Pebibit/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.B_s).setOnClickListener {
                text2Trans.text = "B/s"
                trans2NameText.text = "Byte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.KB_s).setOnClickListener {
                text2Trans.text = "KB/s"
                trans2NameText.text = "Kilobyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.KiB_s).setOnClickListener {
                text2Trans.text = "KiB/s"
                trans2NameText.text = "Kibibyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.GiB_s).setOnClickListener {
                text2Trans.text = "GiB/s"
                trans2NameText.text = "Gibibyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.TiB_s).setOnClickListener {
                text2Trans.text = "TiB/s"
                trans2NameText.text = "Tebibyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.TB_s).setOnClickListener {
                text2Trans.text = "TB/s"
                trans2NameText.text = "Terabyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.PB_s).setOnClickListener {
                text2Trans.text = "PB/s"
                trans2NameText.text = "Petabyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.PiB_s).setOnClickListener {
                text2Trans.text = "PiB/s"
                trans2NameText.text = "Pebibyte/Second"
                trans2Text.text = "00"
                transText.text = "00"
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
        transText.setOnClickListener {
            transtext=true
            trans2text=false
            dotPressed=false
            transText.setTextColor(colorYellow)
            trans2Text.setTextColor(colorGrey)
            trans2Text.text="00"
            transText.text="00"
        }
        trans2Text.setOnClickListener {
            transtext=false
            trans2text=true
            dotPressed2=false
            transText.setTextColor(colorGrey)
            trans2Text.setTextColor(colorYellow)
            transText.text="00"
            trans2Text.text="00"
        }
    }

    fun onDigitClick(view: View){
        if(transtext){
            if(transText.text.toString()=="00"){
                transText.text=""
            }
            if (stateEror){
                transText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    transText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    transText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(trans2Text.text.toString()=="00"){
                trans2Text.text=""
            }
            if (stateEror){
                trans2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    trans2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    trans2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(transtext){
            transText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            trans2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(transtext){
            if (transText.text.toString().isNotEmpty()) {
                val lastChar = transText.text.toString()[transText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                transText.text = transText.text.toString().dropLast(1)
            }
            if(transText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (trans2Text.text.toString().isNotEmpty()) {
                val lastChar = trans2Text.text.toString()[trans2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                trans2Text.text = trans2Text.text.toString().dropLast(1)
            }
            if(trans2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(transtext){
            var inputSize=0.0
            if(transText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=transText.text.toString().toDouble()
            }
            var inputUnit=textTrans.text.toString()
            var outputUnit=text2Trans.text.toString()
            var outputSize=convertDataTransfer(inputSize,outputUnit,inputUnit).toString()
            trans2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (trans2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=trans2Text.text.toString().toDouble()
            }
            var inputUnit=text2Trans.text.toString()
            var outputUnit=textTrans.text.toString()
            var outputArea=convertDataTransfer(inputSize,outputUnit,inputUnit).toString()
            transText.text=outputArea
        }



    }

    fun convertDataTransfer(value: Double, fromUnit: String, toUnit: String): Double {
        val angleMap = mapOf(
            "Mb/s" to 1.0,
            "Gb/s" to 0.001,
            "MB/s" to 0.12,
            "GB/s" to 0.000125,
            "b/s" to 1000000,
            "MiB/s" to 0.12,
            "Kb/s" to 1000,
            "Kib/s" to 975.56,
            "Mib/s" to 0.95,
            "Gib/s" to 0.000931,
            "Tb/s" to 1.00E-6,
            "Tib/s" to 9.09E-7,
            "Pb/s" to 1.00E-9,
            "Pib/s" to 8.88E-10,
            "B/s" to 125000,
            "KB/s" to 125,
            "KiB/s" to 122.07,
            "GiB/s" to 0.000116,
            "TB/s" to 1.25E-7,
            "TiB/s" to 1.14E-7,
            "PB/s" to 1.25E-10,
            "PiB/s" to 1.11E-10
        )

        val conversionFactor = angleMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor
        val toConversionFactor = angleMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor
    }
}


