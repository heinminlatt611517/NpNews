package com.heinminlatt.npnews.mvp.presenters.impls

import com.heinminlatt.npnews.mvp.presenters.AccountPresenter
import com.heinminlatt.npnews.mvp.views.AccountView
import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter

class AccountPresenterImpl : AccountPresenter,AbstractBasePresenter<AccountView>() {
    override fun onUiReady() {

    }

    override fun onTapSignOut() {
      mView?.showLogoutDialog()
    }

    override fun onTapEdit() {
        mView?.navigateToEditProfileScreen()
    }
}