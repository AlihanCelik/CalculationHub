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
import java.text.DecimalFormat
import kotlin.math.*

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager



class AdvancedCalculatorActivity : AppCompatActivity() {
    private var isSecondEnable = true
    private var isDegreeEnable = true
    private var scriptEngine: ScriptEngine? = null
    var answer=""
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
                R.id.btnZero -> {addTextCalculate("0")
                    equalClicked()}
                R.id.btnOne -> {addTextCalculate("1")
                    equalClicked()}
                R.id.btnTwo -> {addTextCalculate("2")
                    equalClicked()
                }
                R.id.btnThree -> {addTextCalculate("3")
                    equalClicked()
                }
                R.id.btnFour -> {addTextCalculate("4")
                    equalClicked()}
                R.id.btnFive -> {
                    addTextCalculate("5")
                    equalClicked()
                }
                R.id.btnSix -> {
                    addTextCalculate("6")
                    equalClicked()}
                R.id.btnSeven -> {addTextCalculate("7")
                    equalClicked()}
                R.id.btnEight -> {addTextCalculate("8")
                    equalClicked()}
                R.id.btnNine -> {addTextCalculate("9")
                    equalClicked()}

                // Scientific
                R.id.btnSecond -> {
                    changingSecond()
                    equalClicked()
                }
                R.id.btnDegree -> {
                    changingDegree()
                    equalClicked()
                }
                R.id.btnSin -> {
                    if (isSecondEnable) {
                        addTextCalculate("sin(")
                        equalClicked()
                    } else {
                        addTextCalculate("arcsin(")
                        equalClicked()
                    }

                }
                R.id.btnCos -> {
                    if (isSecondEnable) {
                        addTextCalculate("cos(")
                        equalClicked()
                    } else {
                        addTextCalculate("arccos(")
                        equalClicked()
                    }

                }
                R.id.btnTan -> {
                    if (isSecondEnable) {
                        addTextCalculate("tan(")
                        equalClicked()
                    } else {
                        addTextCalculate("arctan(")
                        equalClicked()
                    }

                }

                R.id.btnPower -> {
                    addTextCalculate("^(")
                    equalClicked()
                }
                R.id.btnLog -> {
                    addTextCalculate("lg(")
                    equalClicked()
                }
                R.id.btnNaturalLog -> {
                    addTextCalculate("ln(")
                    equalClicked()
                }
                R.id.btnSquareRoot -> {
                    addTextCalculate("\u221a(")
                    equalClicked()
                }

                R.id.btnExponent ->{
                    addTextCalculate("e")
                    equalClicked()
                }
                R.id.btnMultiplicativeInverse -> {
                    addTextCalculate("^(-1)")
                    equalClicked()
                }


                R.id.btnMod ->{
                    addTextCalculate("abs(")
                    equalClicked()
                }

                R.id.btnPi -> {
                    addTextCalculate("\u03c0")
                    equalClicked()
                }
                R.id.btnParenthesisStart -> {
                    addTextCalculate("(")
                    equalClicked()
                }
                R.id.btnParenthesisClose -> {
                    addTextCalculate(")")
                    equalClicked()
                }

                // Operations

                R.id.btnAllClear -> {
                    clearTextAll()
                    equalClicked()
                }
                R.id.btnBackClear -> {
                    cleatTextLast()
                    equalClicked()
                }


                R.id.btnPercentage -> {
                    if (tvInputCalculation.text.toString().isNotEmpty())
                        calculate(tvInputCalculation.text.toString() + "%")
                    equalClicked()
                }
                R.id.btnDivision -> {
                    addOperands("÷")
                    equalClicked()
                }
                R.id.btnMultiplication -> {
                    addOperands("x")
                    equalClicked()
                }
                R.id.btnSubtraction -> {
                    addOperands("-")
                    equalClicked()
                }
                R.id.btnAddition -> {
                    addOperands("+")
                    equalClicked()
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
        tvInputCalculation.text = answer
    }


    @SuppressLint("SetTextI18n")
    private fun calculate(input: String) {
        val trimmedInput = input.trim()
        if (trimmedInput.isNotEmpty()) {
            if (isOperands(trimmedInput.last().toString())) {
                // Remove the trailing operator
                val processedInput = trimmedInput.dropLast(1)
                performCalculation(processedInput)
            } else {
                performCalculation(trimmedInput)
            }
        }
    }

    private fun performCalculation(input: String) {
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
                            "Math.pow(${originalList.substring(i + 1, indexesList[index])},"
                        )

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
        answer = result
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





}