package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.adapters.InterviewNewsAdapter
import kotlinx.android.synthetic.main.fragment_interview.*

class InterviewFragment : BaseFragment() {

    companion object {
        private const val ID = "genre-id"
        fun newInstance(id: Int) : InterviewFragment {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            val fragment = InterviewFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var mInterViewNewsAdapter: InterviewNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_interview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        rv_interview_news.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mInterViewNewsAdapter = InterviewNewsAdapter()
        rv_interview_news.adapter = mInterViewNewsAdapter

        mInterViewNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
        setUpRecyclerScrollState(rv_interview_news)
    }



}