package com.example.calculatorapp

import android.app.AlertDialog
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
import kotlinx.android.synthetic.main.dialog_shapes_solutions.view.*
import kotlin.math.acos
import kotlin.math.atan
import kotlin.math.pow
import kotlin.math.sqrt

class ShapesCalculatorActivity : AppCompatActivity() {
    var a=0.0
    var b=0.0
    var c=0.0
    var answer=""
    var answer_=""
    var answer_3=""
    var answer_4=""
    var answer_5=""
    var answer_6=""
    var answer_7=""
    var answer_8=""
    var solution=""
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
                A_string.text="Height A"
                B_layout.visibility=View.VISIBLE
                B_string.text="Height B"

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
                val s = (a + b + c) / 2
                val area = sqrt(s * (s - a) * (s - b) * (s - c))
                val perimeter = a + b + c
                val angleA = Math.toDegrees(acos((b * b + c * c - a * a) / (2 * b * c)))
                val angleB = Math.toDegrees(acos((a * a + c * c - b * b) / (2 * a * c)))
                val angleC = 180 - angleA - angleB
                val heightA = 2 * area / a
                val heightB = 2 * area / b
                val heightC = 2 * area / c
                answer=area.toString()
                answer_=perimeter.toString()
                answer_3= "$angleA˚"
                answer_4= "$angleB˚"
                answer_5= "$angleC˚"
                answer_6=heightA.toString()
                answer_7=heightB.toString()
                answer_8=heightC.toString()
                solution="Side A = $a\nSide B = $b\nSide C = $c\nS = (A + B + C) / 2 \n= ($a + $b + $c) / 2 \n${a + b +c } / 2\nS = ${(a+b+c)/2}\n" +
                        "Area = √(S(S - A)(S - B)(S - C))\n= √(${(a+b+c)/2}(${(a+b+c)/2} - $a)(${(a+b+c)/2} - $b)(${(a+b+c)/2} - $c))\n= √(${(a+b+c)/2} x ${((a+b+c)/2) - a} x ${((a+b+c)/2) - b} x ${((a+b+c)/2) - c})\n= ${(s * (s - a) * (s - b) * (s - c))}\n= $answer\n" +
                        "Perimeter = A + B + C\n= $a + $b + $c\n= $answer_\n"



            }

            if(shapes_cal_name.text=="Right Triangle"){
                val area = 0.5 * a * b
                val hypotenuse = sqrt(a * a + b * b)
                val perimeter = a + b + hypotenuse
                val angleA = Math.toDegrees(atan(b / a))
                val angleB = 90.0 - angleA
                answer=area.toString()
                answer_=perimeter.toString()
                answer_3=hypotenuse.toString()
                answer_4= "$angleA˚"
                answer_5= "$angleB˚"

            }

            if(shapes_cal_name.text=="Square"){
                val area = a * a
                val perimeter = 4 * a
                answer=area.toString()
                answer_=perimeter.toString()
            }

            if(shapes_cal_name.text=="Rectangle"){
                val area = a * b
                val perimeter = 2 * (a+b)
                answer=area.toString()
                answer_=perimeter.toString()

            }

            if(shapes_cal_name.text=="Trapezoid"){
                val area = 0.5 * (a + b) * c
                val perimeter = a + b + 2 * sqrt(((a - b) / 2).pow(2) + c.pow(2))
                answer=area.toString()
                answer_=perimeter.toString()
            }

            if(shapes_cal_name.text=="Rhombus"){
                val d = Math.abs(a - b)
                val x = Math.sqrt(a * b + d * d)
                val area = a * x
                val perimeter = 4 * x
                answer=area.toString()
                answer_=perimeter.toString()
            }

            if(shapes_cal_name.text=="Pentagon"){
                val area = 0.25 * Math.sqrt(5 * (5 + 2 * sqrt(5.0))) * a * a
                val perimeter = 5 * a
                answer=area.toString()
                answer_=perimeter.toString()
            }

            if(shapes_cal_name.text=="Hexagon"){
                val area = (3 * sqrt(3.0) * a * a) / 2
                val perimeter = 6 * a
                answer=area.toString()
                answer_=perimeter.toString()

            }

            if(shapes_cal_name.text=="Circle"){
                val area = Math.PI * a * a
                val circumference = Math.PI * 2*a
                val diameter = 2*a

                answer=area.toString()
                answer_=circumference.toString()
                answer_3=diameter.toString()


            }

            if(shapes_cal_name.text=="Circle Arc"){
                val area = (a / 360) * Math.PI * b * b
                val perimeter = (a / 360) * (2 * Math.PI * b)
                answer=area.toString()
                answer_=perimeter.toString()

            }

            if(shapes_cal_name.text=="Ellipse"){
                val area = Math.PI * a * b
                val perimeter = Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)))
                answer=area.toString()
                answer_=perimeter.toString()

            }
            val view = View.inflate(this, R.layout.dialog_shapes_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            if(shapes_cal_name.text=="Triangle"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.angleA_answer.text=answer_3
                view.angleB_answer.text=answer_4
                view.angleC_answer.text=answer_5
                view.heightA_answer.text=answer_6
                view.heightB_answer.text=answer_7
                view.heightC_answer.text=answer_8
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.VISIBLE
                view.height_layout.visibility=View.VISIBLE
                view.heightB_layout.visibility=View.VISIBLE
                view.heightC_layout.visibility=View.VISIBLE
                view.angleC_layout.visibility=View.VISIBLE
                view.heightA_string.text="Height A"


            }

            if(shapes_cal_name.text=="Right Triangle"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.angleA_answer.text=answer_4
                view.angleB_answer.text=answer_5
                view.heightA_answer.text=answer_3
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.VISIBLE
                view.height_layout.visibility=View.VISIBLE
                view.heightB_layout.visibility=View.GONE
                view.heightC_layout.visibility=View.GONE
                view.angleC_layout.visibility=View.GONE
                view.heightA_string.text="Hypotenuse"

            }

            if(shapes_cal_name.text=="Square"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.GONE
                view.height_layout.visibility=View.GONE
            }

            if(shapes_cal_name.text=="Rectangle"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.GONE
                view.height_layout.visibility=View.GONE

            }

            if(shapes_cal_name.text=="Trapezoid"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.GONE
                view.height_layout.visibility=View.GONE
            }

            if(shapes_cal_name.text=="Rhombus"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.GONE
                view.height_layout.visibility=View.GONE
            }

            if(shapes_cal_name.text=="Pentagon"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.GONE
                view.height_layout.visibility=View.GONE

            }

            if(shapes_cal_name.text=="Hexagon"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.GONE
                view.height_layout.visibility=View.GONE

            }

            if(shapes_cal_name.text=="Circle"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.GONE
                view.height_layout.visibility=View.GONE


            }

            if(shapes_cal_name.text=="Circle Arc"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.GONE
                view.height_layout.visibility=View.GONE

            }
            if(shapes_cal_name.text=="Ellipse"){
                view.area_answer.text=answer
                view.perimeter_answer.text=answer_
                view.diameter_layout.visibility=View.GONE
                view.angle_layout.visibility=View.GONE
                view.height_layout.visibility=View.GONE

            }







        }
    }
}