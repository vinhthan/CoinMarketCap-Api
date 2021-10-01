package com.example.coinmarket.network

import com.example.coinmarket.model.Coin
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.Query

interface RetrofitService {
    //curl -H "X-CMC_PRO_API_KEY: b54bcf4d-1bca-4e8e-9a24-22ff2c3d462c" -H "Accept: application/json" -d "start=1&limit=5000&convert=USD" -G https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest
    @GET("latest")
    @Headers(
        "X-CMC_PRO_API_KEY: da4b52b3-c8fa-41d6-84fb-25494b3cef9f",
        "Accept: application/json"
    )
    fun getDataCoin(
        @Query("start") start: Int,
        @Query("limit") page: Int
    ): Call<Coin>

}