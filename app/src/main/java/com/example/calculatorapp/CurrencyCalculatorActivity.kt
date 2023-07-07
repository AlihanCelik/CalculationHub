package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calculatorapp.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.activity_currency_calculator.*
import kotlinx.android.synthetic.main.activity_currency_calculator.backButton
import kotlinx.android.synthetic.main.activity_currency_calculator.btn_AC

class CurrencyCalculatorActivity : AppCompatActivity() {
    var curtext = true
    var cur2text = false
    var stateEror = false
    var dotPressed = false
    var dotPressed2=false
    var connection=true

    private lateinit var viewModel: CurrencyViewModel
    lateinit var birim2:String
    lateinit var birim3:String

    override fun onCreate(savedInstanceState: Bundle?) {
        val colorYellow=resources.getColor(R.color.yellow)
        val colorGrey=resources.getColor(R.color.grey)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_calculator)
        viewModel= ViewModelProvider(this).get(CurrencyViewModel::class.java)
        val adapter= ArrayAdapter.createFromResource(this,R.array.currency_list,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        secondSpinner.adapter=adapter
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        thirdSpinner.adapter=adapter
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
        secondSpinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                birim2=secondSpinner.adapter.getItem(position).toString()
                viewModel.refreshData1(birim2)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        thirdSpinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                birim3=thirdSpinner.adapter.getItem(position).toString()
                observeLiveData1(birim3)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

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
    fun onEnterClick(view: View){
        if(connection){
            if(curtext){
                var input=0.0
                if(curText.text.toString()==""){
                    input=0.0
                }else{
                    input=curText.text.toString().toDouble()
                }
                val deger2=tutucuText2.text.toString().toDouble()
                cur2Text.text=(input*deger2).toString()
                tutucuText2.text.isEmpty()
            }else{
                var input=0.0
                if(cur2Text.text.toString()==""){
                    input=0.0
                }else{
                    input=cur2Text.text.toString().toDouble()
                }
                val deger2=tutucuText2.text.toString().toDouble()
                curText.text=(input/deger2).toString()
                tutucuText2.text.isEmpty()

            }
        }else{
            
        }




    }
    fun observeLiveData1(karsilastir:String){

        viewModel.bilgilerAnyCurrency.observe(this, Observer {
            it?.let {
                when(karsilastir){
                    "AED" -> tutucuText2.text=(it.rates.aED)!!.toString()
                    "AFN" -> tutucuText2.text=(it.rates.aFN)!!.toString()
                    "ALL" -> tutucuText2.text=(it.rates.aLL)!!.toString()
                    "AMD" -> tutucuText2.text=(it.rates.aMD)!!.toString()
                    "ANG" -> tutucuText2.text=(it.rates.aNG)!!.toString()
                    "AOA" -> tutucuText2.text=(it.rates.aOA)!!.toString()
                    "ARS" -> tutucuText2.text=(it.rates.aRS)!!.toString()
                    "AUD" -> tutucuText2.text=(it.rates.aUD)!!.toString()
                    "AWG"-> tutucuText2.text=(it.rates.aWG)!!.toString()
                    "AZN"-> tutucuText2.text=(it.rates.aZN)!!.toString()
                    "BAM"-> tutucuText2.text=(it.rates.bAM)!!.toString()
                    "BBD"-> tutucuText2.text=(it.rates.bBD)!!.toString()
                    "BDT"-> tutucuText2.text=(it.rates.bDT)!!.toString()
                    "BGN"-> tutucuText2.text=(it.rates.bGN)!!.toString()
                    "BHD"-> tutucuText2.text=(it.rates.bHD)!!.toString()
                    "BIF"-> tutucuText2.text=(it.rates.bIF)!!.toString()
                    "BMD"-> tutucuText2.text=(it.rates.bMD)!!.toString()
                    "BND"-> tutucuText2.text=(it.rates.bND)!!.toString()
                    "BOB"-> tutucuText2.text=(it.rates.bOB)!!.toString()
                    "BRL"-> tutucuText2.text=(it.rates.bRL)!!.toString()
                    "BSD"-> tutucuText2.text=(it.rates.bSD)!!.toString()
                    "BTC"-> tutucuText2.text=(it.rates.bTC)!!.toString()
                    "BTN"-> tutucuText2.text=(it.rates.bTN)!!.toString()
                    "BWP"-> tutucuText2.text=(it.rates.bWP)!!.toString()
                    "BYN"-> tutucuText2.text=(it.rates.bYN)!!.toString()
                    "BZD"-> tutucuText2.text=(it.rates.bZD)!!.toString()
                    "CAD"-> tutucuText2.text=(it.rates.cAD)!!.toString()
                    "CDF"-> tutucuText2.text=(it.rates.cDF)!!.toString()
                    "CHF"-> tutucuText2.text=(it.rates.cHF)!!.toString()
                    "CLF"-> tutucuText2.text=(it.rates.cLF)!!.toString()
                    "CLP"-> tutucuText2.text=(it.rates.cLF)!!.toString()
                    "CNH"-> tutucuText2.text=(it.rates.cNH)!!.toString()
                    "CNY"-> tutucuText2.text=(it.rates.cNH)!!.toString()
                    "COP"-> tutucuText2.text=(it.rates.cOP)!!.toString()
                    "CRC"-> tutucuText2.text=(it.rates.cRC)!!.toString()
                    "CUC"-> tutucuText2.text=(it.rates.cUC)!!.toString()
                    "CUP"-> tutucuText2.text=(it.rates.cUP)!!.toString()
                    "CVE"-> tutucuText2.text=(it.rates.cVE)!!.toString()
                    "CZK"-> tutucuText2.text=(it.rates.cZK)!!.toString()
                    "DJF"-> tutucuText2.text=(it.rates.dJF)!!.toString()
                    "DKK"-> tutucuText2.text=(it.rates.dKK)!!.toString()
                    "DOP"-> tutucuText2.text=(it.rates.dOP)!!.toString()
                    "DZD"-> tutucuText2.text=(it.rates.dZD)!!.toString()
                    "EGP"-> tutucuText2.text=(it.rates.eGP)!!.toString()
                    "ERN"-> tutucuText2.text=(it.rates.eRN)!!.toString()
                    "ETB"-> tutucuText2.text=(it.rates.eTB)!!.toString()
                    "EUR"-> tutucuText2.text=(it.rates.eUR)!!.toString()
                    "FJD"-> tutucuText2.text=(it.rates.fJD)!!.toString()
                    "FKP"-> tutucuText2.text=(it.rates.fKP)!!.toString()
                    "GBP"-> tutucuText2.text=(it.rates.gBP)!!.toString()
                    "GEL"-> tutucuText2.text=(it.rates.gEL)!!.toString()
                    "GGP"-> tutucuText2.text=(it.rates.gGP)!!.toString()
                    "GHS"-> tutucuText2.text=(it.rates.gHS)!!.toString()
                    "GIP"-> tutucuText2.text=(it.rates.gIP)!!.toString()
                    "GMD"-> tutucuText2.text=(it.rates.gMD)!!.toString()
                    "GNF"-> tutucuText2.text=(it.rates.gNF)!!.toString()
                    "GTQ"-> tutucuText2.text=(it.rates.gTQ)!!.toString()
                    "GYD"-> tutucuText2.text=(it.rates.gYD)!!.toString()
                    "HKD"-> tutucuText2.text=(it.rates.hKD)!!.toString()
                    "HNL"-> tutucuText2.text=(it.rates.hNL)!!.toString()
                    "HRK"-> tutucuText2.text=(it.rates.hRK)!!.toString()
                    "HTG"-> tutucuText2.text=(it.rates.hTG)!!.toString()
                    "HUF"-> tutucuText2.text=(it.rates.hUF)!!.toString()
                    "IDR"-> tutucuText2.text=(it.rates.iDR)!!.toString()
                    "ILS"-> tutucuText2.text=(it.rates.iLS)!!.toString()
                    "IMP"-> tutucuText2.text=(it.rates.iMP)!!.toString()
                    "INR"-> tutucuText2.text=(it.rates.iNR)!!.toString()
                    "IQD"-> tutucuText2.text=(it.rates.iQD)!!.toString()
                    "IRR"-> tutucuText2.text=(it.rates.iRR)!!.toString()
                    "ISK"-> tutucuText2.text=(it.rates.iSK)!!.toString()
                    "JEP"-> tutucuText2.text=(it.rates.jEP)!!.toString()
                    "JMD"-> tutucuText2.text=(it.rates.jMD)!!.toString()
                    "JOD"-> tutucuText2.text=(it.rates.jOD)!!.toString()
                    "JPY"-> tutucuText2.text=(it.rates.jPY)!!.toString()
                    "KES"-> tutucuText2.text=(it.rates.kES)!!.toString()
                    "KGS"-> tutucuText2.text=(it.rates.kGS)!!.toString()
                    "KHR"-> tutucuText2.text=(it.rates.kHR)!!.toString()
                    "KMF"-> tutucuText2.text=(it.rates.kMF)!!.toString()
                    "KPW"-> tutucuText2.text=(it.rates.kPW)!!.toString()
                    "KRW"-> tutucuText2.text=(it.rates.kRW)!!.toString()
                    "KWD"-> tutucuText2.text=(it.rates.kWD)!!.toString()
                    "KYD"-> tutucuText2.text=(it.rates.kYD)!!.toString()
                    "KZT"-> tutucuText2.text=(it.rates.kZT)!!.toString()
                    "LAK"-> tutucuText2.text=(it.rates.lAK)!!.toString()
                    "LBP"-> tutucuText2.text=(it.rates.lBP)!!.toString()
                    "LKR"-> tutucuText2.text=(it.rates.lKR)!!.toString()
                    "LRD"-> tutucuText2.text=(it.rates.lRD)!!.toString()
                    "LSL"-> tutucuText2.text=(it.rates.lSL)!!.toString()
                    "LYD"-> tutucuText2.text=(it.rates.lYD)!!.toString()
                    "MAD"-> tutucuText2.text=(it.rates.mAD)!!.toString()
                    "MDL"-> tutucuText2.text=(it.rates.mDL)!!.toString()
                    "MGA"-> tutucuText2.text=(it.rates.mGA)!!.toString()
                    "MKD"-> tutucuText2.text=(it.rates.mKD)!!.toString()
                    "MMK"-> tutucuText2.text=(it.rates.mMK)!!.toString()
                    "MNT"-> tutucuText2.text=(it.rates.mNT)!!.toString()
                    "MOP"-> tutucuText2.text=(it.rates.mOP)!!.toString()
                    "MRU"-> tutucuText2.text=(it.rates.mRU)!!.toString()
                    "MUR"-> tutucuText2.text=(it.rates.mUR)!!.toString()
                    "MVR"-> tutucuText2.text=(it.rates.mVR)!!.toString()
                    "MWK"-> tutucuText2.text=(it.rates.mWK)!!.toString()
                    "MXN"-> tutucuText2.text=(it.rates.mXN)!!.toString()
                    "MYR"-> tutucuText2.text=(it.rates.mYR)!!.toString()
                    "MZN"-> tutucuText2.text=(it.rates.mZN)!!.toString()
                    "NAD"-> tutucuText2.text=(it.rates.nAD)!!.toString()
                    "NGN"-> tutucuText2.text=(it.rates.nGN)!!.toString()
                    "NIO"-> tutucuText2.text=(it.rates.nIO)!!.toString()
                    "NOK"-> tutucuText2.text=(it.rates.nOK)!!.toString()
                    "NPR"-> tutucuText2.text=(it.rates.nPR)!!.toString()
                    "NZD"-> tutucuText2.text=(it.rates.nZD)!!.toString()
                    "OMR"-> tutucuText2.text=(it.rates.oMR)!!.toString()
                    "PAB"-> tutucuText2.text=(it.rates.pAB)!!.toString()
                    "PEN"-> tutucuText2.text=(it.rates.pEN)!!.toString()
                    "PGK"-> tutucuText2.text=(it.rates.pGK)!!.toString()
                    "PHP"-> tutucuText2.text=(it.rates.pHP)!!.toString()
                    "PKR"-> tutucuText2.text=(it.rates.pKR)!!.toString()
                    "PLN"-> tutucuText2.text=(it.rates.pLN)!!.toString()
                    "PYG"-> tutucuText2.text=(it.rates.pYG)!!.toString()
                    "QAR"-> tutucuText2.text=(it.rates.qAR)!!.toString()
                    "RON"-> tutucuText2.text=(it.rates.rON)!!.toString()
                    "RSD"-> tutucuText2.text=(it.rates.rSD)!!.toString()
                    "RUB"-> tutucuText2.text=(it.rates.rUB)!!.toString()
                    "RWF"-> tutucuText2.text=(it.rates.rWF)!!.toString()
                    "SAR"-> tutucuText2.text=(it.rates.sAR)!!.toString()
                    "SBD"-> tutucuText2.text=(it.rates.sBD)!!.toString()
                    "SCR"-> tutucuText2.text=(it.rates.sCR)!!.toString()
                    "SDG"-> tutucuText2.text=(it.rates.sDG)!!.toString()
                    "SEK"-> tutucuText2.text=(it.rates.sEK)!!.toString()
                    "SGD"-> tutucuText2.text=(it.rates.sGD)!!.toString()
                    "SHP"-> tutucuText2.text=(it.rates.sHP)!!.toString()
                    "SLL"-> tutucuText2.text=(it.rates.sLL)!!.toString()
                    "SOS"-> tutucuText2.text=(it.rates.sOS)!!.toString()
                    "SRD"-> tutucuText2.text=(it.rates.sRD)!!.toString()
                    "SSP"-> tutucuText2.text=(it.rates.sSP)!!.toString()
                    "STD"-> tutucuText2.text=(it.rates.sTD)!!.toString()
                    "STN"-> tutucuText2.text=(it.rates.sTN)!!.toString()
                    "SVC"-> tutucuText2.text=(it.rates.sVC)!!.toString()
                    "SYP"-> tutucuText2.text=(it.rates.sYP)!!.toString()
                    "SZL"-> tutucuText2.text=(it.rates.sZL)!!.toString()
                    "THB"-> tutucuText2.text=(it.rates.tHB)!!.toString()
                    "TJS"-> tutucuText2.text=(it.rates.tJS)!!.toString()
                    "TMT"-> tutucuText2.text=(it.rates.tMT)!!.toString()
                    "TND"-> tutucuText2.text=(it.rates.tND)!!.toString()
                    "TOP"-> tutucuText2.text=(it.rates.tOP)!!.toString()
                    "TRY"-> tutucuText2.text=(it.rates.tRY)!!.toString()
                    "TTD"-> tutucuText2.text=(it.rates.tTD)!!.toString()
                    "TWD"-> tutucuText2.text=(it.rates.tWD)!!.toString()
                    "TZS"-> tutucuText2.text=(it.rates.tZS)!!.toString()
                    "UAH"-> tutucuText2.text=(it.rates.uAH)!!.toString()
                    "UGX"-> tutucuText2.text=(it.rates.uGX)!!.toString()
                    "USD"-> tutucuText2.text=(it.rates.uSD)!!.toString()
                    "UYU"-> tutucuText2.text=(it.rates.uYU)!!.toString()
                    "UZS"-> tutucuText2.text=(it.rates.uZS)!!.toString()
                    "VES"-> tutucuText2.text=(it.rates.vES)!!.toString()
                    "VND"-> tutucuText2.text=(it.rates.vND)!!.toString()
                    "VUV"-> tutucuText2.text=(it.rates.vUV)!!.toString()
                    "WST"-> tutucuText2.text=(it.rates.wST)!!.toString()
                    "XAF"-> tutucuText2.text=(it.rates.xAF)!!.toString()
                    "XAG"-> tutucuText2.text=(it.rates.xAG)!!.toString()
                    "XAU"-> tutucuText2.text=(it.rates.xAU)!!.toString()
                    "XCD"-> tutucuText2.text=(it.rates.xCD)!!.toString()
                    "XDR"-> tutucuText2.text=(it.rates.xDR)!!.toString()
                    "XOF"-> tutucuText2.text=(it.rates.xOF)!!.toString()
                    "XPD"-> tutucuText2.text=(it.rates.xPD)!!.toString()
                    "XPF"-> tutucuText2.text=(it.rates.xPF)!!.toString()
                    "XPT"-> tutucuText2.text=(it.rates.xPT)!!.toString()
                    "YER"-> tutucuText2.text=(it.rates.yER)!!.toString()
                    "ZAR"-> tutucuText2.text=(it.rates.zAR)!!.toString()
                    "ZMW"-> tutucuText2.text=(it.rates.zMW)!!.toString()
                    "ZWL"-> tutucuText2.text=(it.rates.zWL)!!.toString()
                }
            }
        })
        hataMesajiandYukleniyor()
    }
        fun hataMesajiandYukleniyor(){

            viewModel.yukleniyor.observe(this, Observer {
                it?.let {
                    if(it){
                        progressBar2.visibility=View.VISIBLE
                        connection=false
                    }
                    else{
                        if (!viewModel.isInternetAvailable(applicationContext)) {
                            progressBar2.visibility = View.VISIBLE
                            connection=false

                        } else {
                            progressBar2.visibility = View.GONE
                            connection=true
                        }
                    }
                }
            })
        }




}