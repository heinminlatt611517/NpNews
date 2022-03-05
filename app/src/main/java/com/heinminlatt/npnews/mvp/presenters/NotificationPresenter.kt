package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.GlobalNewsItemDelegate
import com.heinminlatt.npnews.delegate.LatestNewsItemDelegate
import com.heinminlatt.npnews.delegate.NotificationItemDelegate
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.LatestNewsView
import com.heinminlatt.npnews.mvp.views.NotificationView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface NotificationPresenter : BasePresenter<NotificationView>,NotificationItemDelegate {
    fun onUiReady()
    fun onTapBackArrow()
}