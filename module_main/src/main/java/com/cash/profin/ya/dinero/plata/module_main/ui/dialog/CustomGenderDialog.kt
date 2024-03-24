package com.cash.profin.ya.dinero.plata.module_main.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import com.cash.profin.ya.dinero.plata.lib_common.config.PrefsConfig
import com.cash.profin.ya.dinero.plata.lib_common.utils.PrefsUtil
import com.cash.profin.ya.dinero.plata.lib_net.R
import com.cash.profin.ya.dinero.plata.module_main.databinding.MainDialogGenderBinding


class CustomGenderDialog: Dialog {


    lateinit var mMainDialogGenderBinding:MainDialogGenderBinding
    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, themeStyle: Int) : super(context, themeStyle) {
        initView()
    }

    private fun initView() {
        mMainDialogGenderBinding = MainDialogGenderBinding.inflate(layoutInflater)
        setContentView(mMainDialogGenderBinding.root)

        //设置Dialog的样式和位置
        var window: Window? = getWindow()
        window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window.decorView.setPadding(40,0,40,0)
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            setGravity(Gravity.CENTER)
        }

        mMainDialogGenderBinding.lvBoy.setOnClickListener({
            var gender:String by PrefsUtil(PrefsConfig.GENDER,PrefsConfig.GENDER_BOTH)
            gender = PrefsConfig.GENDER_MALE
            dismiss()
        })

        mMainDialogGenderBinding.lvGirl.setOnClickListener({
            var gender:String by PrefsUtil(PrefsConfig.GENDER,PrefsConfig.GENDER_BOTH)
            gender = PrefsConfig.GENDER_FEMALE
            dismiss()
        })

        mMainDialogGenderBinding.lvBoth.setOnClickListener({
            var gender:String by PrefsUtil(PrefsConfig.GENDER,PrefsConfig.GENDER_BOTH)
            gender = PrefsConfig.GENDER_BOTH
            dismiss()
        })
    }


}