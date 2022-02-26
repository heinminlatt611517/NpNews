package com.heinminlatt.npnews.mvp.presenters

import com.heinminlatt.npnews.mvp.views.AccountView
import com.heinminlatt.shared.mvp.presenter.BasePresenter

interface AccountPresenter : BasePresenter<AccountView> {
    fun onUiReady()
    fun onTapSignOut()
    fun onTapEdit()
}