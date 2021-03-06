package com.heinminlatt.npnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.delegate.InterviewNewsItemDelegate
import com.heinminlatt.npnews.views.viewHolders.HomeNewsViewHolder
import com.heinminlatt.npnews.views.viewHolders.InterviewNewsViewHolder
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class InterviewNewsAdapter(delegate: InterviewNewsItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<Int>, Int>() {
    var mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_items_home_news, parent, false)
        return InterviewNewsViewHolder(mDelegate,view)
    }
}