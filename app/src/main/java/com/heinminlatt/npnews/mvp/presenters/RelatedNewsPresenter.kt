package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.RelatedNewsItemDelegate
import com.heinminlatt.npnews.mvp.views.RelatedNewsView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface RelatedNewsPresenter : BasePresenter<RelatedNewsView>,RelatedNewsItemDelegate {
    fun onUiReady()
    fun onTapBackArrow()
}