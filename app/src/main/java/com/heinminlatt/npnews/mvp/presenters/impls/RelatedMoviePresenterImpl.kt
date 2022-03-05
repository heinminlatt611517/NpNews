package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.ArticleNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.GlobalNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.RelatedMoviePresenter
import com.heinminlatt.npnews.mvp.views.ArticleNewsView
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.RelatedMovieView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class RelatedMoviePresenterImpl : RelatedMoviePresenter,AbstractBasePresenter<RelatedMovieView>() {
    override fun onUiReady() {
    }

    override fun onTapBackArrow() {
        mView?.navigateToPreviousScreen()
    }

    override fun onTapMovieItem() {
        mView?.rebuildScreen()
    }


}