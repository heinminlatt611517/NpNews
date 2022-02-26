package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.mvp.views.LoginView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface LoginPresenter : BasePresenter<LoginView> {
    fun onUiReady()
    fun onTapLogin()
    fun onTapForgotPassword()
    fun onTapRegister()
    fun onTapBackArrow()
}