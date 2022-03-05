package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.GlobalNewsItemDelegate
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface GlobalNewsPresenter : BasePresenter<GlobalNewsView>,GlobalNewsItemDelegate {
    fun onUiReady()
}