package com.example.calculatorapp

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_advanced_calculator.*
import java.lang.Math.pow
import kotlin.math.*

class AdvancedCalculatorActivity : AppCompatActivity() {
    companion object {
        var addedSC = false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_calculator)
        change_screen.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        addNumberValueToText(this, bt0SC, tvPrimarySC, 1)
        addNumberValueToText(this, bt1SC, tvPrimarySC, 1)
        addNumberValueToText(this, bt2SC, tvPrimarySC, 1)
        addNumberValueToText(this, bt3SC, tvPrimarySC, 1)
        addNumberValueToText(this, bt4SC, tvPrimarySC, 1)
        addNumberValueToText(this, bt5SC, tvPrimarySC, 1)
        addNumberValueToText(this, bt6SC, tvPrimarySC, 1)
        addNumberValueToText(this, bt7SC, tvPrimarySC, 1)
        addNumberValueToText(this, bt8SC, tvPrimarySC, 1)
        addNumberValueToText(this, bt9SC, tvPrimarySC, 1)
        addNumberValueToText(this, btSin, tvPrimarySC, 1)
        addNumberValueToText(this, btCos, tvPrimarySC, 1)
        addNumberValueToText(this, btTan, tvPrimarySC, 1)
        addNumberValueToText(this, btLog, tvPrimarySC, 1)
        addNumberValueToText(this, btLn, tvPrimarySC, 1)
        addNumberValueToText(this, btBracketOpenSC, tvPrimarySC, 1)
        addNumberValueToText(this, btBracketCloseSC, tvPrimarySC, 1)

        addOperatorValueToText(this, btAdditionSC, tvPrimarySC, "+", 1)
        addOperatorValueToText(this, btSubtractionSC, tvPrimarySC, "-", 1)
        addOperatorValueToText(this, btMultiplicationSC, tvPrimarySC, "*", 1)
        addOperatorValueToText(this, btDivisionSC, tvPrimarySC, "/", 1)

        btDotSC.setOnClickListener {
            vibratePhone(this)
            if (!tvPrimarySC.text.contains(".")) tvPrimarySC.text = tvPrimarySC.text.toString() + "."
        }

        btPi.setOnClickListener {
            vibratePhone(this)

            tvPrimarySC.text = tvPrimarySC.text.toString() + "3.142"
            tvSecondarySC.text = btPi.text.toString()
        }

        btFactorial.setOnClickListener {
            vibratePhone(this)

            try {
                if (tvPrimarySC.text.isEmpty()) enterNumberToast(this)
                else {
                    val input = tvPrimarySC.text.toString()
                    var factorial = 1.0
                    for (i in 1..input.toLong()) {
                        factorial *= i
                    }
                    tvPrimarySC.text = trimResult(factorial.toString())
                    tvSecondarySC.text = "$input!"
                }
            } catch (e: Exception) {
                invalidInputToast(this)
            }
        }

        btSquare.setOnClickListener {
            vibratePhone(this)

            try {
                if (tvPrimarySC.text.isEmpty()) enterNumberToast(this)
                else {
                    val input = tvPrimarySC.text.toString()
                    val result = (input.toFloat() * input.toFloat()).toString()
                    tvPrimarySC.text = trimResult(result)
                    tvSecondarySC.text = "$input²"
                }
            } catch (e: Exception) {
                invalidInputToast(this)
            }
        }

        btInverted.setOnClickListener {
            vibratePhone(this)

            try {
                if (tvPrimarySC.text.isEmpty()) enterNumberToast(this)
                else {
                    val input = tvPrimarySC.text.toString()
                    val result = (1 / input.toFloat()).toString()
                    tvPrimarySC.text = trimResult(result)
                    tvSecondarySC.text = "1/$input"
                }
            } catch (e: Exception) {
                invalidInputToast(this)
            }
        }

        btSqrt.setOnClickListener {
            vibratePhone(this)

            try {
                if (tvPrimarySC.text.isEmpty()) enterNumberToast(this)
                else {
                    val input = tvPrimarySC.text.toString()
                    val result = (sqrt(input.toFloat())).toString()
                    tvPrimarySC.text = trimResult(result)
                    tvSecondarySC.text = "√$input"
                }
            } catch (e: Exception) {
                invalidInputToast(this)
            }
        }
        btCube.setOnClickListener {
            vibratePhone(this)

            try {
                if (tvPrimarySC.text.isEmpty()) enterNumberToast(this)
                else {
                    val input = tvPrimarySC.text.toString()
                    val result = (input.toFloat() * input.toFloat()* input.toFloat()).toString()
                    tvPrimarySC.text = trimResult(result)
                    tvSecondarySC.text = "$input³"
                }
            } catch (e: Exception) {
                invalidInputToast(this)
            }
        }

        btACSC.setOnClickListener {
            vibratePhone(this)

            tvPrimarySC.text = ""
            tvSecondarySC.text = ""
            addedSC = false
        }

        btDeleteSC.setOnClickListener {
            vibratePhone(this)

            if (tvPrimarySC.text.contains("+") ||
                tvPrimarySC.text.contains("-") ||
                tvPrimarySC.text.contains("*") ||
                tvPrimarySC.text.contains("/")
            ) addedSC = false

            if (tvPrimarySC.text.isNotEmpty()) tvPrimarySC.text = tvPrimarySC.text.subSequence(0, tvPrimarySC.length() - 1)
        }

        btEqualSC.setOnClickListener {
            vibratePhone(this)

            try {
                if (tvPrimarySC.text.isNotEmpty()) {
                    val input = tvPrimarySC.text.toString()
                    val result = evaluate(input).toString()
                    tvPrimarySC.text = trimResult(result)
                    tvSecondarySC.text = input
                    addedSC = false
                }
            } catch (e: Exception) {
                invalidInputToast(this)
            }
        }
    }
    fun addNumberValueToText(context: Context, buttonId: Button, textViewId: TextView, id: Int?) {
        buttonId.setOnClickListener {
            vibratePhone(context)
            textViewId.text = "${textViewId.text}${buttonId.text}"
            when (id) {
                1 -> addedSC = false
            }
        }
    }

    fun addOperatorValueToText(context: Context, buttonId: Button, textViewId: TextView, text: String, id: Int) {
        buttonId.setOnClickListener {
            vibratePhone(context)

            when (id) {
                1 -> {
                    if (addedSC) textViewId.text = textViewId.text.subSequence(0, textViewId.length() - 1)
                    textViewId.text = textViewId.text.toString() + text
                    addedSC = true
                }
            }
        }
    }

    fun vibratePhone(context: Context) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 29) vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK))
        else vibrator.vibrate(10)
    }

    fun enterNumberToast(context: Context) {
        Toast.makeText(context, context.getString(R.string.enter_number), Toast.LENGTH_SHORT).show()
    }

    fun invalidInputToast(context: Context) {
        Toast.makeText(context, context.getString(R.string.invalid_input), Toast.LENGTH_SHORT).show()
    }

    fun evaluate(input: String): Float {
        return object : Any() {
            var position = -1
            var char = 0
            var x = 0F

            fun moveToNextChar() {
                char = if (++position < input.length) input[position].code else -1
            }

            fun checkAndRemove(charToRemove: Int): Boolean {
                while (char == ' '.code) moveToNextChar()

                if (char == charToRemove) {
                    moveToNextChar()
                    return true
                }
                return false
            }

            fun parse(): Float {
                moveToNextChar()
                x = parseAddSub()

                if (position < input.length) throw RuntimeException("Unexpected: " + char.toChar())
                return x
            }

            fun parseAddSub(): Float {
                x = parseMulDiv()

                while (true) {
                    when {
                        checkAndRemove('+'.code) -> x += parseMulDiv()
                        checkAndRemove('-'.code) -> x -= parseMulDiv()
                        else -> return x
                    }
                }
            }

            fun parseMulDiv(): Float {
                x = parseOther()

                while (true) {
                    when {
                        checkAndRemove('*'.code) -> x *= parseOther()
                        checkAndRemove('/'.code) -> x /= parseOther()
                        else -> return x
                    }
                }
            }

            fun parseOther(): Float {
                if (checkAndRemove('+'.code)) return parseOther()
                if (checkAndRemove('-'.code)) return -parseOther()

                val startPosition = position

                if (checkAndRemove('('.code)) {
                    x = parseAddSub()
                    checkAndRemove(')'.code)
                } else if (char >= '0'.code && char <= '9'.code || char == '.'.code) {
                    while (char >= '0'.code && char <= '9'.code || char == '.'.code) moveToNextChar()
                    x = input.substring(startPosition, position).toFloat()
                } else if (char >= 'a'.code && char <= 'z'.code) {
                    while (char >= 'a'.code && char <= 'z'.code) moveToNextChar()
                    val function = input.substring(startPosition, position)
                    x = parseOther()
                    x = when (function) {
                        "sin" -> sin(Math.toRadians(x.toDouble())).toFloat()
                        "cos" -> cos(Math.toRadians(x.toDouble())).toFloat()
                        "tan" -> tan(Math.toRadians(x.toDouble())).toFloat()
                        "log" -> log10(x)
                        "ln" -> ln(x)
                        else -> throw RuntimeException("Unknown function: $function")
                    }
                } else throw RuntimeException("Unexpected: " + char.toChar())
                if (checkAndRemove('^'.code)) x = x.pow(parseOther())
                return x
            }
        }.parse()
    }

    fun trimResult(result: String?): String? {
        return if (!result.isNullOrEmpty()) {
            if (result.indexOf(".") < 0) result
            else result.replace("0*$".toRegex(), "").replace("\\.$".toRegex(), "")
        } else result
    }

}