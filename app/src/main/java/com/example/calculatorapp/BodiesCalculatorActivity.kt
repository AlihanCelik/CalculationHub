package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_bodies_calculator.*

class BodiesCalculatorActivity : AppCompatActivity() {
    var a=0.0
    var b=0.0
    var c=0.0
    var answer=""
    var answer_=""
    var answer_3=""
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

    }
}