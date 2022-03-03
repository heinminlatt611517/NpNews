package com.heinminlatt.npnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.delegate.RelatedNewsItemDelegate
import com.heinminlatt.npnews.views.viewHolders.RelatedNewsViewHolder
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class RelatedNewsAdapter(delegate : RelatedNewsItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<Int>, Int>() {
    var mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_items_home_related_news, parent, false)
        return RelatedNewsViewHolder(mDelegate,view)
    }
}