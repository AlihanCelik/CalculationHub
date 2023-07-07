package com.example.calculatorapp.servis

import com.example.calculatorapp.model.baseAnyCurrencyModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServisAny {
    val BASE_URL="https://api.exchangerate.host/"
    val api=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(APIANYCURRENCY::class.java)
    fun getData(baseName:String):Single<baseAnyCurrencyModel>{
        return api.getAnyCurrencyBilgi(baseName)
    }
}