package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.ArticleNewsItemDelegate
import com.heinminlatt.npnews.delegate.GlobalNewsItemDelegate
import com.heinminlatt.npnews.mvp.views.ArticleNewsView
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface ArticleNewsPresenter : BasePresenter<ArticleNewsView>,ArticleNewsItemDelegate {
    fun onUiReady()
}