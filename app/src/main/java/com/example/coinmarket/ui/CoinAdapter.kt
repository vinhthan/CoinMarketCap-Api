package com.example.coinmarket.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coinmarket.R
import com.example.coinmarket.model.Data
import kotlinx.android.synthetic.main.item_coin.view.*

class CoinAdapter : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>(){
    var listCoin = mutableListOf<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(listCoin[position])
    }

    override fun getItemCount(): Int {
        return listCoin.size
    }

    class CoinViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tvNameCoin: TextView = view.tv_name_coin
        var tvPrice: TextView = view.tv_price
        var tvTime: TextView = view.tv_time
        var tvRank: TextView = view.tv_rank
        fun bind(data: Data){
            tvNameCoin.text = data.name
            tvPrice.text = data.quote?.USD?.price?.toString()
            tvTime.text = data.last_updated
            tvRank.text = data.cmc_rank?.toString()
        }
    }

}