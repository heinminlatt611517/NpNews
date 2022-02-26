package com.heinminlatt.npnews.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.heinminlatt.npnews.R
import com.heinminlatt.shared.activity.BaseActivity

class NewsDetailActivity : BaseActivity() {

    companion object{
        fun  newIntent(context : Context) : Intent {
            return Intent(context,NewsDetailActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
    }
}