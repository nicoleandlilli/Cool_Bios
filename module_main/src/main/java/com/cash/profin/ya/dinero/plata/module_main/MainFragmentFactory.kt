package com.cash.profin.ya.dinero.plata.module_main

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.impl.IFragmentFactory
import com.cash.profin.ya.dinero.plata.module_main.ui.TestFragment

class MainFragmentFactory : IFragmentFactory {
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0->
                fragment = ARouter.getInstance().build(RouterPaths.HOME_POPULAR)
                    .navigation() as Fragment
//                fragment = TestFragment()
            1->
                fragment = ARouter.getInstance().build(RouterPaths.HOME_LATEST)
                    .navigation() as Fragment
            2->
                fragment = ARouter.getInstance().build(RouterPaths.MINE_FRAGMENT)
                    .navigation() as Fragment
        }

        return fragment!!
    }

}