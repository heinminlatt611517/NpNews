package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.GlobalNewsItemDelegate
import com.heinminlatt.npnews.delegate.InterviewNewsItemDelegate
import com.heinminlatt.npnews.delegate.RelatedMoviesItemDelegate
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.InterviewNewsView
import com.heinminlatt.npnews.mvp.views.RelatedMovieView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface RelatedMoviePresenter : BasePresenter<RelatedMovieView>,RelatedMoviesItemDelegate {
    fun onUiReady()
    fun onTapBackArrow()
}