package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.calculatorapp.databinding.FragmentSimpleCalculationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_simple_calculation.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.security.cert.Extension

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var viewPagerAdapter: VpAdapter
    private lateinit var binding: FragmentSimpleCalculationBinding
    private lateinit var expression:Expression
    var lastNumeric=false
    var stateEror=false
    var lastDot=false
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        bottomNavigation = findViewById(R.id.bottomNav)

        viewPagerAdapter = VpAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = viewPagerAdapter

        // BottomNavigationView'daki öğeleri dinlemek için Listener ekleyin
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            val index = when (menuItem.itemId) {
                R.id.home -> 0
                R.id.trans -> 1
                R.id.trans2 -> 2
                // Diğer menü öğeleri için de durumları ekleyin
                else -> 0
            }
            viewPager.currentItem = index
            true
        }

        // ViewPager'ı dinlemek için Listener ekleyin
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNavigation.menu.getItem(position).isChecked = true
            }
        })

        // ViewPager'a fragment ekleyin
        viewPagerAdapter.addFragment(SimpleCalculationFragment(), "Home")
        viewPagerAdapter.addFragment(categoryFragment(), "Category")
        viewPagerAdapter.addFragment(FinanceCategoryFragment(),"Finance")

        // İlk olarak seçili fragment'i belirtin
        viewPager.currentItem = 0
    }
    fun onDigitClick(view: View) {
        if(stateEror){
            process.text=(view as Button).text
            stateEror=false
        }else{
            val buttonText = (view as Button).text
            val currentText = process.text.toString()
            if (currentText.isEmpty() && buttonText == ".") {
                process.text = "0."
                lastDot = true
                lastNumeric = true
                return
            }
            if (buttonText == "." && (lastDot || !lastNumeric)) {
                return
            }

            process.append(buttonText)
            if (buttonText == ".") {
                lastDot = true
            }

        }
        lastNumeric=true

        onEqual()
    }
    fun onOperatorClick(view: View) {
        if(!stateEror&&lastNumeric){
            process.append((view as Button).text)
            lastDot=false
            lastNumeric=false
            onEqual()
        }
    }
    fun onBackClick(view: View) {
        process.text=process.text.toString().dropLast(1)
        try {
            val lastChar=process.text.toString().last()
            if(lastChar.isDigit()){
                onEqual()
                buttonA.text="C"
            }
        }catch (e:Exception){
            result.text=""
            result.visibility=View.GONE
            Log.e("last char error",e.toString())
            buttonA.text="AC"
        }
    }
    fun onAllClearClick(view: View) {
        process.text=""
        result.text=""
        stateEror=false
        lastDot=false
        lastNumeric=false
        buttonA.text="AC"
        result.visibility=View.GONE
    }
    fun onEqualClick(view: View) {
        onEqual()
        process.text=result.text.toString().drop(1)
    }
    fun onEqual(){
        if(lastNumeric&&!stateEror){
            val txt=process.text.toString()
            expression= ExpressionBuilder(txt).build()
            try {
                val result2=expression.evaluate()
                result.visibility=View.VISIBLE
                result.text="= "+result2.toString()
                buttonA.text="C"
            }catch (ex:ArithmeticException){
                Log.e("evaluate error",ex.toString())
                result.text="Error"
                stateEror=true
                lastNumeric=false

            }
        }
    }


}
