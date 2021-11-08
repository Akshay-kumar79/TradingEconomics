package com.example.tradingeconomics.calendarPage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tradingeconomics.models.CalendarModel
import com.example.tradingeconomics.utils.Api
import com.example.tradingeconomics.utils.Constants
import com.example.tradingeconomics.utils.networkModels.CalendarModelForNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CalendarViewModel(application: Application) : AndroidViewModel(application) {

    private val _calendarList = MutableLiveData<List<CalendarModel>>()
    val calendarList: LiveData<List<CalendarModel>>
        get() = _calendarList

    private val _visibleScreen = MutableLiveData<String>()
    val visibleString: LiveData<String>
        get() = _visibleScreen


    init {
        _visibleScreen.value = Constants.LOADING_SCREEN
        fetchCalendars()
    }

    fun tryAgain(){
        _visibleScreen.value = Constants.LOADING_SCREEN
        fetchCalendars()
    }

    private fun fetchCalendars(){
        Api.retrofitService.getCalendar().enqueue(object : Callback<List<CalendarModelForNetwork>>{

            override fun onResponse(call: Call<List<CalendarModelForNetwork>>, response: Response<List<CalendarModelForNetwork>>) {
                if(response.code() != 200)
                    return

                val calendars: MutableList<CalendarModel> = ArrayList()
                val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                val dateFormat = SimpleDateFormat("EEE | dd MMM,yyyy")
                val timeFormat = SimpleDateFormat("HH:mm")
                for (i in response.body()!!){
                    val parsed = format.parse(i.date)
                    val time = timeFormat.format(parsed)
                    val date = dateFormat.format(parsed)

                    calendars.add(CalendarModel(i.event, date, time, i.country, i.reference, i.actual, i.previous))
                }

                _calendarList.value = calendars
                _visibleScreen.value = Constants.MAIN_CONTENT_SCREEN
            }

            override fun onFailure(call: Call<List<CalendarModelForNetwork>>, t: Throwable) {
                _visibleScreen.value = Constants.TRY_AGAIN_SCREEN
            }
        })
    }

}