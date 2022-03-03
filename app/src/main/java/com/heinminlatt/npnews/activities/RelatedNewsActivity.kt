package com.heinminlatt.npnews.activities
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.adapters.RelatedNewsAdapter
import com.heinminlatt.npnews.fragments.CommentBottomSheetFragment
import com.heinminlatt.npnews.mvp.presenters.RelatedNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.impls.RelatedNewsPresenterImpl
import com.heinminlatt.npnews.mvp.views.RelatedNewsView
import com.heinminlatt.npnews.utils.SessionManager
import com.heinminlatt.shared.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_related_news.*

class RelatedNewsActivity : BaseActivity(),RelatedNewsView {
    companion object{
        fun newIntent(context: Context) : Intent {
            return Intent(context, RelatedNewsActivity::class.java)
        }
    }

    private lateinit var mRelatedNewsAdapter: RelatedNewsAdapter
    private lateinit var mPresenter: RelatedNewsPresenter


    override fun onDestroy() {
        super.onDestroy()
        SessionManager.isLogin = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_related_news)

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
        mRelatedNewsAdapter = RelatedNewsAdapter(mPresenter)
        rv_related_news.adapter = mRelatedNewsAdapter
        rv_related_news.setHasFixedSize(true)
        mRelatedNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(RelatedNewsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToLoginScreen() {
        if(SessionManager.isLogin == ""){
            startActivity(this.let {
                SessionManager.isLogin = "Already Login"
                LoginActivity.newIntent(it) })
        }
        else {
            val bottomSheetDialogFragment = CommentBottomSheetFragment()
            this.supportFragmentManager.let { it1 ->
                bottomSheetDialogFragment.show(it1,"TAG")
            }
        }
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