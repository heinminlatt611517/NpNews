package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.LoginPresenter
import com.heinminlatt.npnews.mvp.views.LoginView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class LoginPresenterImpl : LoginPresenter,AbstractBasePresenter<LoginView>() {
    override fun onUiReady() {
        TODO("Not yet implemented")
    }

    override fun onTapLogin() {
        TODO("Not yet implemented")
    }

    override fun onTapForgotPassword() {
        TODO("Not yet implemented")
    }

    override fun onTapRegister() {
        mView?.navigateToRegisterScreen()
    }

    override fun onTapBackArrow() {
        mView?.navigateToPreviousScreen()
    }
}