package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.activities.RelatedNewsActivity
import com.heinminlatt.npnews.adapters.GlobalNewsAdapter
import com.heinminlatt.npnews.adapters.LatestNewsAdapter
import com.heinminlatt.npnews.mvp.presenters.GlobalNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.LatestNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.impls.GlobalNewsPresenterImpl
import com.heinminlatt.npnews.mvp.presenters.impls.LatestNewsPresenterImpl
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.LatestNewsView
import kotlinx.android.synthetic.main.fragment_global_news.*
import kotlinx.android.synthetic.main.fragment_latest_news.*

class LatestNewsFragment : BaseFragment(),LatestNewsView {
    companion object {
        private const val ID = "genre-id"
        fun newInstance(id: Int) : LatestNewsFragment {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            val fragment = LatestNewsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var mLatestNewsAdapter: LatestNewsAdapter
    private lateinit var mPresenter: LatestNewsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_latest_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecyclerView()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(LatestNewsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        rv_latest_news.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mLatestNewsAdapter = LatestNewsAdapter(mPresenter)
        rv_latest_news.adapter = mLatestNewsAdapter

        mLatestNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
        setUpRecyclerScrollState(rv_latest_news)
    }

    override fun navigateToRelatedNewsScreen() {
        startActivity(context?.let { RelatedNewsActivity.newIntent(it) })
    }

    override fun showErrorMessage(errorMessage: String) {

    }

}