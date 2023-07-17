package com.example.calculatorapp

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.HapticFeedbackConstants
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.widget.Button
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_advanced_calculator.*
import kotlinx.android.synthetic.main.activity_advanced_calculator.backspaceButton
import kotlinx.android.synthetic.main.activity_advanced_calculator.change_screen
import kotlinx.android.synthetic.main.activity_advanced_calculator.horizontalScrolV
import kotlinx.android.synthetic.main.activity_advanced_calculator.input
import kotlinx.android.synthetic.main.activity_advanced_calculator.resultDisplay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormatSymbols
import java.util.*



class AdvancedCalculatorActivity : AppCompatActivity() {
    private val decimalSeparatorSymbol =
        DecimalFormatSymbols.getInstance().decimalSeparator.toString()
    private val groupingSeparatorSymbol =
        DecimalFormatSymbols.getInstance().groupingSeparator.toString()

    private var isInvButtonClicked = false
    private var isEqualLastAction = false
    private var isDegreeModeActivated = true
    private var calculationResult = BigDecimal.ZERO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_calculator)
        window.navigationBarColor = Color.BLACK
        change_screen.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        if (MyPreferences(this).useRadiansByDefault) {
            toggleDegreeMode()
        }
        backspaceButton.setOnLongClickListener {
            input.setText("")
            resultDisplay.text = ""
            true
        }


        input.requestFocus()


        input.accessibilityDelegate = object : View.AccessibilityDelegate() {
            override fun sendAccessibilityEvent(host: View, eventType: Int) {
                super.sendAccessibilityEvent(host, eventType)
                if (eventType == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED) {
                    isEqualLastAction = false
                }
                if (!input.isCursorVisible) {
                    input.isCursorVisible = true
                }
            }
        }
        resultDisplay.setOnLongClickListener {
            when {
                resultDisplay.text.toString() != "" -> {
                    if (MyPreferences(this).longClickToCopyValue) {
                        val clipboardManager =
                            getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                        clipboardManager.setPrimaryClip(
                            ClipData.newPlainText(
                                "Copied result",
                                resultDisplay.text
                            )
                        )
                        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2)
                            Toast.makeText(this, R.string.value_copied, Toast.LENGTH_SHORT).show()
                        true
                    } else {
                        false
                    }
                }

                else -> false
            }
        }

        input.addTextChangedListener(object : TextWatcher {
            private var beforeTextLength = 0

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                beforeTextLength = s?.length ?: 0
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateResultDisplay()

            }

            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }
        })
        val input = findViewById<EditText>(R.id.input)
        input.showSoftInputOnFocus = false

    }

    private fun updateDisplay(view: View, value: String) {
        // Reset input with current number if following "equal"
        if (isEqualLastAction) {
            val anyNumber = "0123456789$decimalSeparatorSymbol".toCharArray().map {
                it.toString()
            }
            if (anyNumber.contains(value)) {
                input.setText("")
            } else {
                input.setSelection(input.text.length)
                horizontalScrolV.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
            }
            isEqualLastAction = false
        }

        if (!input.isCursorVisible) {
            input.isCursorVisible = true
        }

        lifecycleScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) {
                // Vibrate when key pressed
                keyVibration(view)
            }

            val formerValue = input.text.toString()
            val cursorPosition = input.selectionStart
            val leftValue = formerValue.subSequence(0, cursorPosition).toString()
            val rightValue = formerValue.subSequence(cursorPosition, formerValue.length).toString()

            val newValue = leftValue + value + rightValue

            var newValueFormatted =
                NumberFormatter.format(newValue, decimalSeparatorSymbol, groupingSeparatorSymbol)

            withContext(Dispatchers.Main) {
                if (value == decimalSeparatorSymbol && decimalSeparatorSymbol in input.text.toString()) {
                    if (input.text.toString().isNotEmpty()) {
                        var lastNumberBefore = ""
                        if (cursorPosition > 0 && input.text.toString()
                                .substring(0, cursorPosition)
                                .last() in "0123456789\\$decimalSeparatorSymbol"
                        ) {
                            lastNumberBefore = NumberFormatter.extractNumbers(
                                input.text.toString().substring(0, cursorPosition),
                                decimalSeparatorSymbol
                            ).last()
                        }
                        var firstNumberAfter = ""
                        if (cursorPosition < input.text.length - 1) {
                            firstNumberAfter = NumberFormatter.extractNumbers(
                                input.text.toString()
                                    .substring(cursorPosition, input.text.length),
                                decimalSeparatorSymbol
                            ).first()
                        }
                        if (decimalSeparatorSymbol in lastNumberBefore || decimalSeparatorSymbol in firstNumberAfter) {
                            return@withContext
                        }
                    }
                }
                if (input.text.isNotEmpty()
                    && cursorPosition > 0
                    && decimalSeparatorSymbol in value
                    && value != decimalSeparatorSymbol
                ) {
                    if (NumberFormatter.extractNumbers(value, decimalSeparatorSymbol)
                            .isNotEmpty()
                    ) {
                        val firstValueNumber =
                            NumberFormatter.extractNumbers(value, decimalSeparatorSymbol).first()
                        val lastValueNumber =
                            NumberFormatter.extractNumbers(value, decimalSeparatorSymbol).last()
                        if (decimalSeparatorSymbol in firstValueNumber || decimalSeparatorSymbol in lastValueNumber) {
                            var numberBefore =
                                input.text.toString().substring(0, cursorPosition)
                            if (numberBefore.last() !in "()*-/+^!√πe") {
                                numberBefore = NumberFormatter.extractNumbers(
                                    numberBefore,
                                    decimalSeparatorSymbol
                                ).last()
                            }
                            var numberAfter = ""
                            if (cursorPosition < input.text.length - 1) {
                                numberAfter = NumberFormatter.extractNumbers(
                                    input.text.toString()
                                        .substring(cursorPosition, input.text.length),
                                    decimalSeparatorSymbol
                                ).first()
                            }
                            var tmpValue = value
                            var numberBeforeParenthesisLength = 0
                            if (decimalSeparatorSymbol in numberBefore) {
                                numberBefore = "($numberBefore)"
                                numberBeforeParenthesisLength += 2
                            }
                            if (decimalSeparatorSymbol in numberAfter) {
                                tmpValue = "($value)"
                            }
                            val tmpNewValue = input.text.toString().substring(
                                0,
                                (cursorPosition + numberBeforeParenthesisLength - numberBefore.length)
                            ) + numberBefore + tmpValue + rightValue
                            newValueFormatted = NumberFormatter.format(
                                tmpNewValue,
                                decimalSeparatorSymbol,
                                groupingSeparatorSymbol
                            )
                        }
                    }
                }

                input.setText(newValueFormatted)

                val cursorOffset = newValueFormatted.length - newValue.length
                input.setSelection(cursorPosition + value.length + cursorOffset)
                horizontalScrolV.postDelayed({
                    val width = horizontalScrolV.getChildAt(0).width
                    horizontalScrolV.smoothScrollTo(width, 0)
                }, 100)
            }
        }
    }

    private fun roundResult(result: BigDecimal): BigDecimal {
        val numberPrecision = MyPreferences(this).numberPrecision!!.toInt()
        var newResult = result.setScale(numberPrecision, RoundingMode.HALF_EVEN)
        if (MyPreferences(this).numberIntoScientificNotation && (newResult >= BigDecimal(9999) || newResult <= BigDecimal(
                0.1
            ))
        ) {
            val scientificString = String.format(Locale.US, "%.4g", result)
            newResult = BigDecimal(scientificString)
        }

        // Fix how is displayed 0 with BigDecimal
        val tempResult = newResult.toString().replace("E-", "").replace("E", "")
        val allCharsEqualToZero = tempResult.all { it == '0' }
        if (
            allCharsEqualToZero
            || newResult.toString().startsWith("0E")
        ) {
            return BigDecimal.ZERO
        }

        return newResult
    }


    // Switch between degree and radian mode
    private fun toggleDegreeMode() {
        if (isDegreeModeActivated) degreeButton.text = getString(R.string.radian)
        else degreeButton.text = getString(R.string.degree)


        // Flip the variable afterwards
        isDegreeModeActivated = !isDegreeModeActivated
    }

    private fun updateResultDisplay() {
        lifecycleScope.launch(Dispatchers.Default) {

            val calculation = input.text.toString()

            if (calculation != "") {
                division_by_0 = false
                domain_error = false
                syntax_error = false
                is_infinity = false

                val calculationTmp = Expression().getCleanExpression(
                    input.text.toString(),
                    decimalSeparatorSymbol,
                    groupingSeparatorSymbol
                )
                calculationResult =
                    Calculator(MyPreferences(this@AdvancedCalculatorActivity).numberPrecision!!.toInt()).evaluate(
                        calculationTmp,
                        isDegreeModeActivated
                    )

                if (!(division_by_0 || domain_error || syntax_error || is_infinity)) {
                    calculationResult = roundResult(calculationResult)
                    var formattedResult = NumberFormatter.format(
                        calculationResult.toString().replace(".", decimalSeparatorSymbol),
                        decimalSeparatorSymbol,
                        groupingSeparatorSymbol
                    )

                    if (!MyPreferences(this@AdvancedCalculatorActivity).numberIntoScientificNotation ||
                        !(calculationResult >= BigDecimal(9999) || calculationResult <= BigDecimal(0.1))
                    ) {
                        val resultSplited = calculationResult.toString().split('.')
                        if (resultSplited.size > 1) {
                            val resultPartAfterDecimalSeparator = resultSplited[1].trimEnd('0')
                            var resultWithoutZeros = resultSplited[0]
                            if (resultPartAfterDecimalSeparator != "") {
                                resultWithoutZeros =
                                    resultSplited[0] + "." + resultPartAfterDecimalSeparator
                            }
                            formattedResult = NumberFormatter.format(
                                resultWithoutZeros.replace(".", decimalSeparatorSymbol),
                                decimalSeparatorSymbol,
                                groupingSeparatorSymbol
                            )
                        }
                    }

                    // Check if the result is too large for standard notation
                    val scientificNotationThreshold = BigDecimal(1e12)
                    if (calculationResult.abs() >= scientificNotationThreshold) {
                        val scientificString = String.format(Locale.US, "%.9E", calculationResult)
                        formattedResult = NumberFormatter.format(
                            scientificString.replace(".", decimalSeparatorSymbol),
                            decimalSeparatorSymbol,
                            groupingSeparatorSymbol
                        )
                    }

                    withContext(Dispatchers.Main) {
                        if (formattedResult != calculation) {
                            resultDisplay.text = formattedResult
                        } else {
                            resultDisplay.text = ""
                        }
                    }

                } else withContext(Dispatchers.Main) {
                    if (is_infinity && !division_by_0 && !domain_error) {
                        if (calculationResult < BigDecimal.ZERO) resultDisplay.text =
                            "-" + getString(
                                R.string.infinity
                            )
                        else resultDisplay.text = getString(R.string.value_too_large)
                    } else {
                        withContext(Dispatchers.Main) {
                            resultDisplay.text = ""
                        }
                    }
                }
            } else {
                withContext(Dispatchers.Main) {
                    resultDisplay.text = ""
                }
            }
        }
    }

    fun keyDigitPadMappingToDisplay(view: View) {
        updateDisplay(view, (view as Button).text as String)
    }


    private fun addSymbol(view: View, currentSymbol: String) {

        val textLength = input.text.length

        if (textLength > 0) {

            val cursorPosition = input.selectionStart

            val nextChar =
                if (textLength - cursorPosition > 0) input.text[cursorPosition].toString() else "0" // use "0" as default like it's not a symbol
            val previousChar =
                if (cursorPosition > 0) input.text[cursorPosition - 1].toString() else "0"

            if (currentSymbol != previousChar
                && currentSymbol != nextChar
                && previousChar != "√"
                && previousChar != decimalSeparatorSymbol
                && nextChar != decimalSeparatorSymbol
                && (previousChar != "("
                        || currentSymbol == "-")
            ) {
                if (previousChar.matches("[+\\-÷×^]".toRegex())) {
                    keyVibration(view)

                    val leftString =
                        input.text.subSequence(0, cursorPosition - 1).toString()
                    val rightString =
                        input.text.subSequence(cursorPosition, textLength).toString()

                    // Add a parenthesis if there is another symbol before minus
                    if (currentSymbol == "-") {
                        if (previousChar in "+-") {
                            input.setText(leftString + currentSymbol + rightString)
                            input.setSelection(cursorPosition)
                        } else {
                            input.setText(leftString + previousChar + currentSymbol + rightString)
                            input.setSelection(cursorPosition + 1)
                        }
                    } else if (cursorPosition > 1 && input.text[cursorPosition - 2] != '(') {
                        input.setText(leftString + currentSymbol + rightString)
                        input.setSelection(cursorPosition)
                    } else if (currentSymbol == "+") {
                        input.setText(leftString + rightString)
                        input.setSelection(cursorPosition - 1)
                    }
                }
                // If next character is a symbol, replace it
                else if (nextChar.matches("[+\\-÷×^%!]".toRegex())
                    && currentSymbol != "%"
                ) { // Make sure that percent symbol doesn't replace succeeding symbols
                    keyVibration(view)

                    val leftString = input.text.subSequence(0, cursorPosition).toString()
                    val rightString =
                        input.text.subSequence(cursorPosition + 1, textLength).toString()

                    if (cursorPosition > 0 && previousChar != "(") {
                        input.setText(leftString + currentSymbol + rightString)
                        input.setSelection(cursorPosition + 1)
                    } else if (currentSymbol == "+") input.setText(leftString + rightString)
                }

                else if (cursorPosition > 0 || nextChar != "0" && currentSymbol == "-") {
                    updateDisplay(view, currentSymbol)
                } else keyVibration(view)
            } else keyVibration(view)
        } else {
            if (currentSymbol == "-") updateDisplay(view, currentSymbol)
            else keyVibration(view)
        }
    }

    private fun keyVibration(view: View) {
        if (MyPreferences(this).vibrationMode) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                view.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
            }
        }
    }

    fun addButton(view: View) {
        addSymbol(view, "+")
    }

    fun subtractButton(view: View) {
        addSymbol(view, "-")
    }

    fun divideButton(view: View) {
        addSymbol(view, "÷")
    }

    fun multiplyButton(view: View) {
        addSymbol(view, "×")
    }

    fun exponentButton(view: View) {
        addSymbol(view, "^")
    }

    fun pointButton(view: View) {
        updateDisplay(view, decimalSeparatorSymbol)
    }

    fun sineButton(view: View) {
        if (!isInvButtonClicked) {
            updateDisplay(view, "sin(")
        } else {
            updateDisplay(view, "sin⁻¹(")
        }
    }

    fun cosineButton(view: View) {
        if (!isInvButtonClicked) {
            updateDisplay(view, "cos(")
        } else {
            updateDisplay(view, "cos⁻¹(")
        }
    }

    fun tangentButton(view: View) {
        if (!isInvButtonClicked) {
            updateDisplay(view, "tan(")
        } else {
            updateDisplay(view, "tan⁻¹(")
        }
    }

    fun eButton(view: View) {
        updateDisplay(view, "e")
    }

    fun naturalLogarithmButton(view: View) {
        if (!isInvButtonClicked) {
            updateDisplay(view, "ln(")
        } else {
            updateDisplay(view, "exp(")
        }
    }

    fun logarithmButton(view: View) {
        if (!isInvButtonClicked) {
            updateDisplay(view, "log(")
        } else {
            updateDisplay(view, "10^")
        }
    }

    fun piButton(view: View) {
        updateDisplay(view, "π")
    }
    fun factorialButton(view: View) {
        addSymbol(view, "!")
    }
    fun MultiplicativeInverse(view:View){
        updateDisplay(view, "^-1")
    }


    fun squareButton(view: View) {
        if (!isInvButtonClicked) {
            updateDisplay(view, "√")
        } else {
            if (MyPreferences(this).addModuloButton) {
                updateDisplay(view, "^2")
            } else {
                updateDisplay(view, "√")
            }

        }
    }

    fun percent(view: View) {
        addSymbol(view, "%")
    }

    @SuppressLint("SetTextI18n")
    fun degreeButton(view: View) {
        keyVibration(view)
        toggleDegreeMode()
        updateResultDisplay()
    }

    fun invButton(view: View) {
        keyVibration(view)

        if (!isInvButtonClicked) {
            isInvButtonClicked = true

            // change buttons
            sineButton.setText(R.string.sineInv)
            cosineButton.setText(R.string.cosineInv)
            tangentButton.setText(R.string.tangentInv)
            naturalLogarithmButton.setText(R.string.naturalLogarithmInv)
            logarithmButton.setText(R.string.logarithmInv)
            if (MyPreferences(this).addModuloButton) {
                squareButton.setText(R.string.squareInvModuloVersion)
            } else {
                squareButton.setText(R.string.squareInv)
            }

        } else {
            isInvButtonClicked = false

            // change buttons
            sineButton.setText(R.string.sine)
            cosineButton.setText(R.string.cosine)
            tangentButton.setText(R.string.tangent)
            naturalLogarithmButton.setText(R.string.naturalLogarithm)
            logarithmButton.setText(R.string.logarithm)
            squareButton.setText(R.string.square)
        }
    }

    fun clearButton(view: View) {
        keyVibration(view)
        input.setText("")
        resultDisplay.text = ""
    }

    @SuppressLint("SetTextI18n")
    fun equalsButton(view: View) {
        lifecycleScope.launch(Dispatchers.Default) {
            keyVibration(view)

            val calculation = input.text.toString()

            if (calculation != "") {

                val resultString = calculationResult.toString()
                var formattedResult = NumberFormatter.format(
                    resultString.replace(".", decimalSeparatorSymbol),
                    decimalSeparatorSymbol,
                    groupingSeparatorSymbol
                )

                // If result is a number and it is finite
                if (!(division_by_0 || domain_error || syntax_error || is_infinity)) {

                    // Remove zeros at the end of the results (after point)
                    val resultSplited = resultString.split('.')
                    if (resultSplited.size > 1) {
                        val resultPartAfterDecimalSeparator = resultSplited[1].trimEnd('0')
                        var resultWithoutZeros = resultSplited[0]
                        if (resultPartAfterDecimalSeparator != "") {
                            resultWithoutZeros =
                                resultSplited[0] + "." + resultPartAfterDecimalSeparator
                        }
                        formattedResult = NumberFormatter.format(
                            resultWithoutZeros.replace(
                                ".",
                                decimalSeparatorSymbol
                            ), decimalSeparatorSymbol, groupingSeparatorSymbol
                        )
                    }

                    withContext(Dispatchers.Main) {
                        input.isCursorVisible = false
                    }

                    withContext(Dispatchers.Main) { input.setText(formattedResult) }

                    withContext(Dispatchers.Main) {
                        input.setSelection(input.length())

                        input.isCursorVisible = false
                        resultDisplay.text = ""
                    }


                    isEqualLastAction = true
                } else {
                    withContext(Dispatchers.Main) {
                        if (syntax_error) {

                            resultDisplay.text = getString(R.string.syntax_error)
                        } else if (domain_error) {

                            resultDisplay.text = getString(R.string.domain_error)
                        } else if (division_by_0) {

                            resultDisplay.text = getString(R.string.division_by_0)
                        } else if (is_infinity) {
                            if (calculationResult < BigDecimal.ZERO) resultDisplay.text = "-" + getString(
                                R.string.infinity
                            )
                            else resultDisplay.text = getString(R.string.value_too_large)

                        } else {
                            resultDisplay.text = formattedResult
                            isEqualLastAction =
                                true
                        }
                    }
                }

            } else {
                withContext(Dispatchers.Main) { resultDisplay.text = "" }
            }
        }
    }



    fun leftParenthesisButton(view: View) {
        updateDisplay(view, "(")
    }

    fun rightParenthesisButton(view: View) {
        updateDisplay(view, ")")
    }

    fun parenthesesButton(view: View) {
        val cursorPosition = input.selectionStart
        val textLength = input.text.length

        var openParentheses = 0
        var closeParentheses = 0

        val text = input.text.toString()

        for (i in 0 until cursorPosition) {
            if (text[i] == '(') {
                openParentheses += 1
            }
            if (text[i] == ')') {
                closeParentheses += 1
            }
        }

        if (
            !(textLength > cursorPosition && input.text.toString()[cursorPosition] in "×÷+-^")
            && (
                    openParentheses == closeParentheses
                            || input.text.toString()[cursorPosition - 1] == '('
                            || input.text.toString()[cursorPosition - 1] in "×÷+-^"
                    )
        ) {
            updateDisplay(view, "(")
        } else {
            updateDisplay(view, ")")
        }
    }

    fun backspaceButton(view: View) {
        keyVibration(view)

        var cursorPosition = input.selectionStart
        val textLength = input.text.length
        var newValue = ""
        var isFunction = false
        var functionLength = 0

        if (isEqualLastAction) {
            cursorPosition = textLength
        }

        if (cursorPosition != 0 && textLength != 0) {
            // Check if it is a function to delete
            val functionsList =
                listOf("cos⁻¹(", "sin⁻¹(", "tan⁻¹(", "cos(", "sin(", "tan(", "ln(", "log(", "exp(")
            for (function in functionsList) {
                val leftPart = input.text.subSequence(0, cursorPosition).toString()
                if (leftPart.endsWith(function)) {
                    newValue = input.text.subSequence(0, cursorPosition - function.length)
                        .toString() +
                            input.text.subSequence(cursorPosition, textLength).toString()
                    isFunction = true
                    functionLength = function.length - 1
                    break
                }
            }
            // Else
            if (!isFunction) {
                // remove the grouping separator
                val leftPart = input.text.subSequence(0, cursorPosition).toString()
                val leftPartWithoutSpaces = leftPart.replace(groupingSeparatorSymbol, "")
                functionLength = leftPart.length - leftPartWithoutSpaces.length

                newValue = leftPartWithoutSpaces.subSequence(0, leftPartWithoutSpaces.length - 1)
                    .toString() +
                        input.text.subSequence(cursorPosition, textLength).toString()
            }

            val newValueFormatted =
                NumberFormatter.format(newValue, decimalSeparatorSymbol, groupingSeparatorSymbol)
            var cursorOffset = newValueFormatted.length - newValue.length
            if (cursorOffset < 0) cursorOffset = 0

            input.setText(newValueFormatted)
            input.setSelection((cursorPosition - 1 + cursorOffset - functionLength).takeIf { it > 0 }
                ?: 0)
        }
    }
}


