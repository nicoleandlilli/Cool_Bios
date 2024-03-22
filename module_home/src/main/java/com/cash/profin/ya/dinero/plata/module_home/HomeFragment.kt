package com.cash.profin.ya.dinero.plata.module_home


import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseFragment
import com.cash.profin.ya.dinero.plata.module_home.databinding.HomeFragmentHomeBinding
@Route(path = RouterPaths.HOME_POPULAR)
class HomeFragment:BaseFragment<HomeFragmentHomeBinding>() {
    override fun getViewBinding(container: ViewGroup?)=HomeFragmentHomeBinding.inflate(layoutInflater)

    override fun initView() {

    }

    override fun initData() {

    }
}