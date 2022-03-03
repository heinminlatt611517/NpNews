package com.heinminlatt.npnews.views.viewHolders

import android.view.View
import com.heinminlatt.npnews.delegate.LocalNewsItemDelegate
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class LocalNewsViewHolder(private val mDelegate: LocalNewsItemDelegate,itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
       mDelegate.onTapNewsItem()
    }

    override fun bindData(data: Int) {

    }
}