package com.example.testapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.model.QuoteList
import com.example.testapplication.model.Result
import com.example.testapplication.repository.QuoteRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    val quoteList: MutableLiveData<QuoteList> by lazy {
        MutableLiveData<QuoteList>()
    }
    val error: String = "Lista vuota"
    private var quoteSaved: MutableLiveData<List<Result>> = MutableLiveData<List<Result>>()
    init {
        println("Istanzio nuova classe di viewModel dentro ")
    }
    var tag : String = "new"
    fun getQuotes() {
        GlobalScope.launch {
            quoteList.postValue(QuoteRepository.getQuotes())
        }
    }
    fun saveQuote(quote: Result){
        quoteSaved.value = quoteSaved.value?.plus(quote) ?: listOf(quote)
    }



}