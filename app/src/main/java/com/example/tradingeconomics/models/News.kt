package com.example.tradingeconomics.models

import com.google.gson.annotations.SerializedName

data class News(

    val title: String,

    val description: String,

    @SerializedName("date")
    val time: String,

    val country: String
)
