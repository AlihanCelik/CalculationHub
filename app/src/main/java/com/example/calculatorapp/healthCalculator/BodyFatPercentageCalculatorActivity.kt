package com.example.calculatorapp.healthCalculator

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.backButton
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.female
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.girlImage
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.girlText
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.heigh_value
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.heightSelect
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.linearLayout2
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.male
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.manImage
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.manText
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.seekbarforage
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.textAge
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.viewHeight
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.viewWeight
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.weightSelect
import kotlinx.android.synthetic.main.activity_body_fat_percentage_calculator.weight_value
import kotlinx.android.synthetic.main.dialog_bodyfat_solutions.view.*

class BodyFatPercentageCalculatorActivity : AppCompatActivity() {
    var girl = false
    var man = false
    var heightvalue = 0.0
    var weightvalue = 0.0
    var agevalue = 20
    var bodyFatvalue = 0.0
    var gender=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_body_fat_percentage_calculator)
        backButton.setOnClickListener {
            finish()
        }
        weightSelect.setOnClickListener {

            val bottomSheet =
                BottomSheetDialog(this@BodyFatPercentageCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet,
                findViewById(R.id.bottomSheet)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.kg).setOnClickListener {
                viewWeight.text = "kg"
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.pound).setOnClickListener {
                viewWeight.text = "lb"
                bottomSheet.dismiss()

            }


            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }

        heightSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@BodyFatPercentageCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext)
                .inflate(
                    R.layout.bottom_sheet_height,
                    findViewById(R.id.bottomSheet)
                ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.cm).setOnClickListener {
                viewHeight.text = "cm"

                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.metre).setOnClickListener {
                viewHeight.text = "m"
                val minValue = 0.5
                val maxValue = 2.5
                val stepSize = 0.1

                val floatValues = arrayListOf<String>()

                var currentValue = minValue
                while (currentValue <= maxValue) {
                    floatValues.add(String.format("%.1f", currentValue))
                    currentValue += stepSize
                }

                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.fit).setOnClickListener {
                viewHeight.text = "ft"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.inch).setOnClickListener {
                viewHeight.text = "in"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()
            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }
        male.setOnClickListener {
            val color = resources.getColor(R.color.yellow)
            val color2 = resources.getColor(R.color.grey)
            manImage.setColorFilter(color)
            manText.setTextColor(color)
            girlImage.setColorFilter(color2)
            girlText.setTextColor(color2)
            man = true
            girl = false
            gender="man"
        }

        female.setOnClickListener {
            val color2 = resources.getColor(R.color.yellow)
            val color = resources.getColor(R.color.grey)
            manImage.setColorFilter(color)
            manText.setTextColor(color)
            girlImage.setColorFilter(color2)
            girlText.setTextColor(color2)
            girl = true
            man = false
            gender="girl"
        }
        seekbarforage.max = 130
        seekbarforage.progress = 0
        seekbarforage.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val progres: String = progress.toString()
                textAge.text = progres
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        linearLayout2.setOnClickListener {
            if (!man && !girl) {
                Toast.makeText(this, "Select Your Gender First", Toast.LENGTH_SHORT).show();
            } else if (heigh_value.text.toString() == "") {
                Toast.makeText(this, "Height is Incorrect", Toast.LENGTH_SHORT).show();
            } else if (weight_value.text.toString() == "") {
                Toast.makeText(this, "Weight is Incorrect", Toast.LENGTH_SHORT).show();
            } else {
                if (viewHeight.text.toString() == "cm") {
                    heightvalue = heigh_value.text.toString().toDouble()
                } else if (viewHeight.text.toString() == "m") {
                    var text = heigh_value.text.toString().toDouble()
                    text *= 100
                    heightvalue = text
                } else if (viewHeight.text.toString() == "ft") {
                    var text = heigh_value.text.toString().toDouble()
                    text *= 30.48
                    heightvalue = text
                } else {
                    var text = heigh_value.text.toString().toDouble()
                    text *= 2.54
                    heightvalue = text
                }

                if (viewWeight.text.toString() == "kg") {
                    var text = weight_value.text.toString().toDouble()
                    weightvalue = text
                } else {
                    var text = weight_value.text.toString().toDouble()
                    text *= 0.453
                    weightvalue = text

                }
                agevalue = textAge.text.toString().toInt()
                bodyFatvalue=calculateBodyFatPercentage(agevalue,(heightvalue/100),weightvalue,gender)

                val view = View.inflate(this, R.layout.dialog_bodyfat_solutions, null)
                val builder = AlertDialog.Builder(this)
                builder.setView(view)
                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                view.cancel.setOnClickListener {
                    dialog.dismiss()
                }
                view.kcalText.text=bodyFatvalue.toString()

            }
        }
    }
    fun calculateBodyFatPercentage(age:Int,height:Double,weight:Double,gender:String): Double {

        val bodyFatPercentage: Double
        when (gender) {
            "man" -> {
                val bmi = weight / (height * height)
                bodyFatPercentage = (1.2 * bmi) + (0.23 * age) - 16.2
            }
            "girl" -> {
                val bmi = weight / (height * height)
                bodyFatPercentage = (1.2 * bmi) + (0.23 * age) - 5.4
            }
            else -> bodyFatPercentage = 0.0
        }


        return bodyFatPercentage
    }
}