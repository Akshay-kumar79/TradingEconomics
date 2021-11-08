package com.example.tradingeconomics.newsPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tradingeconomics.models.News
import com.example.tradingeconomics.databinding.ListItemForNewsFragmentNewsBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var allNews: List<News> = ArrayList()

    fun setData(news: List<News>){
        this.allNews = news
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(allNews[position])
    }

    override fun getItemCount(): Int {
        return allNews.size
    }

    class ViewHolder private constructor(private val binding: ListItemForNewsFragmentNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemForNewsFragmentNewsBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(allNews: News) {
            binding.news = allNews
            binding.executePendingBindings()
        }
    }

}