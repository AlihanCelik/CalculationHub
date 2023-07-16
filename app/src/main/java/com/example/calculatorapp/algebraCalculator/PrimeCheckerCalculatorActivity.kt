package com.example.calculatorapp.algebraCalculator

import android.app.AlertDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculatorapp.R
import kotlinx.android.synthetic.main.activity_prime_checker_calculator.A_value
import kotlinx.android.synthetic.main.activity_prime_checker_calculator.backButton
import kotlinx.android.synthetic.main.activity_prime_checker_calculator.linearLayout2
import kotlinx.android.synthetic.main.dialog_primechecker_solutions.view.*
import kotlinx.android.synthetic.main.dialog_primechecker_solutions.view.cancel

class PrimeCheckerCalculatorActivity : AppCompatActivity() {
    var a=0
    var answer=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prime_checker_calculator)
        window.navigationBarColor = Color.BLACK
        backButton.setOnClickListener {
            finish()
        }
        linearLayout2.setOnClickListener {
             if (A_value.text.toString() == "") {
                a = 0
            } else {
                a = A_value.text.toString().toInt()
            }


            val view = View.inflate(this, R.layout.dialog_primechecker_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            if(isPrime(a)){
                view.pc_answer.text="Yes"
            }else{
                view.pc_answer.text="No"
            }

        }
    }
    fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false
        }

        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}