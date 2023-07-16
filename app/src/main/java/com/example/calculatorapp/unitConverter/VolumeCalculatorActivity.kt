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
import kotlinx.android.synthetic.main.activity_volume_calculator.*
import kotlinx.android.synthetic.main.activity_volume_calculator.backButton
import kotlinx.android.synthetic.main.activity_volume_calculator.btn_AC

class VolumeCalculatorActivity : AppCompatActivity() {
    var volumetext = true
    var volume2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume_calculator)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        volumeSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@VolumeCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_volume,
                findViewById(R.id.bottomSheetVolume)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.meter_3).setOnClickListener {
                textVolume.text = "m³"
                volumeNameText.text = "Meter³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.liter).setOnClickListener {
                textVolume.text = "l"
                volumeNameText.text = "Liter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_3).setOnClickListener {
                textVolume.text = "ft³"
                volumeNameText.text = "Foot³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gal).setOnClickListener {
                textVolume.text = "gal"
                volumeNameText.text = "US Gallon"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_gal).setOnClickListener {
                textVolume.text = "gal "
                volumeNameText.text = "IMP Gallon"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.nm_3).setOnClickListener {
                textVolume.text = "nm³"
                volumeNameText.text = "Nanometer³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.μm_3).setOnClickListener {
                textVolume.text = "μm³"
                volumeNameText.text = "Micrometer³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mm_3).setOnClickListener {
                textVolume.text = "mm³"
                volumeNameText.text = "Millimeter³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.cm_3).setOnClickListener {
                textVolume.text = "cm³"
                volumeNameText.text = "Centimeter³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dm_3).setOnClickListener {
                textVolume.text = "dm³"
                volumeNameText.text = "Decimeter³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dkm_3).setOnClickListener {
                textVolume.text = "dkm³"
                volumeNameText.text = "Dekameter³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.hm_3).setOnClickListener {
                textVolume.text = "hm³"
                volumeNameText.text = "Hectometer³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.km_3).setOnClickListener {
                textVolume.text = "km³"
                volumeNameText.text = "Kilometer³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.nl).setOnClickListener {
                textVolume.text = "nl"
                volumeNameText.text = "Nanoliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.μl).setOnClickListener {
                textVolume.text = "μl"
                volumeNameText.text = "Microliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ml).setOnClickListener {
                textVolume.text = "ml"
                volumeNameText.text = "Milliliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.cl).setOnClickListener {
                textVolume.text = "cl"
                volumeNameText.text = "Centiliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dl).setOnClickListener {
                textVolume.text = "dl"
                volumeNameText.text = "Deciliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dkl).setOnClickListener {
                textVolume.text = "dkl"
                volumeNameText.text = "Dekaliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.hl).setOnClickListener {
                textVolume.text = "hl"
                volumeNameText.text = "Hectoliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kl).setOnClickListener {
                textVolume.text = "kl"
                volumeNameText.text = "Kiloliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.inch_3).setOnClickListener {
                textVolume.text = "inch³"
                volumeNameText.text = "Inch³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.yard_3).setOnClickListener {
                textVolume.text = "yd³"
                volumeNameText.text = "Yard³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mi_3).setOnClickListener {
                textVolume.text = "mi³"
                volumeNameText.text = "Mile³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_tsp).setOnClickListener {
                textVolume.text = "tsp"
                volumeNameText.text = "US Teaspoon tsp"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_tbsp).setOnClickListener {
                textVolume.text = "tbsp"
                volumeNameText.text = "US Tablespoon tbsp"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_oz).setOnClickListener {
                textVolume.text = "oz"
                volumeNameText.text = "US Ounce"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_c).setOnClickListener {
                textVolume.text = "c"
                volumeNameText.text = "US Cup"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_pt).setOnClickListener {
                textVolume.text = "pt"
                volumeNameText.text = "US Pint"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_qt).setOnClickListener {
                textVolume.text = "qt"
                volumeNameText.text = "US Quart"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_tsp).setOnClickListener {
                textVolume.text = "tsp "
                volumeNameText.text = "IMP Teaspoon"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_tbsp).setOnClickListener {
                textVolume.text = "tbsp "
                volumeNameText.text = "IMP Tablespoon"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_oz).setOnClickListener {
                textVolume.text = "oz "
                volumeNameText.text = "IMP Ounce"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_c).setOnClickListener {
                textVolume.text = "c "
                volumeNameText.text = "IMP Cup"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_pint).setOnClickListener {
                textVolume.text = "pt "
                volumeNameText.text = "IMP Pint"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_qt).setOnClickListener {
                textVolume.text = "qt "
                volumeNameText.text = "IMP Quart"
                volume2Text.text = "00"
                volumeText.text = "00"
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
        volume2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@VolumeCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_volume,
                findViewById(R.id.bottomSheetVolume)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.meter_3).setOnClickListener {
                text2Volume.text = "m³"
                volume2NameText.text = "Meter³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.liter).setOnClickListener {
                text2Volume.text = "l"
                volume2NameText.text = "Liter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ft_3).setOnClickListener {
                text2Volume.text = "ft³"
                volume2NameText.text = "Foot³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_gal).setOnClickListener {
                text2Volume.text = "gal"
                volume2NameText.text = "US Gallon"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ımp_gal).setOnClickListener {
                text2Volume.text = "gal "
                volume2NameText.text = "IMP Gallon"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.nm_3).setOnClickListener {
                text2Volume.text = "nm³"
                volume2NameText.text = "Nanometer³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.μm_3).setOnClickListener {
                text2Volume.text = "μm³"
                volume2NameText.text = "Micrometer³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mm_3).setOnClickListener {
                text2Volume.text = "mm³"
                volume2NameText.text = "Millimeter³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.cm_3).setOnClickListener {
                text2Volume.text = "cm³"
                volume2NameText.text = "Centimeter³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dm_3).setOnClickListener {
                text2Volume.text = "dm³"
                volume2NameText.text = "Decimeter³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dkm_3).setOnClickListener {
                text2Volume.text = "dkm³"
                volume2NameText.text = "Dekameter³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.hm_3).setOnClickListener {
                text2Volume.text = "hm³"
                volume2NameText.text = "Hectometer³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.km_3).setOnClickListener {
                text2Volume.text = "km³"
                volume2NameText.text = "Kilometer³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.nl).setOnClickListener {
                text2Volume.text = "nl"
                volume2NameText.text = "Nanoliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.μl).setOnClickListener {
                text2Volume.text = "μl"
                volume2NameText.text = "Microliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.ml).setOnClickListener {
                text2Volume.text = "ml"
                volume2NameText.text = "Milliliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.cl).setOnClickListener {
                text2Volume.text = "cl"
                volume2NameText.text = "Centiliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dl).setOnClickListener {
                text2Volume.text = "dl"
                volume2NameText.text = "Deciliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.dkl).setOnClickListener {
                text2Volume.text = "dkl"
                volume2NameText.text = "Dekaliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.hl).setOnClickListener {
                text2Volume.text = "hl"
                volume2NameText.text = "Hectoliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.kl).setOnClickListener {
                text2Volume.text = "kl"
                volume2NameText.text = "Kiloliter"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.inch_3).setOnClickListener {
                text2Volume.text = "inch³"
                volume2NameText.text = "Inch³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.yard_3).setOnClickListener {
                text2Volume.text = "yd³"
                volume2NameText.text = "Yard³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.mi_3).setOnClickListener {
                text2Volume.text = "mi³"
                volume2NameText.text = "Mile³"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_tsp).setOnClickListener {
                text2Volume.text = "tsp"
                volume2NameText.text = "US Teaspoon tsp"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_tbsp).setOnClickListener {
                text2Volume.text = "tbsp"
                volume2NameText.text = "US Tablespoon tbsp"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_oz).setOnClickListener {
                text2Volume.text = "oz"
                volume2NameText.text = "US Ounce"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_c).setOnClickListener {
                text2Volume.text = "c"
                volume2NameText.text = "US Cup"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_pt).setOnClickListener {
                text2Volume.text = "pt"
                volume2NameText.text = "US Pint"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.us_qt).setOnClickListener {
                text2Volume.text = "qt"
                volume2NameText.text = "US Quart"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_tsp).setOnClickListener {
                text2Volume.text = "tsp "
                volume2NameText.text = "IMP Teaspoon"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_tbsp).setOnClickListener {
                text2Volume.text = "tbsp "
                volume2NameText.text = "IMP Tablespoon"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_oz).setOnClickListener {
                text2Volume.text = "oz "
                volume2NameText.text = "IMP Ounce"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_c).setOnClickListener {
                text2Volume.text = "c "
                volume2NameText.text = "IMP Cup"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_pint).setOnClickListener {
                text2Volume.text = "pt "
                volume2NameText.text = "IMP Pint"
                volume2Text.text = "00"
                volumeText.text = "00"
                dotPressed2 = false
                dotPressed = false
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.imp_qt).setOnClickListener {
                text2Volume.text = "qt "
                volume2NameText.text = "IMP Quart"
                volume2Text.text = "00"
                volumeText.text = "00"
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
        volumeText.setOnClickListener {
            volumetext=true
            volume2text=false
            dotPressed=false
            volumeText.setTextColor(colorYellow)
            volume2Text.setTextColor(colorGrey)
            volume2Text.text="00"
            volumeText.text="00"
        }
        volume2Text.setOnClickListener {
            volumetext=false
            volume2text=true
            dotPressed2=false
            volumeText.setTextColor(colorGrey)
            volume2Text.setTextColor(colorYellow)
            volumeText.text="00"
            volume2Text.text="00"
        }
    }
    fun onDigitClick(view: View){
        if(volumetext){
            if(volumeText.text.toString()=="00"){
                volumeText.text=""
            }
            if (stateEror){
                volumeText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    volumeText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    volumeText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(volume2Text.text.toString()=="00"){
                volume2Text.text=""
            }
            if (stateEror){
                volume2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    volume2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    volume2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(volumetext){
            volumeText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            volume2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(volumetext){
            if (volumeText.text.toString().isNotEmpty()) {
                val lastChar = volumeText.text.toString()[volumeText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                volumeText.text = volumeText.text.toString().dropLast(1)
            }
            if(volumeText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (volume2Text.text.toString().isNotEmpty()) {
                val lastChar = volume2Text.text.toString()[volume2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                volume2Text.text = volume2Text.text.toString().dropLast(1)
            }
            if(volume2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
    fun onEnterClick(view: View){

        if(volumetext){
            var inputSize=0.0
            if(volumeText.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=volumeText.text.toString().toDouble()
            }
            var inputUnit=textVolume.text.toString()
            var outputUnit=text2Volume.text.toString()
            var outputSize=convertVolume(inputSize,outputUnit,inputUnit).toString()
            volume2Text.text=outputSize
        }else{
            var inputSize=0.0
            if (volume2Text.text.toString()==""){
                inputSize=0.0
            }else{
                inputSize=volume2Text.text.toString().toDouble()
            }
            var inputUnit=text2Volume.text.toString()
            var outputUnit=textVolume.text.toString()
            var outputArea=convertVolume(inputSize,outputUnit,inputUnit).toString()
            volumeText.text=outputArea
        }
    }
    fun convertVolume(value: Double, fromUnit: String, toUnit: String): Double {
        val angleMap = mapOf(
            "m³" to 1.0,
            "l" to 1000,
            "ft³" to 35.31,
            "gal" to 264.17,
            "gal " to 219.97,
            "nm³" to 1.00E27,
            "μm³" to 1.00E18,
            "mm³" to 1000000000,
            "cm³" to 1000000,
            "dm³" to 1000,
            "dkm³" to 0.001,
            "hm³" to 1.00E-6,
            "km³" to 1.00E-9,
            "nl" to 1000000000000,
            "μl" to 1000000000,
            "ml" to 1000000,
            "cl" to 100000,
            "dl" to 10000,
            "dkl" to 100,
            "hl" to 10,
            "kl" to 1,
            "in³" to 61023.74,
            "yd³" to 1.31,
            "mi³" to 2.40E-10,
            "tsp" to 202884.14,
            "tbsp" to 67628.05,
            "oz" to 33814.02,
            "c" to 4226.75,
            "pt" to 2113.88,
            "qt" to 1056.69,
            "tsp " to 168936.38,
            "tbsp " to 56312.13,
            "oz " to 35195.08,
            "c " to 3519.51,
            "pt " to 1759.75,
            "qt " to 879.88
        )

        val conversionFactor = angleMap[fromUnit] ?: return -1.0
        val convertedValue = value * conversionFactor.toDouble()
        val toConversionFactor = angleMap[toUnit] ?: return -1.0

        return convertedValue / toConversionFactor.toDouble()
    }
}