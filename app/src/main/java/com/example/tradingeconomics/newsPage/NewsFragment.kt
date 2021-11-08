package com.example.tradingeconomics.newsPage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.tradingeconomics.MainActivity
import com.example.tradingeconomics.R
import com.example.tradingeconomics.databinding.NewsFragmentBinding

class NewsFragment : Fragment() {

    private lateinit var binding: NewsFragmentBinding
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsFragmentBinding.inflate(inflater, container, false)
        setUpToolBar()
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val newsAdapter = NewsAdapter()
        binding.newsRecyclerView.adapter = newsAdapter


        return binding.root
    }

    private fun setUpToolBar(){

        binding.toolBar.setupWithNavController(findNavController(), AppBarConfiguration(findNavController().graph))
        binding.toolBar.setNavigationIcon(R.drawable.ic_icon_ionic_ios_arrow_back)
        (activity as MainActivity).setSupportActionBar(binding.toolBar)
        setHasOptionsMenu(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}