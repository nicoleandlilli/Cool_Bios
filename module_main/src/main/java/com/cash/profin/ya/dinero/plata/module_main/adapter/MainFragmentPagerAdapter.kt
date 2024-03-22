package com.cash.profin.ya.dinero.plata.module_main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_main.MainFragmentFactory

class MainFragmentPagerAdapter(fm:FragmentManager,behavior:Int) :
    FragmentPagerAdapter(fm,behavior){
    override fun getCount(): Int {
       return RouterPaths.MAIN_FRAGMENTS.size
    }

    override fun getItem(position: Int): Fragment {
        return MainFragmentFactory().createFragment(position)
    }

}