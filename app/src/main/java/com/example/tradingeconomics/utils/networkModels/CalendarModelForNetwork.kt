package com.example.tradingeconomics.utils.networkModels

import com.google.gson.annotations.SerializedName

data class CalendarModelForNetwork(
    @SerializedName("Event")
    val event: String,

    @SerializedName("Date")
    val date: String,

    @SerializedName("Country")
    val country: String,

    @SerializedName("Reference")
    val reference: String,

    @SerializedName("Actual")
    val actual: String,

    @SerializedName("Previous")
    val previous: String
)
