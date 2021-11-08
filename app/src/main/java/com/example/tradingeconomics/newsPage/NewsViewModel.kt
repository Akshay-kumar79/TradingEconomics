package com.example.tradingeconomics.newsPage

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tradingeconomics.models.News
import com.example.tradingeconomics.TempTesting
import com.example.tradingeconomics.utils.Api
import com.example.tradingeconomics.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val _visibleScreen = MutableLiveData<String>()
    val visibleString: LiveData<String>
        get() = _visibleScreen

    private val _allNews = MutableLiveData<List<News>>()
    val allNews: LiveData<List<News>>
        get() = _allNews

    init {
        _visibleScreen.value = Constants.LOADING_SCREEN
        fetchNews()
    }

    fun tryAgain(){
        _visibleScreen.value = Constants.LOADING_SCREEN
        fetchNews()
    }

    private fun fetchNews() {
        Api.retrofitService.getNews().enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                if (response.code() != 200)
                    return

                val news: MutableList<News> = response.body()!!.toMutableList()
                news.removeAt(news.size - 1)
                _allNews.value = news
                _visibleScreen.value = Constants.MAIN_CONTENT_SCREEN
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                _visibleScreen.value = Constants.TRY_AGAIN_SCREEN
            }

        })
    }

}