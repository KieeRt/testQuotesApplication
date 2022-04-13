package com.example.testapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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

       // val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //val navController = navHostFragment.navController
      //  val navController  = binding.navHostFragment.findNavController()

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
            }
            else{
                count = 0


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


    }
}