package com.heinminlatt.npnews.views.viewHolders

import android.view.View
import com.heinminlatt.npnews.delegate.InterviewNewsItemDelegate
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class InterviewNewsViewHolder(private val mDelegate: InterviewNewsItemDelegate, itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
        mDelegate.onTapNewsItem()
    }

    override fun bindData(data: Int) {

    }
}