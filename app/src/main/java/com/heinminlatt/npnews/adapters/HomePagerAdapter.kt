package com.heinminlatt.npnews.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.heinminlatt.npnews.fragments.*

class HomePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity)  {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> LatestNewsFragment()
            1 -> GlobalNewsFragment()
            2 -> LocalNewsFragment()
            else -> InterviewFragment()
        }
    }

}