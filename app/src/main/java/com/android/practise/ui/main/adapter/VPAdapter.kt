package com.android.practise.ui.main.adapter

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class VPAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // objects of arrayList. One is of Fragment type and
    // another one is of String type.*/
    private final var fragmentList: ArrayList<Fragment> = ArrayList()
    private final var fragmentTitleList: ArrayList<String> = ArrayList()

    // returns which item is selected from arrayList of fragments.
    override fun getItem(position: Int) = fragmentList[position]

    // returns which item is selected from arrayList of titles.
    @Nullable
    override fun getPageTitle(position: Int) =  fragmentTitleList[position]

    // returns the number of items present in arrayList.
    override fun getCount() =  fragmentList.size

    // this function adds the fragment and title in 2 separate  arrayList.
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }
}