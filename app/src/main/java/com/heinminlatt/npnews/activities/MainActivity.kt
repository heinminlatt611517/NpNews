package com.heinminlatt.npnews.activities
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.adapters.MainPagerAdapter
import com.heinminlatt.shared.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    companion object{
        fun  newIntent(context : Context) : Intent {
            return Intent(context,MainActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabViewWithViewPager()
        setUpActionListener()
    }

    private fun setUpActionListener() {
    }


    private fun  setUpTabViewWithViewPager(){
        pager.isUserInputEnabled = false
        val pagerAdapter = MainPagerAdapter(this)
        pager.adapter=pagerAdapter
        TabLayoutMediator(tabs,pager){tab, position ->
            when(position){
                0 -> { tab.text="News"}
                1 -> {tab.text="Article" }
                2 -> {tab.text="Video"}
                3 -> {tab.text="Account"}
            }

        }.attach()
    }


    }
