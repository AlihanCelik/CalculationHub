package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_ratio_calculaor.view.*
import kotlinx.android.synthetic.main.activity_shapes_calculator.*

class ShapesCalculatorActivity : AppCompatActivity() {
    var a=0.0
    var b=0.0
    var c=0.0
    var answer=""
    var answer_=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shapes_calculator)
        backButton.setOnClickListener {
            finish()
        }
        shapesSelect.setOnClickListener {

            val bottomSheet =
                BottomSheetDialog(this@ShapesCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_shapes,
                findViewById(R.id.bottomSheetShapes)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.triangle).setOnClickListener {
                shapes_cal_name.text="Triangle"
                shapes_image.setImageResource(R.drawable.triangle)
                method.setImageResource(R.drawable.triangle)
                visi.visibility=View.VISIBLE

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
    }
}