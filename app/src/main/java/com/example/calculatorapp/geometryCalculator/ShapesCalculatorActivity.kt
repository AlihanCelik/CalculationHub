package com.example.calculatorapp.geometryCalculator

import android.app.AlertDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculatorapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_shapes_calculator.*
import kotlinx.android.synthetic.main.activity_shapes_calculator.backButton
import kotlinx.android.synthetic.main.activity_shapes_calculator.linearLayout2
import kotlinx.android.synthetic.main.activity_shapes_calculator.method
import kotlinx.android.synthetic.main.dialog_shapes_solutions.view.*
import kotlin.math.*

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
    var shape="Triangle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shapes_calculator)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        shapesSelect.setOnClickListener {

            val bottomSheet =
                BottomSheetDialog(this@ShapesCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_shapes,
                bottomSheet.findViewById(R.id.bottomSheetShapes)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.triangle).setOnClickListener {
                shapes_cal_name.text = "Triangle"
                shape = "Triangle"
                shapes_image.setImageResource(R.drawable.triangle)
                method.setImageResource(R.drawable.triangle)
                visi.visibility = View.VISIBLE
                B_layout.visibility = View.VISIBLE
                selectSideAButton.visibility = View.GONE
                selectSideBButton.visibility = View.GONE
                selectSideCButton.visibility = View.GONE
                A_string.text = "Side A"
                B_string.text = "Side B"
                x_string.text = "Side C"
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.rightTriengle).setOnClickListener {
                shapes_cal_name.text = "Right Triangle"
                shape = "Right Triangle"
                shapes_image.setImageResource(R.drawable.righttriangle)
                method.setImageResource(R.drawable.righttriangle)
                visi.visibility = View.GONE
                selectSideAButton.visibility = View.VISIBLE
                selectSideBButton.visibility = View.VISIBLE
                A_string.text = "Side A"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Side B"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.square).setOnClickListener {
                shapes_cal_name.text = "Square"
                shape = "Square"
                shapes_image.setImageResource(R.drawable.square)
                method.setImageResource(R.drawable.square)
                visi.visibility = View.GONE
                selectSideAButton.visibility = View.VISIBLE
                selectSideBButton.visibility = View.VISIBLE
                A_string.text = "Side"
                B_layout.visibility = View.GONE
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.rectangle).setOnClickListener {
                shapes_cal_name.text = "Rectangle"
                shape = "Rectangle"
                shapes_image.setImageResource(R.drawable.rectangle)
                method.setImageResource(R.drawable.rectangle)
                selectSideAButton.visibility = View.GONE
                selectSideBButton.visibility = View.GONE
                selectSideCButton.visibility = View.GONE
                visi.visibility = View.GONE
                A_string.text = "Side A"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Side B"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.trapezoid).setOnClickListener {
                shapes_cal_name.text = "Trapezoid"
                shape = "Trapezoid"
                shapes_image.setImageResource(R.drawable.trapezoid)
                method.setImageResource(R.drawable.trapezoid)
                visi.visibility = View.VISIBLE
                selectSideAButton.visibility = View.GONE
                selectSideBButton.visibility = View.GONE
                selectSideCButton.visibility = View.GONE
                A_string.text = "Side A"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Side B"
                x_string.text = "Height"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.rhombus).setOnClickListener {
                shapes_cal_name.text = "Rhombus"
                shape = "Rhombus"
                shapes_image.setImageResource(R.drawable.rhombus)
                method.setImageResource(R.drawable.rhombus)
                visi.visibility = View.GONE
                selectSideAButton.visibility = View.GONE
                selectSideBButton.visibility = View.GONE
                selectSideCButton.visibility = View.GONE
                A_string.text = "Height A"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Height B"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.pentagon).setOnClickListener {
                shapes_cal_name.text = "Pentagon"
                shape = "Pentagon"
                shapes_image.setImageResource(R.drawable.pentagon)
                method.setImageResource(R.drawable.pentagon)
                visi.visibility = View.GONE
                selectSideAButton.visibility = View.VISIBLE
                A_string.text = "Side A"
                B_layout.visibility = View.GONE

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.hexagon).setOnClickListener {
                shapes_cal_name.text = "Hexagon"
                shape = "Hexagon"
                shapes_image.setImageResource(R.drawable.hexagon)
                method.setImageResource(R.drawable.hexagon)
                visi.visibility = View.GONE
                selectSideAButton.visibility = View.VISIBLE
                A_string.text = "Side A"
                B_layout.visibility = View.GONE

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.circle).setOnClickListener {
                shapes_cal_name.text = "Circle"
                shape = "Circle"
                shapes_image.setImageResource(R.drawable.circle)
                method.setImageResource(R.drawable.circle)
                selectSideAButton.visibility = View.VISIBLE
                visi.visibility = View.GONE
                A_string.text = "Radius"
                B_layout.visibility = View.GONE

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.circleArc).setOnClickListener {
                shapes_cal_name.text = "Circle Arc"
                shape = "Circle Arc"
                shapes_image.setImageResource(R.drawable.arc)
                method.setImageResource(R.drawable.arc)
                visi.visibility = View.GONE
                selectSideAButton.visibility = View.GONE
                selectSideBButton.visibility = View.GONE
                selectSideCButton.visibility = View.GONE
                A_string.text = "Angle"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Radius"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.ellipse).setOnClickListener {
                shapes_cal_name.text = "Ellipse"
                shape = "Ellipse"
                shapes_image.setImageResource(R.drawable.ellipse)
                method.setImageResource(R.drawable.ellipse)
                visi.visibility = View.GONE
                selectSideAButton.visibility = View.GONE
                selectSideBButton.visibility = View.GONE
                selectSideCButton.visibility = View.GONE
                A_string.text = "Radius A"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Radius B"

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

        selectSideA.setOnClickListener {
            if (shape == "Right Triangle") {
                val bottomSheet =
                    BottomSheetDialog(
                        this@ShapesCalculatorActivity,
                        R.style.BottomSheetDialogTheme
                    )
                val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                    R.layout.bottom_sheet_shapes_righttiangle,
                    bottomSheet.findViewById(R.id.bottomSheetRightTriangle)
                ) as ConstraintLayout
                bottomSheetView.findViewById<View>(R.id.sideR).setOnClickListener {
                    A_string.text = "Side A"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.hypotenuseR).setOnClickListener {
                    A_string.text = "Hypotenuse"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.angleA).setOnClickListener {
                    A_string.text = "Angle A"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.angleB).setOnClickListener {
                    A_string.text = "Angle B"
                    bottomSheet.dismiss()

                }

                bottomSheetView.findViewById<View>(R.id.cancelRight).setOnClickListener {
                    bottomSheet.dismiss()

                }
                bottomSheet.setContentView(bottomSheetView)
                bottomSheet.show()
            }
            if (shape == "Square") {
                val bottomSheet =
                    BottomSheetDialog(this@ShapesCalculatorActivity, R.style.BottomSheetDialogTheme)
                val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                    R.layout.bottom_sheet_shapes_value,
                    bottomSheet.findViewById(R.id.bottomSheetValue)
                ) as ConstraintLayout
                bottomSheetView.findViewById<View>(R.id.sideV).setOnClickListener {
                    A_string.text = "Side"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.areaV).setOnClickListener {
                    A_string.text = "Area"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.perimeterV).setOnClickListener {
                    A_string.text = "Perimeter"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.cancelValue).setOnClickListener {
                    bottomSheet.dismiss()

                }
                bottomSheet.setContentView(bottomSheetView)
                bottomSheet.show()
            }
            if (shape == "Pentagon") {
                val bottomSheet =
                    BottomSheetDialog(this@ShapesCalculatorActivity, R.style.BottomSheetDialogTheme)
                val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                    R.layout.bottom_sheet_shapes_value,
                    bottomSheet.findViewById(R.id.bottomSheetValue)
                ) as ConstraintLayout
                bottomSheetView.findViewById<View>(R.id.sideV).setOnClickListener {
                    A_string.text = "Side"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.areaV).setOnClickListener {
                    A_string.text = "Area"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.perimeterV).setOnClickListener {
                    A_string.text = "Perimeter"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.cancelValue).setOnClickListener {
                    bottomSheet.dismiss()

                }
                bottomSheet.setContentView(bottomSheetView)
                bottomSheet.show()
            }
            if (shape == "Hexagon") {
                val bottomSheet =
                    BottomSheetDialog(this@ShapesCalculatorActivity, R.style.BottomSheetDialogTheme)
                val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                    R.layout.bottom_sheet_shapes_value,
                    bottomSheet.findViewById(R.id.bottomSheetValue)
                ) as ConstraintLayout
                bottomSheetView.findViewById<View>(R.id.sideV).setOnClickListener {
                    A_string.text = "Side"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.areaV).setOnClickListener {
                    A_string.text = "Area"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.perimeterV).setOnClickListener {
                    A_string.text = "Perimeter"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.cancelValue).setOnClickListener {
                    bottomSheet.dismiss()

                }
                bottomSheet.setContentView(bottomSheetView)
                bottomSheet.show()
            }
            if (shape == "Circle") {
                val bottomSheet =
                    BottomSheetDialog(this@ShapesCalculatorActivity, R.style.BottomSheetDialogTheme)
                val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                    R.layout.bottom_sheet_shapes_circle,
                    bottomSheet.findViewById(R.id.bottomSheetCircleValue)
                ) as ConstraintLayout
                bottomSheetView.findViewById<View>(R.id.radiusC).setOnClickListener {
                    A_string.text = "Radius"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.DiameterC).setOnClickListener {
                    A_string.text = "Diameter"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.areaC).setOnClickListener {
                    A_string.text = "Area"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.circumferenceC).setOnClickListener {
                    A_string.text = "Circumference"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.cancelCircle).setOnClickListener {
                    bottomSheet.dismiss()

                }
                bottomSheet.setContentView(bottomSheetView)
                bottomSheet.show()
            }
        }

        selectSideB.setOnClickListener {
            if (shape == "Right Triangle") {
                val bottomSheet =
                    BottomSheetDialog(this@ShapesCalculatorActivity, R.style.BottomSheetDialogTheme)
                val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                    R.layout.bottom_sheet_shapes_righttiangle,
                    bottomSheet.findViewById(R.id.bottomSheetRightTriangle)
                ) as ConstraintLayout
                bottomSheetView.findViewById<View>(R.id.sideR).setOnClickListener {
                    B_string.text = "Side A"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.hypotenuseR).setOnClickListener {
                    B_string.text = "Hypotenuse"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.angleA).setOnClickListener {
                    B_string.text = "Angle A"
                    bottomSheet.dismiss()

                }
                bottomSheetView.findViewById<View>(R.id.angleB).setOnClickListener {
                    B_string.text = "Angle B"
                    bottomSheet.dismiss()


                }



                bottomSheetView.findViewById<View>(R.id.cancelRight).setOnClickListener {
                    bottomSheet.dismiss()

                }
                bottomSheet.setContentView(bottomSheetView)
                bottomSheet.show()
            }
        }


            linearLayout2.setOnClickListener {
                if (A_value.text.toString() == "") {
                    a = 0.0
                } else {
                    a = A_value.text.toString().toDouble()
                }
                if (B_value.text.toString() == "") {
                    b = 0.0
                } else {
                    b = B_value.text.toString().toDouble()
                }
                if (x_value.text.toString() == "") {
                    c = 0.0
                } else {
                    c = x_value.text.toString().toDouble()
                }

                if (shapes_cal_name.text == "Triangle") {
                    val s = (a + b + c) / 2
                    val area = sqrt(s * (s - a) * (s - b) * (s - c))
                    val perimeter = a + b + c
                    val angleA = Math.toDegrees(acos((b * b + c * c - a * a) / (2 * b * c)))
                    val angleB = Math.toDegrees(acos((a * a + c * c - b * b) / (2 * a * c)))
                    val angleC = 180 - angleA - angleB
                    val heightA = 2 * area / a
                    val heightB = 2 * area / b
                    val heightC = 2 * area / c
                    answer = area.toString()
                    answer_ = perimeter.toString()
                    answer_3 = "$angleA˚"
                    answer_4 = "$angleB˚"
                    answer_5 = "$angleC˚"
                    answer_6 = heightA.toString()
                    answer_7 = heightB.toString()
                    answer_8 = heightC.toString()
                    solution =
                        "Side A = $a\nSide B = $b\nSide C = $c\nS = (A + B + C) / 2 \n= ($a + $b + $c) / 2 \n${a + b + c} / 2\nS = ${(a + b + c) / 2}\n" +
                                "Area = √(S(S - A)(S - B)(S - C))\n= √(${(a + b + c) / 2}(${(a + b + c) / 2} - $a)(${(a + b + c) / 2} - $b)(${(a + b + c) / 2} - $c))\n= √(${(a + b + c) / 2} x ${((a + b + c) / 2) - a} x ${((a + b + c) / 2) - b} x ${((a + b + c) / 2) - c})\n= ${(s * (s - a) * (s - b) * (s - c))}\n= $answer\n" +
                                "Perimeter = A + B + C\n= $a + $b + $c\n= $answer_\n"


                }

                if (shapes_cal_name.text == "Right Triangle") {
                    if(A_string.text== "Side A" && B_string.text=="Side B"){
                        val area = 0.5 * a * b
                        val hypotenuse = sqrt(a * a + b * b)
                        val perimeter = a + b + hypotenuse
                        val angleA = Math.toDegrees(atan(b / a))
                        val angleB = 90.0 - angleA
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$angleA˚"
                        answer_4 = "$angleB˚"
                        answer_5 = "90˚"
                        answer_6 = a.toString()
                        answer_7 = b.toString()
                        answer_8 = hypotenuse.toString()
                    }
                    if(A_string.text== "Angle A" && B_string.text=="Angle B" || A_string.text== "Angle A" && B_string.text=="Angle A"|| A_string.text== "Angle B" && B_string.text=="Angle B" || A_string.text== "Angle B" && B_string.text=="Angle A" || A_string.text == "Hypotenuse" &&B_string.text == "Hypotenuse" ){
                        answer = "-"
                        answer_ = "-"
                        answer_3 = "-"
                        answer_4 = "$a˚"
                        answer_5 = "$b˚"
                        answer_6 = "-"
                        answer_7 = "-"
                        answer_8 = "-"
                    }
                    if(A_string.text== "Side A" && B_string.text=="Angle A"){
                        val angleB = 90.0 - b
                        val sideB =a * tan(Math.toRadians(b))
                        val sideC = sqrt(a.pow(2) + sideB.pow(2))
                        val perimeter = a + sideB + sideC
                        val area = 0.5 *a * sideB
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$b˚"
                        answer_4 = "$angleB˚"
                        answer_5 = "90˚"
                        answer_6 = a.toString()
                        answer_7 = b.toString()
                        answer_8 = sideC.toString()


                    }
                    if(A_string.text== "Angle B" && B_string.text=="Side B"){
                        val angleA = 90.0 - a
                        val sideA =b * tan(Math.toRadians(a))
                        val sideC = sqrt(b.pow(2) + sideA.pow(2))
                        val perimeter = b + sideA + sideC
                        val area = 0.5 *b * sideA
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$angleA˚"
                        answer_4 = "$a˚"
                        answer_5 = "90˚"
                        answer_6 = a.toString()
                        answer_7 = b.toString()
                        answer_8 = sideC.toString()


                    }
                    if(A_string.text == "Hypotenuse" && B_string.text == "Side B"){
                        val sideA = sqrt(a.pow(2) - b.pow(2))
                        val angleA = Math.toDegrees(atan(b / sideA))
                        val angleB = Math.toDegrees(atan(sideA / b))
                        val area = 0.5 * b * sideA
                        val perimeter = b + sideA + a
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$angleA˚"
                        answer_4 = "$angleB˚"
                        answer_5 = "90˚"
                        answer_6 = sideA.toString()
                        answer_7 = b.toString()
                        answer_8 = a.toString()

                    }
                    if(A_string.text == "Side A" && B_string.text == "Hypotenuse"){
                        val sideB = sqrt(b.pow(2) - a.pow(2))
                        val angleB = Math.toDegrees(atan(a / sideB))
                        val angleA = Math.toDegrees(atan(sideB / a))
                        val area = 0.5 * b * sideB
                        val perimeter = b + sideB + a
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$angleA˚"
                        answer_4 = "$angleB˚"
                        answer_5 = "90˚"
                        answer_6 = a.toString()
                        answer_7 = sideB.toString()
                        answer_8 = b.toString()

                    }
                    if(A_string.text == "Angle A" && B_string.text == "Hypotenuse"){
                        val angleB = 90 - Math.toDegrees(a)
                        val sideA =  b * sin(Math.toRadians(a)) // Kenar A = c * sin(a
                        val sideB = sqrt(b.pow(2) - a.pow(2))
                        val area = 0.5 * sideA * sideB
                        val perimeter = sideA + sideB + b
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$a˚"
                        answer_4 = "$angleB˚"
                        answer_5 = "90˚"
                        answer_6 = sideA.toString()
                        answer_7 = sideB.toString()
                        answer_8 = b.toString()

                    }
                    if(A_string.text == "Hypotenuse" && B_string.text == "Angle A"){
                        val angleB = 90 - Math.toDegrees(b)
                        val sideA =  a * sin(Math.toRadians(b))
                        val sideB = sqrt(a.pow(2) - b.pow(2))
                        val area = 0.5 * sideA * sideB
                        val perimeter = sideA + sideB + a
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$b˚"
                        answer_4 = "$angleB˚"
                        answer_5 = "90˚"
                        answer_6 = sideA.toString()
                        answer_7 = sideB.toString()
                        answer_8 = a.toString()

                    }
                    if(A_string.text == "Angle B" && B_string.text == "Hypotenuse"){
                        val angleA = 90 - Math.toDegrees(a)
                        val sideB =  b * sin(Math.toRadians(a)) // Kenar A = c * sin(a
                        val sideA = sqrt(b.pow(2) - a.pow(2))
                        val area = 0.5 * sideA * sideB
                        val perimeter = sideA + sideB + b
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$angleA˚"
                        answer_4 = "$a˚"
                        answer_5 = "90˚"
                        answer_6 = a.toString()
                        answer_7 = sideB.toString()
                        answer_8 = b.toString()

                    }
                    if(A_string.text == "Hypotenuse" && B_string.text == "Angle B"){
                        val angleA = 90 - Math.toDegrees(b)
                        val sideB =  a * sin(Math.toRadians(b))
                        val sideA = sqrt(a.pow(2) - b.pow(2))
                        val area = 0.5 * sideA * sideB
                        val perimeter = sideA + sideB + a
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$angleA˚"
                        answer_4 = "$b˚"
                        answer_5 = "90˚"
                        answer_6 = sideA.toString()
                        answer_7 = sideB.toString()
                        answer_8 = a.toString()

                    }
                    if(A_string.text== "Angle A" && B_string.text=="Side B"){
                        val sideA = b / tan(Math.toRadians(a)) // Kenar A = b / tan(a)
                        val sideC = sqrt(sideA.pow(2) + b.pow(2)) // Hipotenüs C = √(a^2 + b^2)
                        val area = 0.5 * sideA * b // Alan = 0.5 * a * b
                        val perimeter = sideA + b + sideC // Çevre = a + b + c
                        val angleB = Math.toDegrees(atan(sideA / b))
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$a˚"
                        answer_4 = "$angleB˚"
                        answer_5 = "90˚"
                        answer_6 = sideA.toString()
                        answer_7 = b.toString()
                        answer_8 = sideC.toString()
                    }
                    if(A_string.text== "Side A" && B_string.text=="Angle B"){
                        val sideC = a / sin(Math.toRadians(b)) // Hipotenüs C = a / sin(b)
                        val sideB = sqrt(sideC.pow(2) - a.pow(2)) // Kenar B = √(c^2 - a^2)
                        val area = 0.5 * a * sideB // Alan = 0.5 * a * b
                        val perimeter = a+ sideB + sideC // Çevre = a + b + c
                        val angleA = 180 - b - Math.toDegrees(asin(sideB / sideC)) // Açı A = 180 - Açı B - arcsin(b / c)
                        answer = area.toString()
                        answer_ = perimeter.toString()
                        answer_3 = "$angleA˚"
                        answer_4 = "$b˚"
                        answer_5 = "90˚"
                        answer_6 = a.toString()
                        answer_7 = sideB.toString()
                        answer_8 = sideC.toString()
                    }





                }

                if (shapes_cal_name.text == "Square") {
                    if(A_string.text== "Side"){
                        val area = a * a
                        val perimeter = 4 * a
                        answer = area.toString()
                        answer_ = perimeter.toString()
                    }
                    if(A_string.text== "Area"){
                        val side = Math.sqrt(a)
                        val perimeter = 4 * side
                        answer = side.toString()
                        answer_ = perimeter.toString()
                    }
                    if(A_string.text== "Perimeter"){
                        val side = a / 4
                        val area = side * side
                        answer = area.toString()
                        answer_ = side.toString()
                    }



                }

                if (shapes_cal_name.text == "Rectangle") {
                    val area = a * b
                    val perimeter = 2 * (a + b)
                    answer = area.toString()
                    answer_ = perimeter.toString()

                }

                if (shapes_cal_name.text == "Trapezoid") {
                    val area = 0.5 * (a + b) * c
                    val perimeter = a + b + 2 * sqrt(((a - b) / 2).pow(2) + c.pow(2))
                    answer = area.toString()
                    answer_ = perimeter.toString()
                }

                if (shapes_cal_name.text == "Rhombus") {
                    val d = Math.abs(a - b)
                    val x = Math.sqrt(a * b + d * d)
                    val area = a * x
                    val perimeter = 4 * x
                    answer = area.toString()
                    answer_ = perimeter.toString()
                }

                if (shapes_cal_name.text == "Pentagon") {
                    if(A_string.text== "Side"){
                        val area = 0.25 * Math.sqrt(5 * (5 + 2 * sqrt(5.0))) * a * a
                        val perimeter = 5 * a
                        answer = area.toString()
                        answer_ = perimeter.toString()
                    }
                    if(A_string.text== "Area"){
                        val side = Math.sqrt(a * 4 / (Math.sqrt(5.0) * (5 + Math.sqrt(5.0)))) // Kenar uzunluğu = √(alan * 4 / (√5 * (5 + √5)))
                        val perimeter = 5 * side
                        answer = side.toString()
                        answer_ = perimeter.toString()
                    }
                    if(A_string.text== "Perimeter"){
                        val side = a / 5
                        val area = 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5.0))) * side.pow(2)
                        answer = area.toString()
                        answer_ = side.toString()
                    }

                }

                if (shapes_cal_name.text == "Hexagon") {
                    if(A_string.text== "Side"){
                        val area = (3 * sqrt(3.0) * a * a) / 2
                        val perimeter = 6 * a
                        answer = area.toString()
                        answer_ = perimeter.toString()
                    }
                    if(A_string.text== "Area"){
                        val side = Math.sqrt(a * 2 / (3 * Math.sqrt(3.0)))
                        val perimeter = 6 * side
                        answer = side.toString()
                        answer_ = perimeter.toString()
                    }
                    if(A_string.text== "Perimeter"){
                        val side = a / 6 // Kenar uzunluğu = Çevre / 6
                        val area = (3 * Math.sqrt(3.0) * side.pow(2)) / 2
                        answer = area.toString()
                        answer_ = side.toString()
                    }


                }

                if (shapes_cal_name.text == "Circle") {
                    if(A_string.text== "Radius"){
                        val area = Math.PI * a * a
                        val circumference = Math.PI * 2 * a
                        val diameter = 2 * a

                        answer = area.toString()
                        answer_ = circumference.toString()
                        answer_3 = diameter.toString()
                    }
                    if(A_string.text== "Diameter"){
                        val radius = a / 2
                        val area = Math.PI * radius.pow(2)
                        val circumference = Math.PI * a
                        answer = area.toString()
                        answer_ = circumference.toString()
                        answer_3 = radius.toString()

                    }
                    if(A_string.text== "Area"){
                        val radius = Math.sqrt(a / Math.PI)
                        val diameter = 2 * radius
                        val circumference = 2 * Math.PI * radius
                        answer = radius.toString()
                        answer_ = circumference.toString()
                        answer_3 = diameter.toString()

                    }

                    if(A_string.text== "Circumference"){
                        val radius = a / (2 * Math.PI)
                        val diameter = 2 * radius
                        val area = Math.PI * radius * radius
                        answer = area.toString()
                        answer_ = radius.toString()
                        answer_3 = diameter.toString()

                    }



                }

                if (shapes_cal_name.text == "Circle Arc") {
                    val area = (a / 360) * Math.PI * b * b
                    val perimeter = (a / 360) * (2 * Math.PI * b)
                    answer = area.toString()
                    answer_ = perimeter.toString()

                }

                if (shapes_cal_name.text == "Ellipse") {
                    val area = Math.PI * a * b
                    val perimeter = Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)))
                    answer = area.toString()
                    answer_ = perimeter.toString()

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
                if (shapes_cal_name.text == "Triangle") {
                    view.area_string.text="Area"
                    view.perimeter_string.text="Perimeter"
                    view.heightA_answer.text = "Height A"
                    view.heightB_answer.text = "Height B"
                    view.area_answer.text = answer
                    view.perimeter_answer.text = answer_
                    view.angleA_answer.text = answer_3
                    view.angleB_answer.text = answer_4
                    view.angleC_answer.text = answer_5
                    view.heightA_answer.text = answer_6
                    view.heightB_answer.text = answer_7
                    view.heightC_answer.text = answer_8
                    view.diameter_layout.visibility = View.GONE
                    view.angle_layout.visibility = View.VISIBLE
                    view.height_layout.visibility = View.VISIBLE
                    view.heightB_layout.visibility = View.VISIBLE
                    view.heightC_layout.visibility = View.VISIBLE
                    view.angleC_layout.visibility = View.VISIBLE
                    view.heightC_string.text = "Height C"


                }

                if (shapes_cal_name.text == "Right Triangle") {
                    view.area_string.text="Area"
                    view.perimeter_string.text="Perimeter"
                    view.heightA_answer.text = "Side A"
                    view.heightB_answer.text = "Side B"
                    view.area_answer.text = answer
                    view.perimeter_answer.text = answer_
                    view.angleA_answer.text = answer_3
                    view.angleB_answer.text = answer_4
                    view.angleC_answer.text = answer_5
                    view.heightA_answer.text = answer_6
                    view.heightB_answer.text = answer_7
                    view.heightC_answer.text = answer_8
                    view.diameter_layout.visibility = View.GONE
                    view.angle_layout.visibility = View.VISIBLE
                    view.height_layout.visibility = View.VISIBLE
                    view.heightB_layout.visibility = View.VISIBLE
                    view.heightC_layout.visibility = View.VISIBLE
                    view.angleC_layout.visibility = View.VISIBLE
                    view.heightC_string.text = "Hypotenuse"

                }

                if (shapes_cal_name.text == "Square") {
                    if(A_string.text== "Side"){
                        view.area_string.text="Area"
                        view.perimeter_string.text="Perimeter"
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_layout.visibility = View.GONE
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }
                    if(A_string.text== "Area"){
                        view.area_string.text="Side"
                        view.perimeter_string.text="Perimeter"
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_layout.visibility = View.GONE
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }
                    if(A_string.text== "Perimeter"){
                        view.area_string.text="Area"
                        view.perimeter_string.text="Side"
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_layout.visibility = View.GONE
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }

                }

                if (shapes_cal_name.text == "Rectangle") {
                    view.area_string.text="Area"
                    view.perimeter_string.text="Perimeter"
                    view.area_answer.text = answer
                    view.perimeter_answer.text = answer_
                    view.diameter_layout.visibility = View.GONE
                    view.angle_layout.visibility = View.GONE
                    view.height_layout.visibility = View.GONE

                }

                if (shapes_cal_name.text == "Trapezoid") {
                    view.area_string.text="Area"
                    view.perimeter_string.text="Perimeter"
                    view.area_answer.text = answer
                    view.perimeter_answer.text = answer_
                    view.diameter_layout.visibility = View.GONE
                    view.angle_layout.visibility = View.GONE
                    view.height_layout.visibility = View.GONE
                }

                if (shapes_cal_name.text == "Rhombus") {
                    view.area_string.text="Area"
                    view.perimeter_string.text="Perimeter"
                    view.area_answer.text = answer
                    view.perimeter_answer.text = answer_
                    view.diameter_layout.visibility = View.GONE
                    view.angle_layout.visibility = View.GONE
                    view.height_layout.visibility = View.GONE
                }

                if (shapes_cal_name.text == "Pentagon") {
                    if(A_string.text== "Side"){
                        view.area_string.text="Area"
                        view.perimeter_string.text="Perimeter"
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_layout.visibility = View.GONE
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }
                    if(A_string.text== "Area"){
                        view.area_string.text="Side"
                        view.perimeter_string.text="Perimeter"
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_layout.visibility = View.GONE
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }
                    if(A_string.text== "Perimeter"){
                        view.area_string.text="Area"
                        view.perimeter_string.text="Side"
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_layout.visibility = View.GONE
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }

                }

                if (shapes_cal_name.text == "Hexagon") {
                    if(A_string.text== "Side"){
                        view.area_string.text="Area"
                        view.perimeter_string.text="Perimeter"
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_layout.visibility = View.GONE
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }
                    if(A_string.text== "Area"){
                        view.area_string.text="Side"
                        view.perimeter_string.text="Perimeter"
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_layout.visibility = View.GONE
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }
                    if(A_string.text== "Perimeter"){
                        view.area_string.text="Area"
                        view.perimeter_string.text="Side"
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_layout.visibility = View.GONE
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }

                }

                if (shapes_cal_name.text == "Circle") {
                    if(A_string.text== "Radius"){
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_answer.text=answer_3
                        view.diameter_layout.visibility = View.VISIBLE
                        view.area_string.text="Area"
                        view.perimeter_string.text="Circumference"
                        view.diameter_string.text="Diameter"
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }
                    if(A_string.text== "Diameter"){
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_layout.visibility = View.VISIBLE
                        view.area_string.text="Area"
                        view.perimeter_string.text="Circumference"
                        view.diameter_string.text="Radius"
                        view.diameter_answer.text=answer_3
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE

                    }
                    if(A_string.text== "Area"){
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_answer.text=answer_3
                        view.diameter_layout.visibility = View.VISIBLE
                        view.area_string.text="Radius"
                        view.perimeter_string.text="Circumference"
                        view.diameter_string.text="Diameter"

                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE

                    }

                    if(A_string.text== "Circumference"){
                        view.area_answer.text = answer
                        view.perimeter_answer.text = answer_
                        view.diameter_answer.text=answer_3
                        view.diameter_layout.visibility = View.VISIBLE
                        view.area_string.text="Area"
                        view.perimeter_string.text="Radius"
                        view.diameter_string.text="Diameter"
                        view.angle_layout.visibility = View.GONE
                        view.height_layout.visibility = View.GONE
                    }


                }

                if (shapes_cal_name.text == "Circle Arc") {

                    view.area_string.text="Area"
                    view.perimeter_string.text="Perimeter"
                    view.area_answer.text = answer
                    view.perimeter_answer.text = answer_
                    view.diameter_layout.visibility = View.GONE
                    view.angle_layout.visibility = View.GONE
                    view.height_layout.visibility = View.GONE

                }
                if (shapes_cal_name.text == "Ellipse") {

                    view.area_string.text="Area"
                    view.perimeter_string.text="Perimeter"
                    view.area_answer.text = answer
                    view.perimeter_answer.text = answer_
                    view.diameter_layout.visibility = View.GONE
                    view.angle_layout.visibility = View.GONE
                    view.height_layout.visibility = View.GONE

                }


            }
        }
    }