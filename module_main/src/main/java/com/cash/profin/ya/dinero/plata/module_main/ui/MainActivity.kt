package com.cash.profin.ya.dinero.plata.module_main.ui

import androidx.viewpager.widget.ViewPager
import com.cash.profin.ya.dinero.plata.lib_common.view.navigationbar.NavigationBar
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseActivity
import com.cash.profin.ya.dinero.plata.module_main.MainFragmentFactory
import com.cash.profin.ya.dinero.plata.module_main.adapter.MainFragmentPagerAdapter
import com.cash.profin.ya.dinero.plata.module_main.databinding.MainActivityMainBinding

class MainActivity:BaseActivity<MainActivityMainBinding>() {

    override fun initData() {

    }

    override fun initView() {
        mBinding.navigationBar.setOnViewClickListener(object :NavigationBar.OnViewClickListener{
            override fun onSelected(position: Int) {
                mBinding.viewPager?.currentItem = position
            }

            override fun onReSelected(position: Int) {

            }
        })

        mBinding.viewPager.run {
            offscreenPageLimit = 2
            adapter = MainFragmentPagerAdapter(supportFragmentManager,0)

            addOnPageChangeListener (object :ViewPager.OnPageChangeListener{
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    mBinding.navigationBar?.setCurrentIndex(position)
                }

                override fun onPageScrollStateChanged(state: Int) {

                }

            })
        }


    }

    override fun getViewBinding() = MainActivityMainBinding.inflate(layoutInflater)



}