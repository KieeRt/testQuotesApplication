package com.example.testapplication.utils

import com.example.testapplication.api.QuotesApi
import com.example.testapplication.model.QuoteList
import com.example.testapplication.model.Result
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitPersonal {
    private val retrofit: Retrofit = Retrofit.Builder().
    baseUrl("https://quotable.io/").
    addConverterFactory(GsonConverterFactory.create()).
    build()
    val quotesApi: QuotesApi = retrofit.create(QuotesApi::class.java)


    suspend fun getQuotes(): QuoteList? {
        val result: Response<QuoteList> = quotesApi.getQuotes()
        return result.body()
    }

    fun getQuotesNotSuspend(): QuoteList? {
        val result: Response<QuoteList> = quotesApi.getQuotesNotSuspend()
        return result.body()
    }





}