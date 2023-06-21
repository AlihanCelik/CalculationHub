package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NumericBaaseCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numeric_baase_calculator)
    }




    fun convertNumber(number: Int, base: Int): String {
        return when (base) {
            2 -> number.toString(2) // Binary
            10 -> number.toString() // Decimal
            16 -> number.toString(16) // Hexadecimal
            3 -> convertToTernary(number) // Trinary
            4 -> convertToQuaternary(number) // Quaternary
            5 -> convertToQuinary(number) // Quinary
            6 -> convertToSenary(number) // Senary
            7 -> convertToSeptenary(number) // Septenary
            8 -> number.toString(8) // Octal
            9 -> convertToNonary(number) // Nonary
            11 -> convertToUndenary(number) // Undenary
            12 -> convertToDuodecimal(number) // Duodecimal
            13 -> convertToTridecimal(number) // Tridecimal
            14 -> convertToQuayyuodecimal(number) // Quayyuodecimal
            15 -> convertToQuindecimal(number) // Quindecimal
            else -> throw IllegalArgumentException("Unsupported base: $base")
        }
    }

    fun convertToTernary(number: Int): String {
        return number.toString(3)
    }

    fun convertToQuaternary(number: Int): String {
        return number.toString(4)
    }

    fun convertToQuinary(number: Int): String {
        return number.toString(5)
    }

    fun convertToSenary(number: Int): String {
        return number.toString(6)
    }

    fun convertToSeptenary(number: Int): String {
        return number.toString(7)
    }

    fun convertToNonary(number: Int): String {
        return number.toString(9)
    }

    fun convertToUndenary(number: Int): String {
        return number.toString(11)
    }

    fun convertToDuodecimal(number: Int): String {
        return number.toString(12)
    }

    fun convertToTridecimal(number: Int): String {
        return number.toString(13)
    }

    fun convertToQuayyuodecimal(number: Int): String {
        return number.toString(14)
    }

    fun convertToQuindecimal(number: Int): String {
        return number.toString(15)
    }
}