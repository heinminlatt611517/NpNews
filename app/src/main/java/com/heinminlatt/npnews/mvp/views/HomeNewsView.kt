package com.heinminlatt.npnews.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface HomeNewsView : BaseView {
    fun navigateToLoginScreen()
    fun navigateToPreviousScreen()
    fun navigateToNewsDetailScreen()
}