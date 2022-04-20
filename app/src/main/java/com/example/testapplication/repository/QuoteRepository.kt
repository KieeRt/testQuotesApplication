package com.example.testapplication.repository

import com.example.testapplication.model.QuoteList
import com.example.testapplication.utils.RetrofitPersonal
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuoteRepository {


    suspend fun getQuotes(): QuoteList?{
        // 1. Check cache
        //2. if there isn't file in cache, make request to api via Retrofit
        return RetrofitPersonal.quotesApi.getQuotes().body()
    }



}