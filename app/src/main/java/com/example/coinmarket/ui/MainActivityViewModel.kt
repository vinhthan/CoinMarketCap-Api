package com.example.coinmarket.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coinmarket.model.Coin
import com.example.coinmarket.network.RetrofitInstance
import com.example.coinmarket.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var listCoin: MutableLiveData<Coin?> = MutableLiveData()

    fun getCoinObservable(): MutableLiveData<Coin?> {
        return listCoin
    }

    fun getCoin(start: Int, limit: Int){
        val retrofitInstance = RetrofitInstance.getRetrofit().create(RetrofitService::class.java)
        val call = retrofitInstance.getDataCoin(start, limit)
        call.enqueue(object : Callback<Coin>{
            override fun onResponse(call: Call<Coin>, response: Response<Coin>) {
                if (response.isSuccessful){
                    listCoin.postValue(response.body())
                    Log.d("123123", "onResponse")
                } else {
                    listCoin.postValue(null)
                }
            }

            override fun onFailure(call: Call<Coin>, t: Throwable) {
                listCoin.postValue(null)
                Log.d("123123", "onFailure $t")
            }

        })
    }


}