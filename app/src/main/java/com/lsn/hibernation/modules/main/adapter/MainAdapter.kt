package com.lsn.hibernation.modules.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/10 15:06
 * Description
 */
class MainAdapter(fm: FragmentManager, var fragments: List<Fragment>, var titles: List<String>) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}