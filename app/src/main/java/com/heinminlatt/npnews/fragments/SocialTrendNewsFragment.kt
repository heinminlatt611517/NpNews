package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.adapters.SocialTrendNewsAdapter
import kotlinx.android.synthetic.main.fragment_social_trend_news.*

class SocialTrendNewsFragment : BaseFragment() {
    companion object {
        private const val ID = "genre-id"
        fun newInstance(id: Int) : SocialTrendNewsFragment {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            val fragment = SocialTrendNewsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var mSocialTrendNewsAdapter: SocialTrendNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_social_trend_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        rv_social_trend_news.layoutManager =
            GridLayoutManager(activity,2)
        mSocialTrendNewsAdapter = SocialTrendNewsAdapter()
        rv_social_trend_news.adapter = mSocialTrendNewsAdapter

        mSocialTrendNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
        setUpRecyclerScrollState(rv_social_trend_news)
    }


}