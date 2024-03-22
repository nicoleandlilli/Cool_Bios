package com.cash.profin.ya.dinero.plata.module_base.impl

import androidx.fragment.app.Fragment

interface IFragmentFactory{
    fun createFragment(position: Int): Fragment

}