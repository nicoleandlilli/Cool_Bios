package com.cash.profin.ya.dinero.plata.module_main.ui

import android.util.Log
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.cash.profin.ya.dinero.plata.lib_common.config.PrefsConfig
import com.cash.profin.ya.dinero.plata.lib_common.utils.PrefsUtil
import com.cash.profin.ya.dinero.plata.lib_common.view.navigationbar.NavigationBar
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.listener.ViewClickListener
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseActivity
import com.cash.profin.ya.dinero.plata.module_main.MainFragmentFactory
import com.cash.profin.ya.dinero.plata.module_main.adapter.MainFragmentPagerAdapter
import com.cash.profin.ya.dinero.plata.module_main.databinding.MainActivityMainBinding
import com.cash.profin.ya.dinero.plata.module_main.databinding.MainEditMessageBinding
import com.cash.profin.ya.dinero.plata.module_main.ui.dialog.CustomGenderDialog
@Route(path = RouterPaths.EDIT_ACTIVITY)
class EditActivity:BaseActivity<MainEditMessageBinding>() {

    lateinit var mCustomGenderDialog : CustomGenderDialog

    override fun initData() {

    }

    override fun initView() {


    }


    override fun getViewBinding() = MainEditMessageBinding.inflate(layoutInflater)



    private fun refreshView(){
        recreate()
    }


}