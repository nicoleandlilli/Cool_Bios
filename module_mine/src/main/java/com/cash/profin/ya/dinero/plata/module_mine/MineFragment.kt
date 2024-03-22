package com.cash.profin.ya.dinero.plata.module_mine


import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseFragment
import com.cash.profin.ya.dinero.plata.module_mine.databinding.MineFragmentMineBinding
@Route(path = RouterPaths.MINE_FRAGMENT)
class MineFragment:BaseFragment<MineFragmentMineBinding>() {
    override fun getViewBinding(container: ViewGroup?)=MineFragmentMineBinding.inflate(layoutInflater)

    override fun initView() {

    }

    override fun initData() {

    }
}