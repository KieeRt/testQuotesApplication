package com.example.testapplication.repository

import android.database.SQLException
import com.example.testapplication.model.QuoteList
import com.example.testapplication.model.Result
import com.example.testapplication.roomdb.result.ResultDao
import com.example.testapplication.roomdb.result.ResultDatabase
import com.example.testapplication.utils.RetrofitPersonal
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuoteRepository {

    suspend fun getQuotes(): QuoteList?{
        //1. Check cache
        //2. if there isn't file in cache, make request to api via Retrofit
        return RetrofitPersonal.quotesApi.getQuotes().body()
    }

    suspend fun getResults(resultDao: ResultDao): List<Result>{
        var res = getResultRoomDB(resultDao)

        if(res.isEmpty()){
            println("Database is empty, downloand from Api")
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