package com.heinminlatt.npnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.delegate.ArticleNewsItemDelegate
import com.heinminlatt.npnews.views.viewHolders.ArticleNewsViewHolder
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class ArticleNewsAdapter(delegate: ArticleNewsItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<Int>, Int>() {
    var mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_items_article_news, parent, false)
        return ArticleNewsViewHolder(mDelegate,view)
    }
}