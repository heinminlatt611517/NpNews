package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.activities.RelatedNewsActivity
import com.heinminlatt.npnews.adapters.LocalNewsAdapter
import com.heinminlatt.npnews.mvp.presenters.LocalNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.impls.LocalNewsPresenterImpl
import com.heinminlatt.npnews.mvp.views.LocalNewsView

import kotlinx.android.synthetic.main.fragment_local_news.*

class LocalNewsFragment : BaseFragment(),LocalNewsView{

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
    private lateinit var mPresenter : LocalNewsPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_local_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecyclerView()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(LocalNewsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        rv_local_news.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mLocalNewsAdapter = LocalNewsAdapter(mPresenter)
        rv_local_news.adapter = mLocalNewsAdapter

        mLocalNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
        setUpRecyclerScrollState(rv_local_news)
    }

    override fun navigateToRelatedNewsScreen() {
        startActivity(context?.let { RelatedNewsActivity.newIntent(it) })
    }

    override fun showErrorMessage(errorMessage: String) {

    }


}