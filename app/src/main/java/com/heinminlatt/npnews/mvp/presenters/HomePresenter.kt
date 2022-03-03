package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.HomeNewsItemDelegate
import com.heinminlatt.npnews.mvp.views.HomeView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface HomePresenter : BasePresenter<HomeView>,HomeNewsItemDelegate {
    fun onUiReady()
    fun onTapNotification()
}