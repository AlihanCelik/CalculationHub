package com.example.calculatorapp.servis

import com.example.calculatorapp.model.baseAnyCurrencyModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIANYCURRENCY {
    @GET("latest?")
    fun getAnyCurrencyBilgi(@Query("base") baseName:String) :Single<baseAnyCurrencyModel>
}