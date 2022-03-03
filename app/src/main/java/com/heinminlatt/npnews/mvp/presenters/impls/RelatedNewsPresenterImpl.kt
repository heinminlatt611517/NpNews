package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.RelatedNewsPresenter
import com.heinminlatt.npnews.mvp.views.RelatedNewsView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class RelatedNewsPresenterImpl : RelatedNewsPresenter,AbstractBasePresenter<RelatedNewsView>() {
    override fun onUiReady() {

    }

    override fun onTapBackArrow() {
        mView?.navigateToPreviousScreen()
    }

    override fun onTapLogin() {
        mView?.navigateToLoginScreen()
    }

    override fun onTapRelatedNewsItem() {
        mView?.navigateToNewsDetailScreen()
    }
}