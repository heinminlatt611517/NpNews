package com.heinminlatt.npnews.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface RelatedNewsView : BaseView {
    fun navigateToLoginScreen()
    fun navigateToPreviousScreen()
    fun navigateToNewsDetailScreen()
}