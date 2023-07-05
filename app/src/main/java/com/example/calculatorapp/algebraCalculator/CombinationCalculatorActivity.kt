package com.example.calculatorapp.algebraCalculator

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculatorapp.R
import kotlinx.android.synthetic.main.activity_combination_calculator.*
import kotlinx.android.synthetic.main.activity_combination_calculator.linearLayout2
import kotlinx.android.synthetic.main.activity_combination_calculator.method
import kotlinx.android.synthetic.main.dialog_combination_solutions.view.*
import java.lang.Math.pow
import java.math.BigInteger


class CombinationCalculatorActivity : AppCompatActivity() {
    var n=0
    var r=0
    var order=true
    var repeatable=true

    var answer=""
    var solution=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combination_calculator)
        backButton.setOnClickListener {
            finish()
        }
        linearLayout2.setOnClickListener {
            if (N_value.text.toString() == "") {
                n = 0
            } else {
                n = N_value.text.toString().toInt()
            }
            if (R_value.text.toString() == "") {
                r = 0
            } else {
                r = R_value.text.toString().toInt()
            }
            if(n==0 && r==0){
                answer="-"
                solution=""
            }else{
                if(order){
                        if(repeatable){
                            var cevap= pow(n.toDouble(),r.toDouble())
                            answer=cevap.toString()
                            solution="n = $n\nr = $r\nPermutations = $n to the power $r\n= $answer"
                        }else{
                            if(r>=n-1){
                                answer="-"
                                solution=""

                            }else{
                                var cevap= ((calculateFactorial(n))/calculateFactorial((n-r)))
                                answer=cevap.toString()
                                solution="n = $n\nr = $r\nPermutations = $n! / ($n - $r)!\n= ${calculateFactorial(n)} / ${calculateFactorial(n-r)}\n= $answer"
                            }
                        }
                }else{
                    if(repeatable){
                        var cevap= ((calculateFactorial((n+r)-1))/(calculateFactorial(r)*calculateFactorial((n-1))))
                        answer=cevap.toString()
                        solution="n = $n\nr = $r\nCombinations = ($n + $r - 1)! / $r! x ($n -1)!\n= (${n+r-1})! / $r! x ${n-1}!\n" +
                                "= ${calculateFactorial(n+r-1)} / ${calculateFactorial(r)} x ${calculateFactorial(n-1)}\n" +
                                "= ${calculateFactorial(n + r - 1)} / ${calculateFactorial(r)*calculateFactorial(n - 1)}\n" +
                                "= $answer"
                    }else{
                        if(r>=n-1){
                            answer="-"
                            solution=""

                        }else{
                            var cevap= ((calculateFactorial(n))/(calculateFactorial(r) * calculateFactorial(n-r)))
                            answer=cevap.toString()
                            solution="n = $n\n" +
                                    "r = $r\n" +
                                    "Combinations = $n! / $r! x ($n - $r)!\n" +
                                    "= $n! / $r! x ${n-r}\n= ${calculateFactorial(n)} / ${calculateFactorial(r)} x ${calculateFactorial(n-r)}\n" +
                                    "= ${calculateFactorial(n)} / ${calculateFactorial(r) * calculateFactorial(n-r)}\n" +
                                    "= $answer"
                        }
                    }
                }
            }
            val view = View.inflate(this, R.layout.dialog_combination_solutions, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            if(order){
                view.per_combText.text="Permutations"
            }else{
                view.per_combText.text="Combinations"
            }
            view.cp_answer.text=answer
            view.solutions.text=solution
        }
    }
    fun calculateFactorial(n: Int): BigInteger {


        var result = BigInteger.ONE
        for (i in 1..n) {
            result = result.multiply(BigInteger.valueOf(i.toLong()))
        }
        return result
    }
    fun YesOrderClick(view: View){
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        method.text="nʳ"
        order=true
        yesOrderedText.setTextColor(colorYellow)
        noOrderedText.setTextColor(colorGrey)

    }
    fun NoOrderClick(view: View){
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        method.text="(n + r - 1)! / r! x (n - 1)!"
        order=false
        yesOrderedText.setTextColor(colorGrey)
        noOrderedText.setTextColor(colorYellow)

    }
    fun YesRepeatableClick(view: View){
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        if(order){
            method.text="nʳ"
        }
        if(!order){
            method.text="(n + r - 1)! / r! x (n - 1)!"

        }
        yesRepeatableText.setTextColor(colorYellow)
        noRepeatableText.setTextColor(colorGrey)
        repeatable=true

    }
    fun NoRepeatableClick(view: View){
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        if(order){
            method.text="n! / (n - r)!"
        }
        if(!order){
            method.text="n! / r! x (n - r)!"

        }
        yesRepeatableText.setTextColor(colorGrey)
        noRepeatableText.setTextColor(colorYellow)
        repeatable=false



    }

}