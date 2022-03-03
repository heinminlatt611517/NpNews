package com.heinminlatt.npnews.views.viewHolders

import android.view.View
import com.heinminlatt.npnews.delegate.ArticleNewsItemDelegate
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class ArticleNewsViewHolder(private val mDelegate : ArticleNewsItemDelegate,itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
     mDelegate.onTapNewsItem()
    }

    override fun bindData(data: Int) {

    }
}