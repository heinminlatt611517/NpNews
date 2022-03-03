package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.activities.RelatedNewsActivity
import com.heinminlatt.npnews.adapters.InterviewNewsAdapter
import com.heinminlatt.npnews.mvp.presenters.InterviewNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.impls.GlobalNewsPresenterImpl
import com.heinminlatt.npnews.mvp.presenters.impls.InterviewNewsPresenterImpl
import com.heinminlatt.npnews.mvp.views.InterviewNewsView
import kotlinx.android.synthetic.main.fragment_interview.*

class InterviewFragment : BaseFragment(),InterviewNewsView {

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
    private lateinit var mPresenter : InterviewNewsPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_interview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecyclerView()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(InterviewNewsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUpRecyclerView() {
        rv_interview_news.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mInterViewNewsAdapter = InterviewNewsAdapter(mPresenter)
        rv_interview_news.adapter = mInterViewNewsAdapter

        mInterViewNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
        setUpRecyclerScrollState(rv_interview_news)
    }

    override fun navigateToRelatedNewsScreen() {
        startActivity(context?.let { RelatedNewsActivity.newIntent(it) })
    }

    override fun showErrorMessage(errorMessage: String) {
    }


}