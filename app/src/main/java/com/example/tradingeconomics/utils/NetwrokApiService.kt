package com.example.tradingeconomics.utils

import com.example.tradingeconomics.models.CalendarModel
import com.example.tradingeconomics.models.News
import com.example.tradingeconomics.utils.networkModels.CalendarModelForNetwork
import com.example.tradingeconomics.utils.networkModels.Commodities
import com.example.tradingeconomics.utils.networkModels.StocksCurreciesBonds
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.tradingeconomics.com/"

private const val API_KEY = "8o2n5okr3l4imkm:o34zoehsw6hewfw"
private const val API_KEY_GUEST = "guest:guest"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService{

    @GET("news")
    fun getNews(
        @Query("c") key: String = API_KEY
    ): Call<List<News>>

    @GET("markets/index")
    fun getStock(
        @Query("c") key: String = API_KEY_GUEST
    ): Call<List<StocksCurreciesBonds>>

    @GET("markets/currency")
    fun getCurrencies(
        @Query("c") key: String = API_KEY_GUEST
    ): Call<List<StocksCurreciesBonds>>

    @GET("markets/commodities")
    fun getCommodities(
        @Query("c") key: String = API_KEY_GUEST
    ): Call<List<Commodities>>

    @GET("markets/bond")
    fun getBonds(
        @Query("c") key: String = API_KEY_GUEST
    ): Call<List<StocksCurreciesBonds>>

    @GET("calendar")
    fun getCalendar(
        @Query("c") key: String = API_KEY_GUEST,
    ): Call<List<CalendarModelForNetwork>>

}

object Api{
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}