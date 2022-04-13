package com.example.testapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.testapplication.R
import com.example.testapplication.databinding.ActivityMainBinding
import com.example.testapplication.model.QuoteList
import com.example.testapplication.repository.QuoteRepository
import com.example.testapplication.viewModel.MainActivityViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private  var  _binding: ActivityMainBinding? = null
    private  val binding get() = _binding!!
    private lateinit var  mainActivityViewModel : MainActivityViewModel
    val model : MainActivityViewModel by viewModels()
    var count : Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // setContentView(R.layout.activity_main)
        init()
    }


    fun init(){
        initView()
        initData()
        initObserver()
        initListener()
    }

    private fun initObserver() {
        val quoteListObserver = Observer<QuoteList>{
            if(count < it.results.size) {
                binding.nameAuthor.text = it.results[count].author
                binding.quote.text = it.results[count++].content
            }
            else{
                count = 0
                binding.nameAuthor.text = it.results[count].author
                binding.quote.text = it.results[count++].content

            }
        }
        model.quoteList.observe(this, quoteListObserver)

    }


    private fun initView(){
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
    private fun initData(){
        mainActivityViewModel = MainActivityViewModel()

    }
    private fun initListener(){

        binding.getQuoteButton.setOnClickListener{
            println("Login button was pressed:\n\n")
            model.getQuotes()
            println("AFTER PRESS 1\n")

            println("AFTER PRESS 2\n")
        }
    }
}