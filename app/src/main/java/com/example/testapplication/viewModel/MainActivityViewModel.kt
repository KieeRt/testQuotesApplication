package com.example.testapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.model.QuoteList
import com.example.testapplication.repository.QuoteRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    val quoteList: MutableLiveData<QuoteList> by lazy {
        MutableLiveData<QuoteList>()
    }
    var tag : String = "new"
    fun getQuotes() {
        GlobalScope.launch {
            quoteList.postValue(QuoteRepository.getQuotes())
           // println("FIRST: " + QuoteRepository.getQuotes().toString())
            println("livedata: " + quoteList.value.toString())
            // return quoteList
            delay(1000)
            println("livedata2: " + quoteList.value.toString())

        }
    }
}