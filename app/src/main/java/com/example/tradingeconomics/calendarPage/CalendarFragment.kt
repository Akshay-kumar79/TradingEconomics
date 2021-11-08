package com.example.tradingeconomics.calendarPage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.tradingeconomics.MainActivity
import com.example.tradingeconomics.R
import com.example.tradingeconomics.databinding.CalendarFragmentBinding

class CalendarFragment : Fragment() {

    private lateinit var binding: CalendarFragmentBinding
    private lateinit var viewModel: CalendarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CalendarFragmentBinding.inflate(inflater, container, false)
        setUpToolBar()
        viewModel = ViewModelProvider(this).get(CalendarViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val calendarAdapter = CalendarAdapter()
        val headerItemDecoration = HeaderItemDecoration(requireContext()){
            calendarAdapter.calendarList
        }
        binding.calendarRecyclerView.addItemDecoration(headerItemDecoration)
        binding.calendarRecyclerView.adapter = calendarAdapter

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