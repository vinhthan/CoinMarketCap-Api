package com.example.coinmarket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinmarket.R
import com.example.coinmarket.model.Coin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    private lateinit var mAdapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        rcy_list_coin.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            mAdapter = CoinAdapter()
            adapter = mAdapter
        }
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getCoinObservable().observe(this, Observer<Coin> {
            if (it == null) {
                Toast.makeText(this, "data empty", Toast.LENGTH_SHORT).show()
            } else{
                Log.d("123123", "success")
                mAdapter.listCoin = it.data!!.toMutableList()
                mAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getCoin(1, 500)
    }
}