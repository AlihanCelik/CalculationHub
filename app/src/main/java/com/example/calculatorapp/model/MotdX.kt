package com.example.calculatorapp.model

import com.google.gson.annotations.SerializedName

data class MotdX(
    @SerializedName("msg")
    val msg: String,
    @SerializedName("url")
    val url: String
)