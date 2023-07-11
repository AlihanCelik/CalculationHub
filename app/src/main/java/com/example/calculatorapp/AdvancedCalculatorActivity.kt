package com.example.calculatorapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_advanced_calculator.*
import java.math.BigDecimal
import java.math.BigInteger
import java.text.DecimalFormat
import kotlin.math.*

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager



class AdvancedCalculatorActivity : AppCompatActivity() {
    private var isSecondEnable = true
    private var isDegreeEnable = true
    private var scriptEngine: ScriptEngine? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_calculator)
        scriptEngine = ScriptEngineManager().getEngineByName("rhino")
        change_screen.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

        fun onClickMethod(view: View) {
            when (view.id) {

                // Numbers
                R.id.btnDot -> {
                    if (!tvInputCalculation.text.toString().contains(".")) {
                        addTextCalculate(".")
                    }
                }
                R.id.btnZero -> addTextCalculate("0")
                R.id.btnOne -> addTextCalculate("1")
                R.id.btnTwo -> addTextCalculate("2")
                R.id.btnThree -> addTextCalculate("3")
                R.id.btnFour -> addTextCalculate("4")
                R.id.btnFive -> addTextCalculate("5")
                R.id.btnSix -> addTextCalculate("6")
                R.id.btnSeven -> addTextCalculate("7")
                R.id.btnEight -> addTextCalculate("8")
                R.id.btnNine -> addTextCalculate("9")

                // Scientific
                R.id.btnSecond -> {
                    changingSecond()
                }
                R.id.btnDegree -> {
                    changingDegree()
                }
                R.id.btnSin -> {
                    if (isSecondEnable) {
                        addTextCalculate("sin(")
                    } else {
                        addTextCalculate("arcsin(")
                    }

                }
                R.id.btnCos -> {
                    if (isSecondEnable) {
                        addTextCalculate("cos(")
                    } else {
                        addTextCalculate("arccos(")
                    }

                }
                R.id.btnTan -> {
                    if (isSecondEnable) {
                        addTextCalculate("tan(")
                    } else {
                        addTextCalculate("arctan(")
                    }

                }

                R.id.btnPower -> {
                    addTextCalculate("^(")
                }
                R.id.btnLog -> {
                    addTextCalculate("lg(")
                }
                R.id.btnNaturalLog -> {
                    addTextCalculate("ln(")
                }
                R.id.btnSquareRoot -> {
                    addTextCalculate("\u221a(")
                }

                R.id.btnExponent ->{
                    addTextCalculate("e")
                }
                R.id.btnMultiplicativeInverse -> {
                    addTextCalculate("^(-1)")
                }
                R.id.btnSquare -> {
                    addTextCalculate("^(2)")
                }
                R.id.btnCube -> {
                    addTextCalculate("^(3)")
                }

                R.id.btnMod ->{
                    addTextCalculate("abs(")
                }

                R.id.btnPi -> {
                    addTextCalculate("\u03c0")
                }
                R.id.btnParenthesisStart -> {
                    addTextCalculate("(")
                }
                R.id.btnParenthesisClose -> {
                    addTextCalculate(")")
                }

                // Operations

                R.id.btnAllClear -> clearTextAll()
                R.id.btnBackClear -> cleatTextLast()


                R.id.btnPercentage -> {
                    if (tvInputCalculation.text.toString().isNotEmpty())
                        calculate(tvInputCalculation.text.toString() + "%")
                }
                R.id.btnDivision -> {
                    addOperands("÷")
                }
                R.id.btnMultiplication -> {
                    addOperands("x")
                }
                R.id.btnSubtraction -> {
                    addOperands("-")
                }
                R.id.btnAddition -> {
                    addOperands("+")
                }



            }
        }



        @SuppressLint("SetTextI18n")
        private fun addOperands(operands: String) {
            val mText = tvInputCalculation.text.toString()
            if (mText.isEmpty()) {
                addTextCalculate("0${operands}")
            } else {
                if (isOperands(mText.last().toString())) {
                    tvInputCalculation.text = "${mText.dropLast(1)}$operands"
                } else {
                    addTextCalculate(operands)
                }

            }


        }

        private fun isOperands(operands: String): Boolean {
            return operands == "+" || operands == "-" || operands == "x" || operands == "÷"
        }

        @SuppressLint("SetTextI18n")
        private fun addTextCalculate(mData: String) {
            val mText = tvInputCalculation.text.toString()
            tvInputCalculation.text = "$mText$mData"

        }

        private fun clearTextAll() {
            tvInputCalculation.text = ""
            tvEqualCalculation.text = ""
        }

        private fun cleatTextLast() {
            val mText = tvInputCalculation.text.toString()
            if (mText.isNotEmpty()) {
                tvInputCalculation.text = mText.dropLast(1)
            }
        }

        @SuppressLint("SetTextI18n")
        private fun equalClicked() {
            if (tvInputCalculation.text.toString().isNotEmpty()) {
                calculate(tvInputCalculation.text.toString())
            }

        }

    fun onEqualClick(view: View) {
        equalClicked()
    }


    @SuppressLint("SetTextI18n")
    private fun calculate(input: String) {

        val indexesList: List<Int>
        var tempData = ""
        val originalList = "1*($input)"

        var temp: String
        var result: String
        try {
            temp = originalList

            indexesList = originalList.indexesOf("^", false)


            for (index in indexesList.indices) {
                for (i in indexesList[index] - 1 downTo 0) {
                    if (!isDigit(originalList[i])) {
                        Log.i("information", "Start index: $i")
                        Log.i("information", "End index: ${indexesList[index]}")
                        Log.i("information", originalList.substring(i + 1, indexesList[index] + 2))

                        tempData = originalList.substring(i + 1, indexesList[index])
                        temp = temp.replace(
                            "${tempData}\\^\\(".toRegex(),
                            "Math.pow(${originalList.substring(i + 1, indexesList[index])},")

                        break
                    }
                }

            }

            result = scriptEngine?.eval(
                temp.replace("%".toRegex(), "/100")
                    .replace("x".toRegex(), "*")
                    .replace("÷".toRegex(), "/")
                    .replace("sin\\(".toRegex(), "Math.sin(")
                    .replace("cos\\(".toRegex(), "Math.cos(")
                    .replace("abs\\(".toRegex(), "Math.abs(")
                    .replace("tan\\(".toRegex(), "Math.Math.cos(tan(")
                    .replace("arcsin\\(".toRegex(), "Math.sin(")
                    .replace("arccos\\(".toRegex(), "Math.cos(")
                    .replace("arctan\\(".toRegex(), "Math.tan(")
                    .replace("lg\\(".toRegex(), "Math.log10(")
                    .replace("ln\\(".toRegex(), "Math.log(")
                    .replace("\\u221a\\(".toRegex(), "Math.sqrt(")
                    .replace("\\u03c0".toRegex(), "Math.PI")
                    .replace("e".toRegex(), "Math.E")
            ).toString()


            Log.i("information", "Result: $result")
            val decimal = BigDecimal(result)
            result = decimal.setScale(8, BigDecimal.ROUND_HALF_UP).toPlainString()
        } catch (e: Exception) {
            e.printStackTrace()
            tvEqualCalculation.text = "= Wrong Format"
            Log.i("information", e.toString())
            return
        }
        if (result == "Infinity") {
            tvEqualCalculation.text = "= Can't divide by zero"

        } else if (result.contains(".")) {
            result = result.replace("\\.?0*$".toRegex(), "")
            if (result.length > 18) {
                result = handlingLengthyResult(result)
                tvEqualCalculation.text = "= $result"
            } else {
                tvEqualCalculation.text = "= $result"
            }

        }


        tvEqualCalculation.text = "= $result"
    }

        private fun handlingLengthyResult(number: String): String {
            val d = BigDecimal(number)
            val df = DecimalFormat("0.###########E0")
            return df.format(d)
        }

        private fun changingSecond() {
            if (isSecondEnable) {
                isSecondEnable = false
                btnSin.text = resources.getText(R.string.arcsin)
                btnCos.text = resources.getText(R.string.arccos)
                btnTan.text = resources.getText(R.string.arctan)
                btnDegree.isEnabled = false

            } else {
                isSecondEnable = true
                btnSin.text = resources.getText(R.string.sin)
                btnCos.text = resources.getText(R.string.cos)
                btnTan.text = resources.getText(R.string.tan)
                btnDegree.isEnabled = true

            }
        }

        @SuppressLint("SetTextI18n")
        private fun changingDegree() {
            if (isDegreeEnable) {
                isDegreeEnable = false
                btnSecond.isEnabled = false
                btnDegree.text = "rad"

            } else {
                isDegreeEnable = true
                btnDegree.text = "deg"
                btnSecond.isEnabled = true
            }
        }

        private fun String?.indexesOf(substr: String, ignoreCase: Boolean = false): List<Int> {
            return this?.let {
                val indexes = mutableListOf<Int>()
                var startIndex = 0
                while (startIndex in 0 until length) {
                    val index = this.indexOf(substr, startIndex, ignoreCase)
                    startIndex = if (index != -1) {
                        indexes.add(index)
                        index + substr.length
                    } else {
                        index
                    }
                }
                return indexes
            } ?: emptyList()
        }

        private fun isDigit(ch: Char): Boolean {
            return Character.isDigit(ch)
        }

        fun showMessage(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }




}