package com.heinminlatt.npnews.views.viewHolders

import android.view.View
import com.heinminlatt.npnews.delegate.HomeNewsDetailItemDelegate
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class HomeRelatedNewsViewHolder(private val mDelegate: HomeNewsDetailItemDelegate, itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
        mDelegate.onTapRelatedNewsItem()
    }

    override fun bindData(data: Int) {

    }
}