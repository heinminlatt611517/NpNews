package com.heinminlatt.npnews.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.heinminlatt.npnews.fragments.*

class MainPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity)  {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> HomeFragment()
            1 -> ArticleFragment()
            2 -> SocialTrendNewsFragment()
            else -> AccountFragment()
        }
    }

}