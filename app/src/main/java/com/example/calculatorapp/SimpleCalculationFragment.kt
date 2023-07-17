package com.example.calculatorapp

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import android.view.accessibility.AccessibilityEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope

import com.example.calculatorapp.databinding.FragmentSimpleCalculationBinding
import kotlinx.android.synthetic.main.activity_advanced_calculator.*
import kotlinx.android.synthetic.main.fragment_simple_calculation.*
import kotlinx.android.synthetic.main.fragment_simple_calculation.backspaceButton
import kotlinx.android.synthetic.main.fragment_simple_calculation.btnAddition
import kotlinx.android.synthetic.main.fragment_simple_calculation.btnPercentage
import kotlinx.android.synthetic.main.fragment_simple_calculation.btnSubtraction
import kotlinx.android.synthetic.main.fragment_simple_calculation.change_screen
import kotlinx.android.synthetic.main.fragment_simple_calculation.input
import kotlinx.android.synthetic.main.fragment_simple_calculation.resultDisplay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormatSymbols
import java.util.*


class SimpleCalculationFragment : Fragment(R.layout.fragment_simple_calculation) {
    private val decimalSeparatorSymbol =
        DecimalFormatSymbols.getInstance().decimalSeparator.toString()
    private val groupingSeparatorSymbol =
        DecimalFormatSymbols.getInstance().groupingSeparator.toString()

    private var isEqualLastAction = false
    private var isDegreeModeActivated = true
    private var calculationResult = BigDecimal.ZERO
    private var _binding: FragmentSimpleCalculationBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSimpleCalculationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        change_screen.setOnClickListener{
            val intent=Intent(requireActivity(),AdvancedCalculatorActivity::class.java)
            startActivity(intent)
        }
        btn_0.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        btn_1.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        btn_2.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        btn_3.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        btn_4.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        btn_5.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        btn_6.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        btn_7.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        btn_8.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        btn_9.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        btn_8.setOnClickListener {
            keyDigitPadMappingToDisplay(it)
        }
        buttonA.setOnClickListener {
            clearButton(it)
        }
        btn_divide.setOnClickListener {
            divideButton(it)
        }
        btn_multiply.setOnClickListener {
            multiplyButton(it)
        }
        btnSubtraction.setOnClickListener {
            subtractButton(it)
        }
        btnAddition.setOnClickListener {
            addButton(it)
        }
        btn_equal.setOnClickListener {
            equalsButton(it)
        }
        btn_dot.setOnClickListener {
            pointButton(it)
        }
        btnPercentage.setOnClickListener {
            percent(it)
        }
        backspaceButton.setOnClickListener {
            backspaceButton(it)
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
                    if (MyPreferences(requireActivity()).longClickToCopyValue) {
                        val clipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        clipboardManager.setPrimaryClip(
                            ClipData.newPlainText(
                                "Copied result",
                                resultDisplay.text
                            )
                        )
                        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2)
                            Toast.makeText(requireActivity(), R.string.value_copied, Toast.LENGTH_SHORT).show()
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
        input.showSoftInputOnFocus = false


    }
    private fun roundResult(result: BigDecimal): BigDecimal {
        val numberPrecision = MyPreferences(requireActivity()).numberPrecision!!.toInt()
        var newResult = result.setScale(numberPrecision, RoundingMode.HALF_EVEN)
        if (MyPreferences(requireActivity()).numberIntoScientificNotation && (newResult >= BigDecimal(9999) || newResult <= BigDecimal(
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
                    Calculator(MyPreferences(requireActivity()).numberPrecision!!.toInt()).evaluate(
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

                    if (!MyPreferences(requireActivity()).numberIntoScientificNotation ||
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


    private fun keyVibration(view: View) {
        if (MyPreferences(requireActivity()).vibrationMode) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                view.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
            }
        }
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
            }
        }
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


    fun pointButton(view: View) {
        updateDisplay(view, decimalSeparatorSymbol)
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
    fun keyDigitPadMappingToDisplay(view: View) {
        updateDisplay(view, (view as Button).text as String)
    }
    fun clearButton(view: View) {
        keyVibration(view)
        input.setText("")
        resultDisplay.text = ""
    }
    fun percent(view: View) {
        addSymbol(view, "%")
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