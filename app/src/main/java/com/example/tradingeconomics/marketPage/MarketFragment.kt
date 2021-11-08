package com.example.tradingeconomics.marketPage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.tradingeconomics.MainActivity
import com.example.tradingeconomics.R
import com.example.tradingeconomics.databinding.MarketFragmentBinding

class MarketFragment : Fragment() {

    private lateinit var binding: MarketFragmentBinding
    private lateinit var viewModel: MarketViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MarketFragmentBinding.inflate(inflater, container, false)
        setUpToolBar()
        viewModel = ViewModelProvider(this).get(MarketViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val marketAdapter = MarketAdapter()
        binding.marketRecyclerView.adapter = marketAdapter

        return binding.root
    }

    private fun setUpToolBar(){

        binding.toolBar.setupWithNavController(findNavController(), AppBarConfiguration(findNavController().graph))
        binding.toolBar.setNavigationIcon(R.drawable.ic_icon_ionic_ios_arrow_back)
        (activity as MainActivity).setSupportActionBar(binding.toolBar)
        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_items_for_market_filter, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                return true
            }
            R.id.stocks -> {
                item.isChecked = true
                viewModel.showStocks()
            }
            R.id.currencies -> {
                item.isChecked = true
                viewModel.showCurrencies()
            }
            R.id.commodities -> {
                item.isChecked = true
                viewModel.showCommodities()
            }
            R.id.bonds -> {
                item.isChecked = true
                viewModel.showBonds()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}