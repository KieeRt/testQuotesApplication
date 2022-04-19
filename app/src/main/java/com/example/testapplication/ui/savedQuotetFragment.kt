package com.example.testapplication.ui

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
import com.example.testapplication.R
import com.example.testapplication.adapter.MyAdapter
import com.example.testapplication.model.QuoteList
import com.example.testapplication.viewModel.MainActivityViewModel
import com.example.testapplication.model.Result
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
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
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
        _view =  inflater.inflate(R.layout.fragment_homequote, container, false)
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
        val listener = View.OnClickListener { it ->
            // colored and uncolored icon
            if(it is ImageView){
                if(it.colorFilter == null) it.setColorFilter(R.color.red)
                else it.colorFilter = null
            }
            // get information about item that was clicked
            val tag: String =  it?.getTag(R.string.id_saved_item).toString()

            // search clicked item inside my list
            var res: Result? = null
            res =  model.quoteList.value?.results?.find {
                it._id == tag
            }

            // if the search was successful add item to my savedQuote list
            if (res != null) {
                if(res.length != 0){
                    model.saveQuote(res)
                }
            }


        }

        val quoteListObserver = Observer<QuoteList>{
            println("lifedata was updated")
            val myAdapter = MyAdapter(requireContext(), model.quoteList.value!!.results, listener)
            recyclerView.adapter = myAdapter
            recyclerView.layoutManager = LinearLayoutManager(context)


        }


        model.quoteList.observe(viewLifecycleOwner, quoteListObserver)

    }

    class myOnClickListener() : View.OnClickListener{
        private lateinit var item: Result
        override fun onClick(view: View?) {
            val tag: String =  view?.getTag(R.string.id_saved_item).toString()

        }
        fun saveResult(res: Result){
            item = res
        }

    }


    private fun initData(){
        model = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        model.getQuotes()

    }
    private fun initListener(){

    }
}