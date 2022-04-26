package com.example.testapplication.ui

import android.database.SQLException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.testapplication.R
import com.example.testapplication.adapter.RecyclerQuoteListAdapter
import com.example.testapplication.adapter.RecyclerQuoteListNoSaveAdapter
import com.example.testapplication.viewModel.MainActivityViewModel
import com.example.testapplication.model.Result
import com.example.testapplication.model.User
import com.example.testapplication.roomdb.AppDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [homeQuoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class savedQuotetFragment : Fragment() {
    private lateinit var  recyclerView : RecyclerView
    private lateinit var model: MainActivityViewModel
    private lateinit var _view : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _view =  inflater.inflate(R.layout.fragment_savedquotes, container, false)
        init()
        return _view
    }

    private fun init(){
        initView()
        initData()
        initObserver()
        initListener()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment second.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            homeQuoteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initView(){
        recyclerView = _view.findViewById(R.id.recycleView)

    }

    private fun initObserver() {

        if(model.getSavedQuotes().value != null ) {
            val myAdapter = RecyclerQuoteListNoSaveAdapter(requireContext(), model.getSavedQuotes().value!!)
            recyclerView.adapter = myAdapter
            recyclerView.layoutManager = LinearLayoutManager(context)
        }

        val quoteListObserver = Observer<List<Result>>{
            println("lifedata was updated")
            val myAdapter = RecyclerQuoteListNoSaveAdapter(requireContext(), model.getSavedQuotes().value!!)
            recyclerView.adapter = myAdapter
            recyclerView.layoutManager = LinearLayoutManager(context)
        }

        model.getSavedQuotes().observe(viewLifecycleOwner, quoteListObserver)

    }


    private fun initData(){
        model = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }
    private fun initListener(){}

}