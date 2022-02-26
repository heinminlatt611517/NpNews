package com.heinminlatt.npnews.activities
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.adapters.HomeRelatedNewsAdapter
import com.heinminlatt.npnews.mvp.presenters.HomeNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.impls.HomeNewsPresenterImpl
import com.heinminlatt.npnews.mvp.views.HomeNewsView
import com.heinminlatt.shared.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_home_news_detail.*

class HomeNewsActivity : BaseActivity(),HomeNewsView {
    companion object{
        fun newIntent(context: Context) : Intent {
            return Intent(context, HomeNewsActivity::class.java)
        }
    }

    private lateinit var mRelatedNewsAdapter: HomeRelatedNewsAdapter
    private lateinit var mPresenter: HomeNewsPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_news_detail)

        setUpPresenter()
        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        btn_login_and_comment.setOnClickListener {
            mPresenter.onTapLogin()
        }

        iv_back.setOnClickListener {
            mPresenter.onTapBackArrow()
        }

        addReadMore(resources.getString(R.string.new_details_description),tv_news_description)
    }

    private fun setUpRecyclerView() {
        rv_related_news.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRelatedNewsAdapter = HomeRelatedNewsAdapter(mPresenter)
        rv_related_news.adapter = mRelatedNewsAdapter
        rv_related_news.setHasFixedSize(true)
        mRelatedNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(HomeNewsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToLoginScreen() {
        startActivity(this.let { LoginActivity.newIntent(it) })
    }

    override fun navigateToPreviousScreen() {
        finish()
    }

    override fun navigateToNewsDetailScreen() {
        startActivity(this.let { NewsDetailActivity.newIntent(it) })
    }

    override fun showErrorMessage(errorMessage: String) {

    }


}