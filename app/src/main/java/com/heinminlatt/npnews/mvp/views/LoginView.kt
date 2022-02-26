package com.heinminlatt.npnews.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface LoginView : BaseView{
    fun navigateToRegisterScreen()
    fun navigateToPreviousScreen()
}