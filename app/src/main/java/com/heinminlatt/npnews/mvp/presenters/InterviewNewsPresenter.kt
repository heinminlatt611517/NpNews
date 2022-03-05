package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.delegate.GlobalNewsItemDelegate
import com.heinminlatt.npnews.delegate.InterviewNewsItemDelegate
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.InterviewNewsView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface InterviewNewsPresenter : BasePresenter<InterviewNewsView>,InterviewNewsItemDelegate {
    fun onUiReady()
}