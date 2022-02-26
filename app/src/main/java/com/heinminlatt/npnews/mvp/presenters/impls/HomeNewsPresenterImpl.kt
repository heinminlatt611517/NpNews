package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.HomeNewsPresenter
import com.heinminlatt.npnews.mvp.views.HomeNewsView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class HomeNewsPresenterImpl : HomeNewsPresenter,AbstractBasePresenter<HomeNewsView>() {
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