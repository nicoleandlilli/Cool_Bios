package com.cash.profin.ya.dinero.plata.module_main.ui

import android.util.Log
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.cash.profin.ya.dinero.plata.lib_common.config.PrefsConfig
import com.cash.profin.ya.dinero.plata.lib_common.utils.PrefsUtil
import com.cash.profin.ya.dinero.plata.lib_common.view.navigationbar.NavigationBar
import com.cash.profin.ya.dinero.plata.module_base.listener.ViewClickListener
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseActivity
import com.cash.profin.ya.dinero.plata.module_main.MainFragmentFactory
import com.cash.profin.ya.dinero.plata.module_main.adapter.MainFragmentPagerAdapter
import com.cash.profin.ya.dinero.plata.module_main.databinding.MainActivityMainBinding
import com.cash.profin.ya.dinero.plata.module_main.ui.dialog.CustomGenderDialog

class MainActivity:BaseActivity<MainActivityMainBinding>() {

    lateinit var mCustomGenderDialog : CustomGenderDialog

    override fun initData() {

    }

    override fun initView() {
        initTitlebarTile()

        mCustomGenderDialog = CustomGenderDialog(this);
        mCustomGenderDialog.mMainDialogGenderBinding.lvBoy.setOnClickListener({
            var gender:String by PrefsUtil(PrefsConfig.GENDER, PrefsConfig.GENDER_BOTH)
            gender = PrefsConfig.GENDER_MALE
            mBinding.cvTitlebar.tvGender.setText("BOY")
            mCustomGenderDialog.dismiss()
            refreshView()
        })

        mCustomGenderDialog.mMainDialogGenderBinding.lvGirl.setOnClickListener({
            var gender:String by PrefsUtil(PrefsConfig.GENDER, PrefsConfig.GENDER_BOTH)
            gender = PrefsConfig.GENDER_FEMALE
            mBinding.cvTitlebar.tvGender.setText("GIRL")
            mCustomGenderDialog.dismiss()
            refreshView()
        })

        mCustomGenderDialog.mMainDialogGenderBinding.lvBoth.setOnClickListener({
            var gender:String by PrefsUtil(PrefsConfig.GENDER, PrefsConfig.GENDER_BOTH)
            gender = PrefsConfig.GENDER_BOTH
            mBinding.cvTitlebar.tvGender.setText("BOTH")
            mCustomGenderDialog.dismiss()
            refreshView()
        })



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


        mBinding.cvTitlebar.tvGender.setOnClickListener({
            mCustomGenderDialog.show()
        })

    }

    private fun initTitlebarTile() {
        var gender: String by PrefsUtil(PrefsConfig.GENDER, PrefsConfig.GENDER_BOTH)
        if (gender == PrefsConfig.GENDER_MALE) {
            mBinding.cvTitlebar.tvGender.setText("BOY")
        } else if (gender == PrefsConfig.GENDER_FEMALE) {
            mBinding.cvTitlebar.tvGender.setText("GIRL")
        } else {
            mBinding.cvTitlebar.tvGender.setText("BOTH")
        }
    }

    override fun getViewBinding() = MainActivityMainBinding.inflate(layoutInflater)



    private fun refreshView(){
        recreate()
    }


}