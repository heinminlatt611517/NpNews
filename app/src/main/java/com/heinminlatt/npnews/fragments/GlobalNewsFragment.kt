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
import com.heinminlatt.npnews.mvp.presenters.GlobalNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.impls.GlobalNewsPresenterImpl
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import kotlinx.android.synthetic.main.fragment_global_news.*

class GlobalNewsFragment : BaseFragment(),GlobalNewsView {
    companion object {
        private const val ID = "genre-id"
        fun newInstance(id: Int) : GlobalNewsFragment {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            val fragment = GlobalNewsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var mGlobalNewsAdapter: GlobalNewsAdapter
    private lateinit var mPresenter: GlobalNewsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_global_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecyclerView()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(GlobalNewsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        rv_global_news.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mGlobalNewsAdapter = GlobalNewsAdapter(mPresenter)
        rv_global_news.adapter = mGlobalNewsAdapter

        mGlobalNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
        setUpRecyclerScrollState(rv_global_news)
    }

    override fun navigateToRelatedNewsScreen() {
        startActivity(context?.let { RelatedNewsActivity.newIntent(it) })
    }

    override fun showErrorMessage(errorMessage: String) {

    }

}