package com.example.tradingeconomics.marketPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tradingeconomics.models.Market
import com.example.tradingeconomics.utils.Api
import com.example.tradingeconomics.utils.Constants
import com.example.tradingeconomics.utils.networkModels.Commodities
import com.example.tradingeconomics.utils.networkModels.StocksCurreciesBonds
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketViewModel : ViewModel() {


    private val _currentSelected = MutableLiveData<String>()
    val currentSelected: LiveData<String>
    get() = _currentSelected

    private val _visibleScreen = MutableLiveData<String>()
    val visibleString: LiveData<String>
        get() = _visibleScreen


    private val _marketList = MutableLiveData<List<Market>>()
    val marketList: LiveData<List<Market>>
    get() = _marketList

    init {
        _visibleScreen.value = Constants.LOADING_SCREEN
        _currentSelected.value = Constants.STOCK_SECTION
        fetchStocks()
    }


    fun tryAgain(){
        _visibleScreen.value = Constants.LOADING_SCREEN
        when(_currentSelected.value){
            Constants.STOCK_SECTION -> fetchStocks()
            Constants.CURRENCY_SECTION -> fetchCurrencies()
            Constants.COMMODITY_SECTION -> fetchCommodities()
            Constants.BOND_SECTION -> fetchBonds()
        }
    }

    fun showStocks(){
        _visibleScreen.value = Constants.LOADING_SCREEN
        _currentSelected.value = Constants.STOCK_SECTION
        fetchStocks()
    }

    fun showCurrencies(){
        _visibleScreen.value = Constants.LOADING_SCREEN
        _currentSelected.value = Constants.CURRENCY_SECTION
        fetchCurrencies()
    }

    fun showCommodities(){
        _visibleScreen.value = Constants.LOADING_SCREEN
        _currentSelected.value = Constants.COMMODITY_SECTION
        fetchCommodities()
    }

    fun showBonds(){
        _visibleScreen.value = Constants.LOADING_SCREEN
        _currentSelected.value = Constants.BOND_SECTION
        fetchBonds()
    }

    private fun fetchStocks(){
        Api.retrofitService.getStock().enqueue(object : Callback<List<StocksCurreciesBonds>>{
            override fun onResponse(call: Call<List<StocksCurreciesBonds>>, response: Response<List<StocksCurreciesBonds>>) {
                if(response.code() != 200)
                    return

                val markets: MutableList<Market> = ArrayList()
                for(i in response.body()!!){
                    markets.add(Market(i.Name, i.Country, i.Last, i.DailyChange))
                }
                _marketList.value = markets
                _visibleScreen.value = Constants.MAIN_CONTENT_SCREEN
            }

            override fun onFailure(call: Call<List<StocksCurreciesBonds>>, t: Throwable) {
                _visibleScreen.value = Constants.TRY_AGAIN_SCREEN
            }

        })
    }

    private fun fetchCurrencies(){
        Api.retrofitService.getCurrencies().enqueue(object : Callback<List<StocksCurreciesBonds>>{
            override fun onResponse(call: Call<List<StocksCurreciesBonds>>, response: Response<List<StocksCurreciesBonds>>) {
                if(response.code() != 200)
                    return

                val markets: MutableList<Market> = ArrayList()
                for(i in response.body()!!){
                    markets.add(Market(i.Name, i.Country, i.Last, i.DailyChange))
                }
                _marketList.value = markets
                _visibleScreen.value = Constants.MAIN_CONTENT_SCREEN
            }

            override fun onFailure(call: Call<List<StocksCurreciesBonds>>, t: Throwable) {
                _visibleScreen.value = Constants.TRY_AGAIN_SCREEN
            }

        })
    }

    private fun fetchCommodities(){
        Api.retrofitService.getCommodities().enqueue(object : Callback<List<Commodities>>{
            override fun onResponse(call: Call<List<Commodities>>, response: Response<List<Commodities>>) {
                if(response.code() != 200)
                    return

                val markets: MutableList<Market> = ArrayList()
                for(i in response.body()!!){
                    markets.add(Market(i.Name, i.unit, i.Last, i.DailyChange))
                }
                _marketList.value = markets
                _visibleScreen.value = Constants.MAIN_CONTENT_SCREEN
            }

            override fun onFailure(call: Call<List<Commodities>>, t: Throwable) {
                _visibleScreen.value = Constants.TRY_AGAIN_SCREEN
            }

        })
    }

    private fun fetchBonds(){
        Api.retrofitService.getBonds().enqueue(object : Callback<List<StocksCurreciesBonds>>{
            override fun onResponse(call: Call<List<StocksCurreciesBonds>>, response: Response<List<StocksCurreciesBonds>>) {
                if(response.code() != 200)
                    return

                val markets: MutableList<Market> = ArrayList()
                for(i in response.body()!!){
                    markets.add(Market(i.Name, i.Country, i.Last, i.DailyChange))
                }
                _marketList.value = markets
                _visibleScreen.value = Constants.MAIN_CONTENT_SCREEN
            }

            override fun onFailure(call: Call<List<StocksCurreciesBonds>>, t: Throwable) {
                _visibleScreen.value = Constants.TRY_AGAIN_SCREEN
            }

        })
    }
}