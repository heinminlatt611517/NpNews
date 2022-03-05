package com.heinminlatt.npnews.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface RelatedMovieView :BaseView {
    fun rebuildScreen()
    fun navigateToPreviousScreen()
}