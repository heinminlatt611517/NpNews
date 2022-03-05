package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.GlobalNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.LatestNewsPresenter
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.LatestNewsView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class LatestNewsPresenterImpl : LatestNewsPresenter,AbstractBasePresenter<LatestNewsView>() {
    override fun onUiReady() {
    }

    override fun onTapNewsItem() {
       mView?.navigateToRelatedNewsScreen()
    }
}