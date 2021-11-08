package com.example.tradingeconomics.utils

import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tradingeconomics.models.News
import com.example.tradingeconomics.R
import com.example.tradingeconomics.calendarPage.CalendarAdapter
import com.example.tradingeconomics.marketPage.MarketAdapter
import com.example.tradingeconomics.models.CalendarModel
import com.example.tradingeconomics.models.Market
import com.example.tradingeconomics.newsPage.NewsAdapter


// News page
@BindingAdapter("setCardBackgroundForNewsCountry")
fun setCardBackgroundForNewsCountry(cardView: CardView, country: String){
    if(country.contentEquals("United States"))
        cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.app_blue))
    else
        cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.theme_color_orange))
}

@BindingAdapter("listNews")
fun listNews(recyclerView: RecyclerView, allNews: List<News>?){
    val adapter = recyclerView.adapter as NewsAdapter
    if (allNews != null) {
        adapter.setData(allNews)
    }
}


// Market page
@BindingAdapter("listMarket")
fun listMarket(recyclerView: RecyclerView, marketList: List<Market>?){
    val adapter = recyclerView.adapter as MarketAdapter
    if(marketList != null){
        adapter.setData(marketList)
    }
}

@BindingAdapter("changeListLayout")
fun changeListLayout(recyclerView: RecyclerView, selected: String){
    val adapter = recyclerView.adapter as MarketAdapter
    adapter.changeLayout(selected)
}

@BindingAdapter("addFlagImage")
fun addFlagImage(imageView: ImageView, country: String){
    Glide.with(imageView.context).load("https://flagcdn.com/w40/${Constants.getCountryCode(country)}.png").into(imageView)
}


// Calendar page
@BindingAdapter("listCalendar")
fun listCalendar(recyclerView: RecyclerView, calendarList: List<CalendarModel>?){
    val adapter = recyclerView.adapter as CalendarAdapter
    if(calendarList != null){
        adapter.setData(calendarList)
    }
}