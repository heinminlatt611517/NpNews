package com.heinminlatt.npnews.activities
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.adapters.NotificationAdapter
import com.heinminlatt.npnews.adapters.RelatedNewsAdapter
import com.heinminlatt.npnews.fragments.CommentBottomSheetFragment
import com.heinminlatt.npnews.mvp.presenters.NotificationPresenter
import com.heinminlatt.npnews.mvp.presenters.RelatedNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.impls.NotificationPresenterImpl
import com.heinminlatt.npnews.mvp.presenters.impls.RelatedNewsPresenterImpl
import com.heinminlatt.npnews.mvp.views.NotificationView
import com.heinminlatt.npnews.mvp.views.RelatedNewsView
import com.heinminlatt.shared.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_notification.*
import kotlinx.android.synthetic.main.activity_related_news.*

class NotificationActivity : BaseActivity(),NotificationView {
    companion object{
        fun newIntent(context: Context) : Intent {
            return Intent(context, NotificationActivity::class.java)
        }
    }

    private lateinit var mNotificationAdapter: NotificationAdapter
    private lateinit var mPresenter: NotificationPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        setUpPresenter()
        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        iv_back_arrow.setOnClickListener {
            mPresenter.onTapBackArrow()
        }
    }


    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(NotificationPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        rv_notification_news.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mNotificationAdapter = NotificationAdapter(mPresenter)
        rv_notification_news.adapter = mNotificationAdapter
        rv_notification_news.setHasFixedSize(true)
        mNotificationAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
    }

    override fun navigateToRelatedNewsScreen() {
        startActivity(this.let { RelatedNewsActivity.newIntent(it) })
    }

    override fun navigateToPreviousScreen() {
        finish()
    }

    override fun showErrorMessage(errorMessage: String) {

    }


}