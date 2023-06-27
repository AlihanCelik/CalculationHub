package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_shapes_calculator.*
import kotlinx.android.synthetic.main.activity_shapes_calculator.backButton
import kotlinx.android.synthetic.main.activity_shapes_calculator.linearLayout2
import kotlinx.android.synthetic.main.activity_shapes_calculator.method

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
                B_layout.visibility=View.VISIBLE
                A_string.text="Side A"
                B_string.text="Side B"
                x_string.text="Side C"
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.rightTriengle).setOnClickListener {
                shapes_cal_name.text="Right Triangle"
                shapes_image.setImageResource(R.drawable.righttriangle)
                method.setImageResource(R.drawable.righttriangle)
                visi.visibility=View.GONE
                A_string.text="Side A"
                B_layout.visibility=View.VISIBLE
                B_string.text="Side B"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.square).setOnClickListener {
                shapes_cal_name.text="Square"
                shapes_image.setImageResource(R.drawable.square)
                method.setImageResource(R.drawable.square)
                visi.visibility=View.GONE
                A_string.text="Side"
                B_layout.visibility=View.GONE
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.rectangle).setOnClickListener {
                shapes_cal_name.text="Rectangle"
                shapes_image.setImageResource(R.drawable.rectangle)
                method.setImageResource(R.drawable.rectangle)
                visi.visibility=View.GONE
                A_string.text="Side A"
                B_layout.visibility=View.VISIBLE
                B_string.text="Side B"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.trapezoid).setOnClickListener {
                shapes_cal_name.text="Trapezoid"
                shapes_image.setImageResource(R.drawable.trapezoid)
                method.setImageResource(R.drawable.trapezoid)
                visi.visibility=View.VISIBLE
                A_string.text="Side A"
                B_layout.visibility=View.VISIBLE
                B_string.text="Side B"
                x_string.text="Height"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.rhombus).setOnClickListener {
                shapes_cal_name.text="Rhombus"
                shapes_image.setImageResource(R.drawable.rhombus)
                method.setImageResource(R.drawable.rhombus)
                visi.visibility=View.GONE
                A_string.text="Side A"
                B_layout.visibility=View.VISIBLE
                B_string.text="Side B"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.pentagon).setOnClickListener {
                shapes_cal_name.text="Pentagon"
                shapes_image.setImageResource(R.drawable.pentagon)
                method.setImageResource(R.drawable.pentagon)
                visi.visibility= View.GONE
                A_string.text="Side A"
                B_layout.visibility=View.GONE

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.hexagon).setOnClickListener {
                shapes_cal_name.text="Hexagon"
                shapes_image.setImageResource(R.drawable.hexagon)
                method.setImageResource(R.drawable.hexagon)
                visi.visibility=View.GONE
                A_string.text="Side A"
                B_layout.visibility=View.GONE

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.circle).setOnClickListener {
                shapes_cal_name.text="Circle"
                shapes_image.setImageResource(R.drawable.circle)
                method.setImageResource(R.drawable.circle)
                visi.visibility=View.GONE
                A_string.text="Radius"
                B_layout.visibility=View.GONE

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.circleArc).setOnClickListener {
                shapes_cal_name.text="Circle Arc"
                shapes_image.setImageResource(R.drawable.arc)
                method.setImageResource(R.drawable.arc)
                visi.visibility=View.GONE
                A_string.text="Angle"
                B_layout.visibility=View.VISIBLE
                B_string.text="Radius"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.ellipse).setOnClickListener {
                shapes_cal_name.text="Ellipse"
                shapes_image.setImageResource(R.drawable.ellipse)
                method.setImageResource(R.drawable.ellipse)
                visi.visibility=View.GONE
                A_string.text="Radius A"
                B_layout.visibility=View.VISIBLE
                B_string.text="Radius B"

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
        linearLayout2.setOnClickListener {
            if(A_value.text.toString()==""){
                a=0.0
            }else{
                a=A_value.text.toString().toDouble()
            }
            if(B_value.text.toString()==""){
                b=0.0
            }else{
                b=B_value.text.toString().toDouble()
            }
            if(x_value.text.toString()==""){
                c=0.0
            }else{
                c=x_value.text.toString().toDouble()
            }

            if(shapes_cal_name.text=="Triangle"){

            }

            if(shapes_cal_name.text=="Right Triangle"){

            }

            if(shapes_cal_name.text=="Square"){

            }

            if(shapes_cal_name.text=="Rectangle"){

            }

            if(shapes_cal_name.text=="Trapezoid"){

            }

            if(shapes_cal_name.text=="Rhombus"){

            }

            if(shapes_cal_name.text=="Pentagon"){

            }

            if(shapes_cal_name.text=="Hexagon"){

            }

            if(shapes_cal_name.text=="Circle"){

            }

            if(shapes_cal_name.text=="Circle Arc"){

            }

            if(shapes_cal_name.text=="Ellipse"){

            }





        }
    }
}