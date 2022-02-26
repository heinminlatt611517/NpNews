package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.activities.MainActivity
import com.heinminlatt.npnews.adapters.HomeNewsAdapter
import com.heinminlatt.npnews.adapters.LocalNewsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

import kotlinx.android.synthetic.main.fragment_local_news.*

class LocalNewsFragment : BaseFragment() {

    companion object {
        private const val ID = "genre-id"
        fun newInstance(id: Int) : LocalNewsFragment {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            val fragment = LocalNewsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var mLocalNewsAdapter: LocalNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_local_news, container, false)
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }



    private fun setUpRecyclerView() {
        rv_local_news.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mLocalNewsAdapter = LocalNewsAdapter()
        rv_local_news.adapter = mLocalNewsAdapter

        mLocalNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
        setUpRecyclerScrollState(rv_local_news)
    }


}