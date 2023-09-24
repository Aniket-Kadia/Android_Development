package com.example.myapplication.authentication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.authentication.fragment.EmailFragment
import com.example.myapplication.authentication.fragment.PhoneFragment
import com.example.myapplication.utils.Constants

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return Constants.AUTHENTICATION_VIEWPAGER_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            EmailFragment()
        } else {
            PhoneFragment()
        }
    }
}