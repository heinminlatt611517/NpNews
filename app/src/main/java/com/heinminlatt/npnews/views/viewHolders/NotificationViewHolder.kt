package com.heinminlatt.npnews.views.viewHolders

import android.content.res.Resources
import android.os.Build
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import com.heinminlatt.npnews.delegate.LatestNewsItemDelegate
import com.heinminlatt.npnews.delegate.NotificationItemDelegate
import com.heinminlatt.shared.R
import com.heinminlatt.shared.view.viewHolders.BaseViewHolder
import kotlinx.android.synthetic.main.activity_related_news.*
import kotlinx.android.synthetic.main.list_items_notification.view.*

class NotificationViewHolder(private val mDelegate: NotificationItemDelegate,itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {

        mDelegate.onTapNewsItem()
    }

    val resources: Resources = itemView.resources
    override fun bindData(data: Int) {
        mData = data
        mData?.let {
            //addReadMore(resources.getString(com.heinminlatt.npnews.R.string.new_details_description), itemView.tv_news_title)
        }
    }

    fun addReadMore(text: String, textView: TextView) {
        val ss = SpannableString(text.substring(0, 100) + "... read more")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                addReadLess(text, textView)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ds.color = resources.getColor(R.color.colorPrimary, resources.newTheme())
                } else {
                    ds.color = resources.getColor(R.color.colorPrimary)
                }
            }
        }
        ss.setSpan(clickableSpan, ss.length - 10, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = ss
        textView.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun addReadLess(text: String, textView: TextView) {
        val ss = SpannableString("$text read less")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                addReadMore(text, textView)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ds.color = resources.getColor(R.color.colorPrimary, resources.newTheme())
                } else {
                    ds.color = resources.getColor(R.color.colorPrimary)
                }
            }
        }
        ss.setSpan(clickableSpan, ss.length - 10, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = ss
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}
