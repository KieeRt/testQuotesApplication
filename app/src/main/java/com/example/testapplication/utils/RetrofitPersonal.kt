package com.example.testapplication.utils

import com.example.testapplication.api.QuotesApi
import com.example.testapplication.model.QuoteList
import com.example.testapplication.model.Result
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitPersonal {
    val webUrl = "https://quotable.io/"
    val localUrl = "http://localhost:3000/"
    private val retrofit: Retrofit = Retrofit.Builder().
    baseUrl(webUrl).
    addConverterFactory(GsonConverterFactory.create()).
    build()
    val quotesApi: QuotesApi = retrofit.create(QuotesApi::class.java)

}