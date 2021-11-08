package com.example.tradingeconomics.models

data class Market(
    val title: String,
    val country: String,
    val value: Double,
    val dailyChange: Double
)
