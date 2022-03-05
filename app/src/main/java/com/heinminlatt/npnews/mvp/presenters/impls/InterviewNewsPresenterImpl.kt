package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.GlobalNewsPresenter
import com.heinminlatt.npnews.mvp.presenters.InterviewNewsPresenter
import com.heinminlatt.npnews.mvp.views.GlobalNewsView
import com.heinminlatt.npnews.mvp.views.InterviewNewsView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class InterviewNewsPresenterImpl : InterviewNewsPresenter,AbstractBasePresenter<InterviewNewsView>() {
    override fun onUiReady() {
    }

    override fun onTapNewsItem() {
       mView?.navigateToRelatedNewsScreen()
    }
}