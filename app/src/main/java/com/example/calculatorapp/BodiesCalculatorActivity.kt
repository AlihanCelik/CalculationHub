package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_bodies_calculator.*
import kotlinx.android.synthetic.main.activity_bodies_calculator.A_string
import kotlinx.android.synthetic.main.activity_bodies_calculator.A_value
import kotlinx.android.synthetic.main.activity_bodies_calculator.B_layout
import kotlinx.android.synthetic.main.activity_bodies_calculator.B_string
import kotlinx.android.synthetic.main.activity_bodies_calculator.B_value
import kotlinx.android.synthetic.main.activity_bodies_calculator.backButton
import kotlinx.android.synthetic.main.activity_bodies_calculator.linearLayout2
import kotlinx.android.synthetic.main.activity_bodies_calculator.method
import kotlinx.android.synthetic.main.activity_bodies_calculator.visi
import kotlinx.android.synthetic.main.activity_bodies_calculator.x_string
import kotlinx.android.synthetic.main.activity_bodies_calculator.x_value
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

class BodiesCalculatorActivity : AppCompatActivity() {
    var a=0.0
    var b=0.0
    var c=0.0
    var answer=""
    var answer_=""
    var answer_3=""
    var solutions=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bodies_calculator)
        backButton.setOnClickListener {
            finish()
        }
        bodiesSelect.setOnClickListener {

            val bottomSheet =
                BottomSheetDialog(this@BodiesCalculatorActivity, R.style.BottomSheetDialogTheme)
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_bodies,
                bottomSheet.findViewById(R.id.bottomSheetBodies)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.cube).setOnClickListener {
                bodies_cal_name.text = "Cube"
                bodies_image.setImageResource(R.drawable.cube)
                method.setImageResource(R.drawable.cube)
                visi.visibility = View.GONE
                B_layout.visibility = View.GONE
                A_string.text = "Side"
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.prism).setOnClickListener {
                bodies_cal_name.text = "Prism"
                bodies_image.setImageResource(R.drawable.prism)
                method.setImageResource(R.drawable.prism)
                visi.visibility = View.VISIBLE
                A_string.text = "Side A"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Side B"
                x_string.text="Side C"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.pyramid).setOnClickListener {
                bodies_cal_name.text = "Pyramid"
                bodies_image.setImageResource(R.drawable.pyramid)
                method.setImageResource(R.drawable.pyramid)
                visi.visibility = View.GONE
                A_string.text = "Side"
                B_layout.visibility = View.VISIBLE
                B_string.text="Height"
                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.pyramid_frustum).setOnClickListener {
                bodies_cal_name.text = "Pyramid Frustum"
                bodies_image.setImageResource(R.drawable.pyramidfrustum)
                method.setImageResource(R.drawable.pyramidfrustum)
                visi.visibility = View.VISIBLE
                A_string.text = "Side A"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Side B"
                x_string.text="Height"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.cone).setOnClickListener {
                bodies_cal_name.text = "Cone"
                bodies_image.setImageResource(R.drawable.cone)
                method.setImageResource(R.drawable.cone)
                visi.visibility = View.GONE
                B_layout.visibility = View.VISIBLE
                A_string.text = "Radius"
                B_string.text = "Height"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.conefrustum).setOnClickListener {
                bodies_cal_name.text = "Cone Frustum"
                bodies_image.setImageResource(R.drawable.rhombus)
                method.setImageResource(R.drawable.rhombus)
                visi.visibility = View.VISIBLE
                A_string.text = "Radius"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Radius"
                x_string.text="Height"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.cylinder).setOnClickListener {
                bodies_cal_name.text = "Cylinder"
                bodies_image.setImageResource(R.drawable.cylinder)
                method.setImageResource(R.drawable.cylinder)
                visi.visibility = View.GONE
                A_string.text = "Radius"
                B_layout.visibility = View.VISIBLE
                B_string.text="Height"


                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.sphere).setOnClickListener {
                bodies_cal_name.text = "Sphere"
                bodies_image.setImageResource(R.drawable.sphere)
                method.setImageResource(R.drawable.sphere)
                visi.visibility = View.GONE
                A_string.text = "Radius"
                B_layout.visibility = View.GONE

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.sphereCap).setOnClickListener {
                bodies_cal_name.text = "Sphere Cap"
                bodies_image.setImageResource(R.drawable.spherecap)
                method.setImageResource(R.drawable.spherecap)
                visi.visibility = View.GONE
                A_string.text = "Radius"
                B_layout.visibility = View.VISIBLE
                B_string.text="Height"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.sphereSegment).setOnClickListener {
                bodies_cal_name.text = "Sphere Segment"
                bodies_image.setImageResource(R.drawable.spheresegment)
                method.setImageResource(R.drawable.arc)
                visi.visibility = View.VISIBLE
                A_string.text = "Radius"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Radius"
                x_string.text="Height"

                bottomSheet.dismiss()

            }
            bottomSheetView.findViewById<View>(R.id.ellipsoid).setOnClickListener {
                bodies_cal_name.text = "Ellipsoid"
                bodies_image.setImageResource(R.drawable.ellipsoid)
                method.setImageResource(R.drawable.ellipsoid)
                visi.visibility = View.VISIBLE
                A_string.text = "Radius"
                B_layout.visibility = View.VISIBLE
                B_string.text = "Radius"
                x_string.text="Radius"
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

            if (bodies_cal_name.text == "Cube") {
                val totalArea = 6 * a * a
                val surfaceArea = 4 * a * a
                val volume = a * a * a
                answer=totalArea.toString()
                answer_=surfaceArea.toString()
                answer_3=volume.toString()
                solutions="Side = $a\nTotal Area = 6 x $a x $a\n= 6 x ${a*a}\n= $totalArea\n\nLateral Area = 4 x $a x $a\n= 4 x ${a*a}\n= $surfaceArea\n\n" +
                        "Volume = $a x $a x $a\n= $volume"
            }
            if (bodies_cal_name.text == "Prism") {
                val totalArea = 2*a*b + 2*b*c + 2*a*c
                val surfaceArea = 2*a*b + 2*a*c
                val volume = a*b*c
                answer=totalArea.toString()
                answer_=surfaceArea.toString()
                answer_3=volume.toString()
                solutions="Side A = $a\nSide B = $b\nSide C = $c\nTotal Area = 2AB + 2BC + 2AC\n= (2 x $a x $b) + (2 x $b x $c) + (2 x $a x $c)\n= ${2*a*b} + ${2*b*c} + ${2*a*c}\n= $totalArea\n\n" +
                        "Lateral Area = 2AB + 2AC\n" +
                        "= (2 x $a x $b) + (2 x $a x $c)\n" +
                        "= ${2 * a * b} + ${2 * a * c}\n= $surfaceArea\n\n" +
                        "Volume = A x B x C\n=$a x $b x $c\n= $volume"
            }
            if (bodies_cal_name.text == "Pyramid") {
                val surfaceArea = (2*a)* sqrt(b.pow(2)+(a/2).pow(2))
                val totalArea = surfaceArea + a.pow(2)
                val volume = a.pow(2) * (b/3)
                answer=totalArea.toString()
                answer_=surfaceArea.toString()
                answer_3=volume.toString()
                solutions="Side A = $a\nHeight H = $b\nLateral Area = 2A x √(H² +(A / 2))\n= 2 x $a x √($b² + ($a / 2))\n= ${2*a} x √(${b.pow(2)} + ${(a/2).pow(2)})\n= ${2*a} x √(${b.pow(2) + (a/2).pow(2)})\n= $surfaceArea\n\n" +
                        "Total Area = Lateral Area + A²\n= $surfaceArea + ${a.pow(2)}\n" +
                        "= $totalArea\n\n" +
                        "Volume = A² x (H / 3)\n=$a² x ($b / 3)\n= ${a.pow(2)} x ${b/3}\n= $volume"
            }
            if (bodies_cal_name.text == "Pyramid Frustum") {
                val surfaceArea = (2*(a+b))* sqrt(c.pow(2)+((b-a)/2).pow(2))
                val totalArea = surfaceArea + a.pow(2)+ b.pow(2)
                val volume = (a.pow(2) + a *b + b.pow(2))* (c/3)
                answer=totalArea.toString()
                answer_=surfaceArea.toString()
                answer_3=volume.toString()
                solutions="Side A = $a\nSide B = $b\nHeight H = $c\nLateral Area = 2(A + B) x √(H² +((B - A) / 2))\n= 2($a + $b) x √($c² + (($b - $a)/ 2))\n= ${2*(a+b)} x √(${c.pow(2)} + ${((b-a)/2).pow(2)})\n= ${2*(a+b)} x √(${c.pow(2) + ((b-a)/2).pow(2)})\n= $surfaceArea\n\n" +
                        "Total Area = Lateral Area + A² + B²\n= $surfaceArea + ${a.pow(2)} + ${b.pow(2)}\n" +
                        "= $totalArea\n\n" +
                        "Volume = (A² + A x B + B²) x (H / 3)\n=$a² + $a x $b + $b² x ($c / 3)\n= ${a.pow(2)} + $a x $b + ${b.pow(2)} x ${b/3}\n= $volume"

            }
            if (bodies_cal_name.text == "Cone") {
                val totalArea = 2 * Math.PI * a * (a + b) // Toplam alan = 2πrh + 2πr^2
                val lateralArea = 2 * Math.PI * a * b // Yan yüzey alanı = 2πrh
                val volume = Math.PI * a * a * b // Hacim = πr^2h
                answer=totalArea.toString()
                answer_=lateralArea.toString()
                answer_3=volume.toString()
                solutions = "Radius r = $a\nHeight h = $b\n" +
                        "Lateral Area = π * r * √(r² + h²)\n" +
                        "= π * $a * √(${a.pow(2)} + ${b.pow(2)})\n" +
                        "= π * $a * √(${a.pow(2) + b.pow(2)})\n" +
                        "= $lateralArea\n\n" +
                        "Total Area = Lateral Area + π * r²\n" +
                        "= $lateralArea + π * ${a.pow(2)}\n" +
                        "= $totalArea\n\n" +
                        "Volume = (π * r² * h) / 3\n" +
                        "= (π * ${a.pow(2)} * $b) / 3\n" +
                        "= $volume"
            }
            if (bodies_cal_name.text == "Cone Frustum") {
                val slantHeight1 = sqrt(a.pow(2) + c.pow(2))
                val slantHeight2 = sqrt(b.pow(2) + c.pow(2))
                val lateralArea = Math.PI * (a + b) * (slantHeight1 + slantHeight2)
                val totalArea = lateralArea + Math.PI * (a.pow(2) + b.pow(2))
                val volume = (Math.PI * c / 3) * (a.pow(2) + a * b + b.pow(2))
                answer=totalArea.toString()
                answer_=lateralArea.toString()
                answer_3=volume.toString()
                solutions = "Inner Radius r1 = $a\nOuter Radius r2 = $b\nHeight h = $c\n" +
                        "Lateral Area = π * (r1 + r2) * (slantHeight1 + slantHeight2)\n" +
                        "= π * ($a + $b) * (${sqrt(a.pow(2) + c.pow(2))} + ${sqrt(b.pow(2) + c.pow(2))})\n" +
                        "= $lateralArea\n\n" +
                        "Total Area = Lateral Area + π * (r1² + r2²)\n" +
                        "= $lateralArea + π * (${a.pow(2)} + ${b.pow(2)})\n" +
                        "= $totalArea\n\n" +
                        "Volume = (π * h / 3) * (r1² + r1 * r2 + r2²)\n" +
                        "= (π * $c / 3) * (${a.pow(2)} + $a * $b + ${b.pow(2)})\n" +
                        "= $volume"
            }
            if (bodies_cal_name.text == "Cylinder") {
                val lateralArea = 2 * Math.PI * a * b
                val totalArea = lateralArea + 2 * Math.PI * a.pow(2)
                val volume = Math.PI * a.pow(2) * b
                answer=totalArea.toString()
                answer_=lateralArea.toString()
                answer_3=volume.toString()
                solutions = "Radius r = $a\nHeight h = $b\n" +
                        "Lateral Area = 2πrh\n" +
                        "= 2π * $a * $b\n" +
                        "= $lateralArea\n\n" +
                        "Total Area = Lateral Area + 2πr²\n" +
                        "= $lateralArea + 2π * ${a.pow(2)}\n" +
                        "= $totalArea\n\n" +
                        "Volume = πr²h\n" +
                        "= π * ${a.pow(2)} * $b\n" +
                        "= $volume"

            }
            if (bodies_cal_name.text == "Sphere") {
                val totalArea = 4 * Math.PI * a.pow(2)
                val volume = (4/3) * Math.PI * a.pow(3)
                answer=totalArea.toString()
                answer_3=volume.toString()
                solutions = "Radius r = $a\n" +
                        "Total Area = 4πr²\n" +
                        "= 4π * ${a.pow(2)}\n" +
                        "= $totalArea\n\n" +
                        "Volume = (4/3)πr³\n" +
                        "= (4/3)π * ${a.pow(3)}\n" +
                        "= $volume"
            }
            if (bodies_cal_name.text == "Sphere Cap") {
                val lateralArea=PI*(a.pow(2)+b.pow(2))
                val totalArea= lateralArea+(PI*a.pow(2))
                val volume=(3*PI*b*(a.pow(2)+b.pow(3)))/6
                answer=totalArea.toString()
                answer_=lateralArea.toString()
                answer_3=volume.toString()
                solutions = "Radius A= $a\nHeight H= $b\n" +
                        "Lateral Area = π(A² + H²)\n" +
                        "= π(${a.pow(2)} + ${b.pow(2)})\n" +
                        "= $lateralArea\n\n" +
                        "Total Area = Lateral Area + πA²\n" +
                        "= $lateralArea + π${a.pow(2)}\n" +
                        "= $totalArea\n\n" +
                        "Volume = (3πb(A² + H³)) / 6\n" +
                        "= (3π($b)(${a.pow(2)} + ${b.pow(3)})) / 6\n" +
                        "= $volume"
            }
            if (bodies_cal_name.text == "Sphere Segment") {
                val volume = (3* PI*c *(3*a*a + 3*b*b + c*c))/6
                answer_3=volume.toString()
                solutions="Radius A =$a\nRadius B = $b\nHeight H = $c\nVolume = (3π x H x (3A² + 3B² + H²)) / 6\n= (3π x $c x (3$a² + 3$b² + $c²)) / 6\n= (${3* PI} x $c x (${3*a*a} + ${b*b*3} + ${c*c})) / 6\n" +
                        "=${(3* PI*c *(3*a*a + 3*b*b + c*c))} / 6 \n= $volume"
            }
            if (bodies_cal_name.text == "Ellipsoid") {
                val area = 4 * PI * ((a * b).pow(1.6) + (a * c).pow(1.6) + (b * c).pow(1.6)) / 3
                val volume = (4 * PI * a * b * c) / 3
                answer=area.toString()
                answer_3=volume.toString()
                solutions = "Radius r1 = $a\nRadius r2 = $b\nRadius r3 = $c\n" +
                        "Area = 4π * ((r1 * r2)^1.6 + (r1 * r3)^1.6 + (r2 * r3)^1.6) / 3\n" +
                        "= 4π * (($a * $b)^1.6 + ($a * $c)^1.6 + ($b * $c)^1.6) / 3\n" +
                        "= $area\n\n" +
                        "Volume = (4π * r1 * r2 * r3) / 3\n" +
                        "= (4π * $a * $b * $c) / 3\n" +
                        "= $volume"
            }
        }

    }
}