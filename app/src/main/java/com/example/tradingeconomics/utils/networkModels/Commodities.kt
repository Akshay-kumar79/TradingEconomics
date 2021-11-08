package com.example.tradingeconomics.utils.networkModels

data class Commodities(
    val Name: String,
    val unit: String,
    val Last: Double,
    val DailyChange: Double
)