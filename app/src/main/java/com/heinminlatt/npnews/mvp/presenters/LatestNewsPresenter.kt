package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.GlobalNewsItemDelegate
import com.heinminlatt.npnews.delegate.LatestNewsItemDelegate
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.LatestNewsView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface LatestNewsPresenter : BasePresenter<LatestNewsView>,LatestNewsItemDelegate {
    fun onUiReady()
}