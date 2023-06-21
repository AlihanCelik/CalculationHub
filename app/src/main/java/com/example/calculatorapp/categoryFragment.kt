package com.example.calculatorapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.dialog_algebra.view.*
import kotlinx.android.synthetic.main.dialog_converter.view.*
import kotlinx.android.synthetic.main.dialog_geometry.view.*
import kotlinx.android.synthetic.main.dialog_health.view.*
import kotlinx.android.synthetic.main.dialog_health.view.bmi_calculate
import kotlinx.android.synthetic.main.dialog_time.view.*
import kotlinx.android.synthetic.main.fragment_category.*



class categoryFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        algebra_calculate.setOnClickListener {
            val view=View.inflate(requireContext(),R.layout.dialog_algebra,null)
            val builder=AlertDialog.Builder(requireContext())
            builder.setView(view)
            val dialog=builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.linearLayout2.setOnClickListener {
                dialog.dismiss()
            }
        }
        geo_calculate.setOnClickListener {
            val view=View.inflate(requireContext(),R.layout.dialog_geometry,null)
            val builder=AlertDialog.Builder(requireContext())
            builder.setView(view)
            val dialog=builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel_geo.setOnClickListener {
                dialog.dismiss()
            }
        }
        health_calculate.setOnClickListener {
            val view=View.inflate(requireContext(),R.layout.dialog_health,null)
            val builder=AlertDialog.Builder(requireContext())
            builder.setView(view)
            val dialog=builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel_health.setOnClickListener {
                dialog.dismiss()
            }
            view.bmi_calculate.setOnClickListener {
                val intent= Intent(requireActivity(),BmiCalculatorActivity::class.java)
                startActivity(intent)
            }
        }
        time_calculate.setOnClickListener {
            val view=View.inflate(requireContext(),R.layout.dialog_time,null)
            val builder=AlertDialog.Builder(requireContext())
            builder.setView(view)
            val dialog=builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel_time.setOnClickListener {
                dialog.dismiss()
            }

        }
        converter_calculate.setOnClickListener {
            val view=View.inflate(requireContext(),R.layout.dialog_converter,null)
            val builder=AlertDialog.Builder(requireContext())
            builder.setView(view)
            val dialog=builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel_converter.setOnClickListener {
                dialog.dismiss()
            }
            view.Area_calculate.setOnClickListener {
                val intent= Intent(requireActivity(),AreaCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.dataStorage_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),DataCalcualatorActivity::class.java)
                startActivity(intent)
            }
            view.length_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),LengthCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.mass_Calculate.setOnClickListener {
                val intent=Intent(requireActivity(),MassCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.speed_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),SpeedCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.temperature_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),TemparatureCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.timee_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),TimeCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.acceleration_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),AccelerationCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.angle_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),AngleCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.fuel_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),FuelCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.cooking_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),CookingCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.transfer_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),DataTransferCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.pressure_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),PressureCalculaterActivity::class.java)
                startActivity(intent)
            }

            view.energy_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),EnergyCalculatorActivity::class.java)
                startActivity(intent)
            }

            view.force_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),ForceCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.power_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),PowerCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.torque_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),TorqueCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.volume_Calculate.setOnClickListener {
                val intent=Intent(requireActivity(),VolumeCalculatorActivity::class.java)
                startActivity(intent)
            }
            view.volumetric_flow_calculate.setOnClickListener {
                val intent=Intent(requireActivity(),VolumetricFlowCalculatorActivity::class.java)
                startActivity(intent)
            }

        }



    }


}