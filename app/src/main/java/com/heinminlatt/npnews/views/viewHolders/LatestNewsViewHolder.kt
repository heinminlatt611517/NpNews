package com.heinminlatt.npnews.views.viewHolders

import android.view.View
import com.heinminlatt.npnews.delegate.LatestNewsItemDelegate
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class LatestNewsViewHolder(private val delegate : LatestNewsItemDelegate, itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
       delegate.onTapNewsItem()
    }

    override fun bindData(data: Int) {

    }
}