package com.example.testapplication.api

import com.example.testapplication.model.QuoteList
import com.example.testapplication.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header


// Retrofit interface



interface QuotesApi {

    @GET("/quotes")
    suspend fun getQuotes(): Response<QuoteList>





}
