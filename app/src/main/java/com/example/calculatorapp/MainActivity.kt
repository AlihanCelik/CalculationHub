package com.example.calculatorapp

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.HapticFeedbackConstants
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_simple_calculation.*
import kotlinx.android.synthetic.main.fragment_simple_calculation.backspaceButton
import kotlinx.android.synthetic.main.fragment_simple_calculation.input
import kotlinx.android.synthetic.main.fragment_simple_calculation.resultDisplay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.objecthunter.exp4j.Expression
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormatSymbols
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var viewPagerAdapter: VpAdapter

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



}
