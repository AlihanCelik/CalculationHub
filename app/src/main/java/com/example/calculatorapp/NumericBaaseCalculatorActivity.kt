package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_numeric_baase_calculator.*
import kotlinx.android.synthetic.main.activity_numeric_baase_calculator.backButton
import kotlinx.android.synthetic.main.activity_numeric_baase_calculator.btn_AC

class NumericBaaseCalculatorActivity : AppCompatActivity() {
    var numtext = true
    var num2text = false
    var stateEror = false
    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow = resources.getColor(R.color.yellow)
        val colorGrey = resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numeric_baase_calculator)
        backButton.setOnClickListener {
            finish()
        }
        numSelect.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(
                    this@NumericBaaseCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_numeric,
                findViewById(R.id.bottomSheetNumeric)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.binary).setOnClickListener {
                textNum.text = "(2)"
                numNameText.text = "Binary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
                stateEror = false
            }
            bottomSheetView.findViewById<View>(R.id.trinary).setOnClickListener {
                textNum.text = "(3)"
                numNameText.text = "Trinary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quaternary).setOnClickListener {
                textNum.text = "(4)"
                numNameText.text = "Quaternary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quinary).setOnClickListener {
                textNum.text = "(5)"
                numNameText.text = "Quinary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.senary).setOnClickListener {
                textNum.text = "(6)"
                numNameText.text = "Senary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.septenary).setOnClickListener {
                textNum.text = "(7)"
                numNameText.text = "Septenary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.octal).setOnClickListener {
                textNum.text = "(8)"
                numNameText.text = "Octal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.nonary).setOnClickListener {
                textNum.text = "(9)"
                numNameText.text = "Nonary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.undenary).setOnClickListener {
                textNum.text = "(A)"
                numNameText.text = "Undenary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.duodecimal).setOnClickListener {
                textNum.text = "(B)"
                numNameText.text = "Duodecinmal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Tridecimal).setOnClickListener {
                textNum.text = "(C)"
                numNameText.text = "Tridecimal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quattuordecimal).setOnClickListener {
                textNum.text = "(D)"
                numNameText.text = "Quattuordecimal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quindecimal).setOnClickListener {
                textNum.text = "(E)"
                numNameText.text = "Quindecimal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.hexadecimal).setOnClickListener {
                textNum.text = "(F)"
                numNameText.text = "Hexadecimal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.decimal).setOnClickListener {
                textNum.text = "(10)"
                numNameText.text = "Decimal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }


            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()
        }
        num2Select.setOnClickListener {
            val bottomSheet =
                BottomSheetDialog(
                    this@NumericBaaseCalculatorActivity,
                    R.style.BottomSheetDialogTheme
                )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_numeric,
                findViewById(R.id.bottomSheetNumeric)
            ) as ConstraintLayout
            bottomSheetView.findViewById<View>(R.id.binary).setOnClickListener {
                text2Num.text = "(2)"
                num2NameText.text = "Binary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.trinary).setOnClickListener {
                text2Num.text = "(3)"
                num2NameText.text = "Trinary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quaternary).setOnClickListener {
                text2Num.text = "(4)"
                num2NameText.text = "Quaternary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quinary).setOnClickListener {
                text2Num.text = "(5)"
                num2NameText.text = "Quinary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.senary).setOnClickListener {
                text2Num.text = "(6)"
                num2NameText.text = "Senary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.septenary).setOnClickListener {
                text2Num.text = "(7)"
                num2NameText.text = "Septenary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.octal).setOnClickListener {
                text2Num.text = "(8)"
                num2NameText.text = "Octal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.nonary).setOnClickListener {
                text2Num.text = "(9)"
                num2NameText.text = "Nonary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.undenary).setOnClickListener {
                text2Num.text = "(A)"
                num2NameText.text = "Undenary"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.duodecimal).setOnClickListener {
                text2Num.text = "(B)"
                num2NameText.text = "Duodecinmal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.Tridecimal).setOnClickListener {
                text2Num.text = "(C)"
                num2NameText.text = "Tridecimal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quattuordecimal).setOnClickListener {
                text2Num.text = "(D)"
                num2NameText.text = "Quattuordecimal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.quindecimal).setOnClickListener {
                text2Num.text = "(E)"
                num2NameText.text = "Quindecimal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.hexadecimal).setOnClickListener {
                text2Num.text = "(F)"
                num2NameText.text = "Hexadecimal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }
            bottomSheetView.findViewById<View>(R.id.decimal).setOnClickListener {
                text2Num.text = "(10)"
                num2NameText.text = "Decimal"
                numText.text = "00"
                num2Text.text = "00"
                bottomSheet.dismiss()
            }


            bottomSheetView.findViewById<View>(R.id.linearLayout2).setOnClickListener {
                bottomSheet.dismiss()

            }
            bottomSheet.setContentView(bottomSheetView)
            bottomSheet.setCancelable(false)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.show()
        }
        numText.setOnClickListener {
            numtext = true
            num2text = false
            numText.setTextColor(colorYellow)
            num2Text.setTextColor(colorGrey)
            num2Text.text = "00"
            numText.text = "00"
        }
        num2Text.setOnClickListener {
            numtext = false
            num2text = true
            numText.setTextColor(colorGrey)
            num2Text.setTextColor(colorYellow)
            numText.text = "00"
            num2Text.text = "00"
        }
    }

    fun onDigitClick(view: View) {
        if (numtext) {
            if (numText.text.toString() == "00") {
                numText.text = ""
            }
            if (stateEror) {
                if (textNum.text.toString() == "(2)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1") {
                        numText.text = (view as Button).text

                    }
                } else if (textNum.text.toString() == "(3)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2"
                    ) {
                        numText.text = (view as Button).text

                    }
                } else if (textNum.text.toString() == "(4)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(5)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(6)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(7)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2" || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(8)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2" || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(9)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(10)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(A)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(B)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A" || (view as Button).text.toString() == "B"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(C)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(D)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D"
                    ) {
                        numText.text = (view as Button).text
                    }
                } else if (textNum.text.toString() == "(E)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D" || (view as Button).text.toString() == "E"
                    ) {
                        numText.text = (view as Button).text

                    }
                } else if (textNum.text.toString() == "(F)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D" || (view as Button).text.toString() == "E"
                        || (view as Button).text.toString() == "F"
                    ) {
                        numText.text = (view as Button).text

                    }
                }

                stateEror = false
                btn_AC.text = "C"
            } else {
                if (textNum.text.toString() == "(2)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1") {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(3)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(4)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(5)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(6)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(7)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2" || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(8)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2" || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(9)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(10)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(A)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(B)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A" || (view as Button).text.toString() == "B"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(C)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(D)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(E)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D" || (view as Button).text.toString() == "E"
                    ) {
                        numText.append((view as Button).text)
                    }
                } else if (textNum.text.toString() == "(F)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D" || (view as Button).text.toString() == "E"
                        || (view as Button).text.toString() == "F"
                    ) {
                        numText.append((view as Button).text)
                    }
                }





                btn_AC.text = "C"
            }

        } else {
            if (num2Text.text.toString() == "00") {
                num2Text.text = ""
            }
            if (stateEror) {
                if (text2Num.text.toString() == "(2)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1") {
                        num2Text.text = (view as Button).text

                    }
                } else if (text2Num.text.toString() == "(3)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2"
                    ) {
                        num2Text.text = (view as Button).text

                    }
                } else if (text2Num.text.toString() == "(4)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(5)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(6)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(7)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2" || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(8)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2" || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(9)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(10)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(A)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(B)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A" || (view as Button).text.toString() == "B"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(C)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(D)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D"
                    ) {
                        num2Text.text = (view as Button).text
                    }
                } else if (text2Num.text.toString() == "(E)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D" || (view as Button).text.toString() == "E"
                    ) {
                        num2Text.text = (view as Button).text

                    }
                } else if (text2Num.text.toString() == "(F)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D" || (view as Button).text.toString() == "E"
                        || (view as Button).text.toString() == "F"
                    ) {
                        num2Text.text = (view as Button).text

                    }
                }

                stateEror = false
                btn_AC.text = "C"
            } else {

                if (text2Num.text.toString() == "(2)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1") {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(3)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(4)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(5)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(6)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(7)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2" || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(8)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1"
                        || (view as Button).text.toString() == "2" || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(9)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(10)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(A)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(B)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A" || (view as Button).text.toString() == "B"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(C)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(D)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(E)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D" || (view as Button).text.toString() == "E"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                } else if (text2Num.text.toString() == "(F)") {
                    if ((view as Button).text.toString() == "0" || (view as Button).text.toString() == "1" || (view as Button).text.toString() == "2"
                        || (view as Button).text.toString() == "3" || (view as Button).text.toString() == "4"
                        || (view as Button).text.toString() == "5" || (view as Button).text.toString() == "6"
                        || (view as Button).text.toString() == "7" || (view as Button).text.toString() == "8"
                        || (view as Button).text.toString() == "9" || (view as Button).text.toString() == "A"
                        || (view as Button).text.toString() == "B" || (view as Button).text.toString() == "C"
                        || (view as Button).text.toString() == "D" || (view as Button).text.toString() == "E"
                        || (view as Button).text.toString() == "F"
                    ) {
                        num2Text.append((view as Button).text)
                    }
                }


                btn_AC.text = "C"
            }
        }
    }

    fun onAcClick(view: View) {
        if (numtext) {
            numText.text = "00"
            btn_AC.text = "AC"
        } else {
            num2Text.text = "00"
            btn_AC.text = "AC"
        }


    }

    fun onClearClick(view: View) {
        if (numtext) {
            if (numText.text.toString().isNotEmpty()) {

                numText.text = numText.text.toString().dropLast(1)
            }
            if (numText.text.toString() == "") {
                btn_AC.text = "AC"
            } else {
                btn_AC.text = "C"
            }
        } else {
            if (num2Text.text.toString().isNotEmpty()) {

                num2Text.text = num2Text.text.toString().dropLast(1)
            }
            if (num2Text.text.toString() == "") {
                btn_AC.text = "AC"
            } else {
                btn_AC.text = "C"
            }
        }
    }

    fun onEnterClick(view: View) {

        if (numtext) {
            var inputSize = "00"
            if (numText.text.toString() == "") {
                inputSize = "00"
            } else {
                inputSize = numText.text.toString()
            }
            var inputUnit = numNameText.text.toString()
            var outputUnit = num2NameText.text.toString()
            var outputSize = convertNumber(inputSize, outputUnit, inputUnit)
            num2Text.text = outputSize
        } else {
            var inputSize = "00"
            if (num2Text.text.toString() == "") {
                inputSize = "00"
            } else {
                inputSize = num2Text.text.toString()
            }
            var inputUnit = num2NameText.text.toString()
            var outputUnit = numNameText.text.toString()
            var outputArea = convertNumber(inputSize, outputUnit, inputUnit)
            numText.text = outputArea
        }


    }


    fun convertNumber(inputNumber: String, outputUnit: String, inputUnit: String): String {
        val bases = mapOf(
            "binary" to 2,
            "decimal" to 10,
            "hexadecimal" to 16,
            "trinary" to 3,
            "quaternary" to 4,
            "quinary" to 5,
            "senary" to 6,
            "septenary" to 7,
            "octal" to 8,
            "nonary" to 9,
            "undenary" to 11,
            "duodecimal" to 12,
            "tridecimal" to 13,
            "quayyuodecimal" to 14,
            "quindecimal" to 15
        )

        val inputBase = bases[inputUnit.toLowerCase()] ?: throw IllegalArgumentException("Invalid input unit.")
        val outputBase = bases[outputUnit.toLowerCase()] ?: throw IllegalArgumentException("Invalid output unit.")

        val decimalValue = inputNumber.toBigInteger(inputBase)
        return decimalValue.toString(outputBase)
    }
}
