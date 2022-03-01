package com.heinminlatt.npnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.views.viewHolders.CommentMessageViewHolder
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class CommentMessageAdapter : BaseRecyclerAdapter<BaseViewHolder<Int>, Int>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_items_comment_message, parent, false)
        return CommentMessageViewHolder(view)
    }
}