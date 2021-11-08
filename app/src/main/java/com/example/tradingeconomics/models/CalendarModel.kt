package com.example.tradingeconomics.models

import com.google.gson.annotations.SerializedName

data class CalendarModel(

    val event: String,
    val date: String,
    val time: String,
    val country: String,
    val reference: String,
    val actual: String,
    val previous: String

)
