package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.HomeNewsDetailItemDelegate
import com.heinminlatt.npnews.mvp.views.HomeNewsView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface HomeNewsPresenter : BasePresenter<HomeNewsView>,HomeNewsDetailItemDelegate {
    fun onUiReady()
    fun onTapBackArrow()
}