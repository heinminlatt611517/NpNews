package com.heinminlatt.npnews.views.viewHolders

import android.view.View
import com.heinminlatt.npnews.delegate.RelatedNewsItemDelegate
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class RelatedNewsViewHolder(private val mDelegate: RelatedNewsItemDelegate, itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
        mDelegate.onTapRelatedNewsItem()
    }

    override fun bindData(data: Int) {

    }
}