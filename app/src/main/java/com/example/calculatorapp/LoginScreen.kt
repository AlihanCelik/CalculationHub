package com.example.calculatorapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        window.navigationBarColor = Color.BLACK
        val timer=object :CountDownTimer(4000,1000){
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                val intent=Intent(this@LoginScreen,MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        timer.start()
    }


}