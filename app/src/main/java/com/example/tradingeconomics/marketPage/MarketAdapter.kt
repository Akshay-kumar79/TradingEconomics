package com.example.tradingeconomics.marketPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tradingeconomics.databinding.ListItemForMarketFragmentMarketBinding
import com.example.tradingeconomics.models.Market
import com.example.tradingeconomics.utils.Constants

class MarketAdapter: RecyclerView.Adapter<MarketAdapter.ViewHolder>() {

    var marketList: List<Market> = ArrayList()
    var selectedLayout = Constants.STOCK_SECTION

    fun setData(data: List<Market>){
        marketList = data
        notifyDataSetChanged()
    }

    fun changeLayout(selected: String){
        selectedLayout = selected
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(marketList[position], selectedLayout)
    }

    override fun getItemCount(): Int {
        return marketList.size
    }

    class ViewHolder private constructor(private val binding: ListItemForMarketFragmentMarketBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemForMarketFragmentMarketBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(market: Market, selected: String) {
            binding.market = market
            binding.selected = selected
            binding.executePendingBindings()
        }
    }

}