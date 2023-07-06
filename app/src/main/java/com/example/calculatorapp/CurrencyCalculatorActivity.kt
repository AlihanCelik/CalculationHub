package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_currency_calculator.*
import kotlinx.android.synthetic.main.activity_currency_calculator.backButton
import kotlinx.android.synthetic.main.activity_currency_calculator.btn_AC

class CurrencyCalculatorActivity : AppCompatActivity() {
    var curtext = true
    var cur2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false

    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_calculator)
        backButton.setOnClickListener {
            finish()
        }
        curText.setOnClickListener {
            curtext=true
            cur2text=false
            dotPressed=false
            curText.setTextColor(colorYellow)
            cur2Text.setTextColor(colorGrey)
            cur2Text.text="00"
            curText.text="00"
        }
        cur2Text.setOnClickListener {
            curtext=false
            cur2text=true
            dotPressed2=false
            curText.setTextColor(colorGrey)
            cur2Text.setTextColor(colorYellow)
            curText.text="00"
            cur2Text.text="00"
        }


    }
    fun onDigitClick(view: View){
        if(curtext){
            if(curText.text.toString()=="00"){
                curText.text=""
            }
            if (stateEror){
                curText.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed){
                    curText.append((view as Button).text)
                    dotPressed=true
                }else if((view as Button).text!="."){
                    curText.append((view as Button).text)

                }

                btn_AC.text="C"
            }

        }else{
            if(cur2Text.text.toString()=="00"){
                cur2Text.text=""
            }
            if (stateEror){
                cur2Text.text=(view as Button).text
                stateEror=false
                btn_AC.text="C"
            }else{
                if((view as Button).text=="."&& !dotPressed2){
                    cur2Text.append((view as Button).text)
                    dotPressed2=true
                }else if((view as Button).text!="."){
                    cur2Text.append((view as Button).text)

                }
                btn_AC.text="C"
            }
        }
    }
    fun onAcClick(view: View){
        if(curtext){
            curText.text="00"
            btn_AC.text="AC"
            dotPressed=false
        }else{
            cur2Text.text="00"
            btn_AC.text="AC"
            dotPressed2=false
        }


    }
    fun onClearClick(view: View){
        if(curtext){
            if (curText.text.toString().isNotEmpty()) {
                val lastChar = curText.text.toString()[curText.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed = false
                }
                curText.text = curText.text.toString().dropLast(1)
            }
            if(curText.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }else{
            if (cur2Text.text.toString().isNotEmpty()) {
                val lastChar = cur2Text.text.toString()[cur2Text.text.toString().length - 1]
                if (lastChar == '.') {
                    dotPressed2 = false
                }
                cur2Text.text = cur2Text.text.toString().dropLast(1)
            }
            if(cur2Text.text.toString()==""){
                btn_AC.text="AC"
            }else{
                btn_AC.text="C"
            }
        }
    }
}