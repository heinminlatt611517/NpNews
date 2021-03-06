package com.heinminlatt.npnews.views.viewHolders

import android.view.View
import com.heinminlatt.npnews.delegate.GlobalNewsItemDelegate
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class GlobalNewsViewHolder(private val delegate : GlobalNewsItemDelegate, itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
       delegate.onTapNewsItem()
    }

    override fun bindData(data: Int) {

    }
}