package com.example.advancedwealthtracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.advancedwealthtracker.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding-ის ინიციალიზაცია
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ადაპტერის შექმნა
        val adapter = ViewPagerAdapter(this)
        binding.lgliViewPager.adapter = adapter

        // დავალების პირობა: გვარი იწყება თანხმოვანზე (გ) -> ORIENTATION_VERTICAL
        binding.lgliViewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        // TabLayout-ის და ViewPager2-ის შეერთება (TabLayoutMediator)
        TabLayoutMediator(binding.lgliTabLayout, binding.lgliViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Input"
                1 -> "Analytics"
                2 -> "Profile"
                else -> null
            }
        }.attach()
    }
}