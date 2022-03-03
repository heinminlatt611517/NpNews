package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.HomePresenter
import com.heinminlatt.npnews.mvp.views.HomeView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class HomePresenterImpl : HomePresenter,AbstractBasePresenter<HomeView>() {
    override fun onUiReady() {

    }

    override fun onTapNotification() {
        mView?.navigateToNotificationScreen()
    }

    override fun onTapNewsItems() {
        mView?.navigateToNewsDetailScreen()
    }
}