package com.heinminlatt.npnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.delegate.GlobalNewsItemDelegate
import com.heinminlatt.npnews.delegate.LatestNewsItemDelegate
import com.heinminlatt.npnews.views.viewHolders.GlobalNewsViewHolder
import com.heinminlatt.npnews.views.viewHolders.HomeNewsViewHolder
import com.heinminlatt.npnews.views.viewHolders.LatestNewsViewHolder
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class LatestNewsAdapter(delegate : LatestNewsItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<Int>, Int>() {
    var mDelegate  = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_items_latest_news, parent, false)
        return LatestNewsViewHolder(mDelegate,view)
    }
}