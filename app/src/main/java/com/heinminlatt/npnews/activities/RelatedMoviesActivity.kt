package com.heinminlatt.npnews.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.adapters.NotificationAdapter
import com.heinminlatt.npnews.adapters.RelatedMovieAdapter
import com.heinminlatt.npnews.delegate.RelatedMoviesItemDelegate
import com.heinminlatt.npnews.mvp.presenters.NotificationPresenter
import com.heinminlatt.npnews.mvp.presenters.RelatedMoviePresenter
import com.heinminlatt.npnews.mvp.presenters.impls.NotificationPresenterImpl
import com.heinminlatt.npnews.mvp.presenters.impls.RelatedMoviePresenterImpl
import com.heinminlatt.npnews.mvp.views.RelatedMovieView
import com.heinminlatt.shared.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.activity_notification.*
import kotlinx.android.synthetic.main.activity_related_movies.*

class RelatedMoviesActivity : BaseActivity(),RelatedMovieView {

    companion object{
        fun newIntent(context: Context) : Intent {
            return Intent(context, RelatedMoviesActivity::class.java)
        }
    }

    private lateinit var mAdapter: RelatedMovieAdapter
    private lateinit var mPresenter: RelatedMoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_related_movies)
        setUpPresenter()
        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpActionListener() {
       iv_back_top.setOnClickListener {
           finish()
       }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(RelatedMoviePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        rv_related_movie.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAdapter = RelatedMovieAdapter(mPresenter)
        rv_related_movie.adapter = mAdapter
        rv_related_movie.setHasFixedSize(true)
        mAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
    }




    override fun rebuildScreen() {
        finish()
        startActivity(this.let { RelatedMoviesActivity.newIntent(it) })
    }

    override fun navigateToPreviousScreen() {
        finish()
    }

    override fun showErrorMessage(errorMessage: String) {

    }
}