package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.adapters.ArticleNewsAdapter
import com.heinminlatt.npnews.adapters.GlobalNewsAdapter
import kotlinx.android.synthetic.main.fragment_artical.*
import kotlinx.android.synthetic.main.fragment_home.*

class ArticleFragment : BaseFragment() {
    companion object {
        private const val ID = "genre-id"
        fun newInstance(id: Int) : ArticleFragment {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            val fragment = ArticleFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    private lateinit var mArticleNewsAdapter: ArticleNewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_artical, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        rv_article_news.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mArticleNewsAdapter = ArticleNewsAdapter()
        rv_article_news.adapter = mArticleNewsAdapter

        mArticleNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
        setUpRecyclerScrollState(rv_article_news)
    }
}