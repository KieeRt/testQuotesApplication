package com.example.testapplication.repository

import android.database.SQLException
import com.example.testapplication.api.QuotesApi
import com.example.testapplication.model.QuoteList
import com.example.testapplication.model.Result
import com.example.testapplication.roomdb.result.ResultDao
import com.example.testapplication.roomdb.result.ResultDatabase
import com.example.testapplication.utils.RetrofitPersonal
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object QuoteRepository {
    private val quotesApi: QuotesApi = RetrofitPersonal.quotesApi

    suspend fun getQuotes(): QuoteList?{
        var quoteList : QuoteList? = null
        try {
            val response  = quotesApi.getQuotes()
            if(response.isSuccessful){
                when(response.code()){
                    200 -> quoteList = response.body()!!
                    404 -> quoteList = null
                }
            }
        }catch (e: IOException){
            println("request error:${e.message} e ${e.cause.toString()}")
            return null
        }
        return quoteList

    }

    suspend fun getResults(resultDao: ResultDao): List<Result>{
        var res = getResultRoomDB(resultDao)

        if(res.isEmpty()){
            println("Database is empty, getting data from Retrofit API")
            res = (getQuotes()?.results ?: ArrayList<Result>()) as ArrayList<Result>
            resultDao.insertAll(res)
            return res
        }

        return res
    }

    fun getResultRoomDB(resultDao: ResultDao): ArrayList<Result>{
        var res = ArrayList<Result>()
        try {
            res = resultDao.getAll() as ArrayList<Result>
        }catch (e: SQLException){
            println(e.message)
        }
        return res
    }







}