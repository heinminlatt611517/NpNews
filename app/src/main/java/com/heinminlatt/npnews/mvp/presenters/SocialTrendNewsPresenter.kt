package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.GlobalNewsItemDelegate
import com.heinminlatt.npnews.delegate.InterviewNewsItemDelegate
import com.heinminlatt.npnews.delegate.SocialTrendMovieItemDelegate
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.InterviewNewsView
import com.heinminlatt.npnews.mvp.views.SocialTrendNewsView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface SocialTrendNewsPresenter : BasePresenter<SocialTrendNewsView>,SocialTrendMovieItemDelegate {
    fun onUiReady()
}