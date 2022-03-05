package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.ArticleNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.GlobalNewsPresenter
import com.heinminlatt.npnews.mvp.views.ArticleNewsView
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class ArticleNewsPresenterImpl : ArticleNewsPresenter,AbstractBasePresenter<ArticleNewsView>() {
    override fun onUiReady() {
    }

    override fun onTapNewsItem() {
       mView?.navigateToRelatedNewsScreen()
    }
}