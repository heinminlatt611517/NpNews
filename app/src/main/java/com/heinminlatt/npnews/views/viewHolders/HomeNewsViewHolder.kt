package com.heinminlatt.npnews.views.viewHolders

import android.view.View
import com.heinminlatt.npnews.delegate.HomeNewsItemDelegate
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class HomeNewsViewHolder(private val delegate : HomeNewsItemDelegate, itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
        delegate.onTapNewsItems()
    }

    override fun bindData(data: Int) {

    }
}