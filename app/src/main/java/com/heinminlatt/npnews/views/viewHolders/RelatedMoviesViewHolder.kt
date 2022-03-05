package com.heinminlatt.npnews.views.viewHolders

import android.view.View
import com.heinminlatt.npnews.delegate.LatestNewsItemDelegate
import com.heinminlatt.npnews.delegate.RelatedMoviesItemDelegate
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class RelatedMoviesViewHolder(private val delegate : RelatedMoviesItemDelegate, itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
       delegate.onTapMovieItem()
    }

    override fun bindData(data: Int) {

    }
}