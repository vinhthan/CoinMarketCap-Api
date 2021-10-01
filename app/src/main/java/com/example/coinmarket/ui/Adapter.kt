package com.example.coinmarket.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coinmarket.R
import com.example.coinmarket.model.Data
import kotlinx.android.synthetic.main.item_coin.view.*

class Adapter : PagingDataAdapter<Data, Adapter.CoinViewHolder>(Diff()){

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return CoinViewHolder(view)
    }

    class CoinViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tvNameCoin: TextView = view.tv_name_coin
        var tvPrice: TextView = view.tv_price
        var tvTime: TextView = view.tv_time
        fun bind(data: Data){
            tvNameCoin.text = data.name
            tvPrice.text = data.quote?.USD?.price?.toString()
            tvTime.text = data.last_updated
        }
    }

    class Diff(): DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return when {
                oldItem.id != newItem.id -> {
                    false
                }
                oldItem.name != newItem.name -> {
                    false
                }

                else -> true
            }
        }

    }
}