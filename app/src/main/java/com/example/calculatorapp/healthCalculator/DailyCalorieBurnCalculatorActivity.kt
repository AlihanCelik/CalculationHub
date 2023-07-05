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
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.*
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.backButton
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.female
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.girlImage
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.girlText
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.heigh_value
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.heightSelect
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.linearLayout2
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.male
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.manImage
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.manText
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.seekbarforage
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.textAge
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.viewHeight
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.viewWeight
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.weightSelect
import kotlinx.android.synthetic.main.activity_daily_calorie_burn_calculator.weight_value
import kotlinx.android.synthetic.main.dialog_dailycalorie_solutions.view.*

class DailyCalorieBurnCalculatorActivity : AppCompatActivity() {
    var girl = false
    var man = false
    var heightvalue = 0.0
    var weightvalue = 0.0
    var lifestyle="Sedentary"
    var gender=""
    var agevalue = 20
    var dailyvalue = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_calorie_burn_calculator)
        backButton.setOnClickListener {
            finish()
        }
        weightSelect.setOnClickListener {

            val bottomSheet =
                BottomSheetDialog(this@DailyCalorieBurnCalculatorActivity,
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
                BottomSheetDialog(this@DailyCalorieBurnCalculatorActivity,
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

        lifestyleSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(this@DailyCalorieBurnCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext)
                .inflate(
                    R.layout.bottom_sheet_lifestyle,
                    findViewById(R.id.bottomSheetLifestyle)
                ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.sedentary).setOnClickListener {
                lifestyle_value.text="Sedentary"
                lifestyle="Sedentary"

                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.lightly_active).setOnClickListener {
                lifestyle_value.text="Lightly Active"
                lifestyle="Lightly Active"

                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.moderately_active).setOnClickListener {
                lifestyle_value.text="Moderately Active"
                lifestyle="Moderately Active"

                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.very_active).setOnClickListener {
                lifestyle_value.text="Very Active"
                lifestyle="Very Active"

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
                dailyvalue=calculateDailyCalorieBurn(agevalue,(heightvalue/100),weightvalue,gender,lifestyle)

                val view = View.inflate(this, R.layout.dialog_dailycalorie_solutions, null)
                val builder = AlertDialog.Builder(this)
                builder.setView(view)
                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                view.cancel.setOnClickListener {
                    dialog.dismiss()
                }
                view.kcalText.text=dailyvalue.toString()

            }
        }

    }
    fun calculateDailyCalorieBurn(age: Int,height:Double,weight:Double,gender:String,lifestyle:String): Double {

        val bmr: Double
        when (gender) {
            "man" -> bmr = 66.47 + (13.75 * weight) + (5.003 * height * 100) - (6.755 * age)
            "girl" -> bmr = 655.1 + (9.563 * weight) + (1.850 * height * 100) - (4.676 * age)
            else -> bmr = 0.0
        }

        val activityMultiplier: Double = when (lifestyle) {
            "Sedentary" -> 1.2
            "Lightly Active" -> 1.375
            "Moderately Active" -> 1.55
            "Very Active" -> 1.725
            else -> 1.0
        }

        val dailyCalorieBurn = bmr * activityMultiplier

        return dailyCalorieBurn
    }
}