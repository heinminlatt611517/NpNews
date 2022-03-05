package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.ArticleNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.GlobalNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.NotificationPresenter
import com.heinminlatt.npnews.mvp.views.ArticleNewsView
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.NotificationView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class NotificationPresenterImpl : NotificationPresenter,AbstractBasePresenter<NotificationView>() {
    override fun onUiReady() {
    }

    override fun onTapBackArrow() {
        mView?.navigateToPreviousScreen()
    }

    override fun onTapNewsItem() {
       mView?.navigateToRelatedNewsScreen()
    }
}