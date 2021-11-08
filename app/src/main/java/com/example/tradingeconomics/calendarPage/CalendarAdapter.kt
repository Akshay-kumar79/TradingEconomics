package com.example.tradingeconomics.calendarPage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradingeconomics.R
import com.example.tradingeconomics.databinding.ListItemForCalendarFragmentCalenderBinding
import com.example.tradingeconomics.models.CalendarModel

class CalendarAdapter : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    var calendarList: List<CalendarModel> = ArrayList()

    fun setData(data: List<CalendarModel>) {
        calendarList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(calendarList[position])
    }

    override fun getItemCount(): Int {
        return calendarList.size
    }

    class ViewHolder(private val binding: ListItemForCalendarFragmentCalenderBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemForCalendarFragmentCalenderBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(calendarModel: CalendarModel) {
            binding.calendarModel = calendarModel
            binding.executePendingBindings()
        }
    }

    class HeaderViewHolder(context: Context): FrameLayout(context) {
        private lateinit var dateText: TextView

        init {
            inflate(context, R.layout.list_item_for_calendar_fragment_calendar_header, this)
            dateText = findViewById(R.id.date_text_view)
        }

        fun setDate(dateString: String){
            dateText.text = dateString
        }
    }

}