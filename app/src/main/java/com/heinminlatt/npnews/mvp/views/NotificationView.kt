package com.heinminlatt.npnews.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface NotificationView :BaseView {
    fun navigateToRelatedNewsScreen()
    fun navigateToPreviousScreen()
}