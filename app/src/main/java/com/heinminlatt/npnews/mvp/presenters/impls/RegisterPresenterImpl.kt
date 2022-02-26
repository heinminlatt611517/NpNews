package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.RegisterPresenter
import com.heinminlatt.npnews.mvp.views.RegisterView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class RegisterPresenterImpl : RegisterPresenter,AbstractBasePresenter<RegisterView>() {
    override fun onUiReady() {
        TODO("Not yet implemented")
    }

    override fun onTapLogin() {
        mView?.navigateToLoginScreen()
    }

    override fun onTapRegister() {
        TODO("Not yet implemented")
    }

    override fun onTapBackArrow() {
        mView?.navigateToLoginScreen()
    }
}