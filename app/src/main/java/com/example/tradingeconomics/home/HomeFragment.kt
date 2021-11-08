package com.example.tradingeconomics.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tradingeconomics.MainActivity
import com.example.tradingeconomics.R
import com.example.tradingeconomics.databinding.HomeFragmentBinding
import android.content.Intent
import android.net.Uri

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeFragmentBinding.inflate(inflater, container, false)

        binding.newsCardView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNewsFragment())
        }

        binding.marketCardView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMarketFragment())
        }

        binding.calendarCardView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCalendarFragment())
        }

        binding.mailImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "plain/text"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("android@tradingeconomics.com"))
            startActivity(intent)
        }

        binding.webRedirectButton.setOnClickListener {
            val url = "https://tradingeconomics.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        return binding.root
    }

}