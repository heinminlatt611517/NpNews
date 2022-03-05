package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.GlobalNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.LocalNewsPresenter
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.LocalNewsView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class LocalNewsPresenterImpl : LocalNewsPresenter,AbstractBasePresenter<LocalNewsView>() {
    override fun onUiReady() {
    }

    override fun onTapNewsItem() {
       mView?.navigateToRelatedNewsScreen()
    }
}