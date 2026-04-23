package com.example.advancedwealthtracker

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    // გვაქვს 3 გვერდი
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> InputFragment()
            1 -> AnalyticsFragment()
            2 -> ProfileFragment()
            else -> InputFragment()
        } as Fragment
    }
}