package com.example.testapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.testapplication.model.Result
import com.example.testapplication.repository.QuoteRepository
import com.example.testapplication.roomdb.result.ResultDao
import com.example.testapplication.roomdb.result.ResultDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    private val quoteRepository : QuoteRepository
    private val resultDB : ResultDatabase
    private val resultDAO : ResultDao

    private var resultList: MutableLiveData<List<Result>> = MutableLiveData<List<Result>>()
    private var quoteSaved: MutableLiveData<List<Result>> = MutableLiveData<List<Result>>()
    init {
        println("Istanzio nuova classe di viewModel dentro ")
        resultDB = ResultDatabase.getDatabase(application.applicationContext)
        resultDAO = resultDB.resultDao()
        quoteRepository = QuoteRepository
    }
    var tag : String = "new"

    fun getQuotes() {
        GlobalScope.launch {
            resultList.postValue(quoteRepository.getResults(resultDao = resultDAO))
        }


    }

    fun saveQuote(quote: Result){
        quoteSaved.value = quoteSaved.value?.plus(quote) ?: listOf(quote)
    }
    fun removeQuoteFromSaved(quote: Result){
        quoteSaved.value = quoteSaved.value?.minus(quote)
    }

    fun getSavedQuotes(): MutableLiveData<List<Result>> {
        return quoteSaved
    }

    @JvmName("getQuoteList1")
    fun getQuoteList(): MutableLiveData<List<Result>>{
        return resultList
    }

}