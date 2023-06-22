package com.example.calculatorapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_percentage_calculate.*
import kotlinx.android.synthetic.main.activity_percentage_calculate.backButton
import kotlinx.android.synthetic.main.activity_percentage_calculate.linearLayout2
import kotlinx.android.synthetic.main.dialog_percentage_solutions.view.*

class PercentageCalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var a=0.0
        var b=0.0
        var answer=""
        var answer_=""
        var solutions=""
        var vis=false
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_percentage_calculate)
        backButton.setOnClickListener {
            finish()
        }
        perSelect.setOnClickListener {

            val bottomSheet =
                BottomSheetDialog(this@PercentageCalculateActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_percentage,
                findViewById(R.id.bottomSheetPer)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.discount).setOnClickListener {
                per_cal_name.text = "Discount"
                per_procces.text="a - b% = x"
                yuzde.text="%"
                per_image.setImageResource(R.drawable.baseline_percent_24)
                vis=true
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.increase).setOnClickListener {
                per_cal_name.text = "Increase"
                per_procces.text="a + b% = x"
                yuzde.text="%"
                per_image.setImageResource(R.drawable.increase)
                vis=true
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.simple_percenatge).setOnClickListener {
                per_cal_name.text = "Simple Percentage"
                per_procces.text="a x b% = x"
                yuzde.text="%"
                per_image.setImageResource(R.drawable.baseline_percent_24)
                vis=false
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.increaseDiscount).setOnClickListener {
                per_cal_name.text = "Increase/Discount"
                per_procces.text="a → b = x%"
                yuzde.text=""
                per_image.setImageResource(R.drawable.baseline_percent_24)
                vis=false
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.percentage_of).setOnClickListener {
                per_cal_name.text = "Percentage of A from B"
                per_procces.text="a ← b = x%"
                yuzde.text=""
                per_image.setImageResource(R.drawable.baseline_percent_24)
                vis=false
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.show()
        }



            linearLayout2.setOnClickListener {


                if(A_value.text.toString()==""){
                    a=0.0
                }else{
                    a = A_value.text.toString().toDouble()
                }
                if(B_value.text.toString()==""){
                    b=0.0
                }else{
                    b=B_value.text.toString().toDouble()
                }
                if(per_cal_name.text == "Discount"){
                    var cevap=a-((a*b)/100).toDouble()
                    var cevap2=((a*b)/100).toDouble()
                    answer_=cevap2.toString()
                    answer=cevap.toString()
                    solutions="$a - $b% =x\nx = $a - ($a x $b) / 100\n = $a - ${a*b}/100\n= $a - ${(a*b)/100}\n= $cevap"

                }
                if(per_cal_name.text == "Increase"){
                    var cevap=a+((a*b)/100).toDouble()
                    answer=cevap.toString()
                    var cevap2=((a*b)/100).toDouble()
                    answer_=cevap2.toString()
                    solutions="$a + $b% =x\nx = $a + ($a x $b) / 100\n = $a + ${a*b}/100\n= $a + ${(a*b)/100}\n= $cevap"

                }
                if(per_cal_name.text == "Simple Percentage"){
                    var cevap=((a*b)/100).toDouble()
                    answer=cevap.toString()
                    solutions="$a x $b% =x\nx = ($a x $b) / 100\n = ${a*b}/100\n= ${(a*b)/100}\n= $cevap"
                }
                if(per_cal_name.text == "Increase/Discount"){
                    var cevap=((b*100)/a)-100.toDouble()
                    answer=cevap.toString()
                    solutions="$a → $b% =x\nx = ($b x 100) / $a - 100\n =${b*100}/$a - 100\n= ${((b*100)/a)} - 100\n= $cevap %"

                }
                if(per_cal_name.text == "Percentage of A from B"){
                    var cevap=((a*100)/b).toDouble()
                    answer=cevap.toString()
                    solutions="$a ← $b% =x\nx = ($a x 100) / $b\n =${a*100}/$b\n= $cevap %"

                }
                val view = View.inflate(this, R.layout.dialog_percentage_solutions, null)
                val builder = AlertDialog.Builder(this)
                builder.setView(view)
                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                view.cancel.setOnClickListener {
                    dialog.dismiss()
                }
                if(vis){
                    view.inc_dec.visibility=View.VISIBLE
                    view.answer.text=answer
                    view.answer_.text=answer_
                    view.dialog_solutions.text=solutions
                    if(per_cal_name.text == "Discount"){
                        view.select.text="↓"
                    }else{
                        view.select.text="↑"
                    }
                }else{
                    view.answer.text=answer
                    view.dialog_solutions.text=solutions
                }
            }


    }
}