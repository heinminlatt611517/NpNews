package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.SocialTrendNewsPresenter
import com.heinminlatt.npnews.mvp.views.SocialTrendNewsView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class SocialTrendNewsPresenterImpl : SocialTrendNewsPresenter,AbstractBasePresenter<SocialTrendNewsView>() {
    override fun onUiReady() {
    }

    override fun onTapMovieItem() {
        mView?.navigateToRelatedMovieScreen()
    }


}