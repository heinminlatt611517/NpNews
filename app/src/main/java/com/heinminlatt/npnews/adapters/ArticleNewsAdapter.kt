package com.heinminlatt.npnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.views.viewHolders.ArticleNewsViewHolder
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class ArticleNewsAdapter : BaseRecyclerAdapter<BaseViewHolder<Int>, Int>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_items_article_news, parent, false)
        return ArticleNewsViewHolder(view)
    }
}