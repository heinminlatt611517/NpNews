package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.mvp.views.RegisterView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onUiReady()
    fun onTapLogin()
    fun onTapRegister()
    fun onTapBackArrow()
}