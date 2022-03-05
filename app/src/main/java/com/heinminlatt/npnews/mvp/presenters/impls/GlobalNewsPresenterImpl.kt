package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.GlobalNewsPresenter
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class GlobalNewsPresenterImpl : GlobalNewsPresenter,AbstractBasePresenter<GlobalNewsView>() {
    override fun onUiReady() {
    }

    override fun onTapNewsItem() {
       mView?.navigateToRelatedNewsScreen()
    }
}