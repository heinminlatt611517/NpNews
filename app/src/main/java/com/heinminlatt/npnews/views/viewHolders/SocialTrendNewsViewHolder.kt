package com.heinminlatt.npnews.views.viewHolders

import android.view.View
import com.heinminlatt.npnews.delegate.SocialTrendMovieItemDelegate
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder

class SocialTrendNewsViewHolder(
    private val mDelegate: SocialTrendMovieItemDelegate,
    itemView: View
) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
        mDelegate.onTapMovieItem()
    }

    override fun bindData(data: Int) {

    }
}