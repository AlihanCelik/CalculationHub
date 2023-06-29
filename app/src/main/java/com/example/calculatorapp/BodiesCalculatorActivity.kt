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
            }
            if (bodies_cal_name.text == "Pyramid Frustum") {

            }
            if (bodies_cal_name.text == "Cone") {

            }
            if (bodies_cal_name.text == "Cone Frustum") {

            }
            if (bodies_cal_name.text == "Cylinder") {

            }
            if (bodies_cal_name.text == "Sphere") {

            }
            if (bodies_cal_name.text == "Sphere Cap") {

            }
            if (bodies_cal_name.text == "Sphere Segment") {

            }
            if (bodies_cal_name.text == "Ellipsoid") {

            }
        }

    }
}