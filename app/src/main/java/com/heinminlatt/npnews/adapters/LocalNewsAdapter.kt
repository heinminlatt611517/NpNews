package com.heinminlatt.npnews.adapters

import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.ViewGroup
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.delegate.LocalNewsItemDelegate
import com.heinminlatt.npnews.views.viewHolders.LocalNewsViewHolder
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class LocalNewsAdapter(delegate: LocalNewsItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<Int>, Int>() {
    var mDelegate  = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_items_local_news, parent, false)
        return LocalNewsViewHolder(mDelegate,view)
    }
}