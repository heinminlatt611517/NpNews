package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.GlobalNewsItemDelegate
import com.heinminlatt.npnews.delegate.LocalNewsItemDelegate
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.LocalNewsView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface LocalNewsPresenter : BasePresenter<LocalNewsView>,LocalNewsItemDelegate {
    fun onUiReady()
}