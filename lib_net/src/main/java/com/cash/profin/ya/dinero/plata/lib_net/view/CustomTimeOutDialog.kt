package com.cash.profin.ya.dinero.plata.module_base.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import com.cash.profin.ya.dinero.plata.lib_net.R


class CustomTimeOutDialog: Dialog {

    lateinit var btCancel:Button
    lateinit var btConfirm:Button
    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, themeStyle: Int) : super(context, themeStyle) {
        initView()
    }

    private fun initView() {
        setContentView(R.layout.dialog_custom_time_out_dialog)

        btCancel=findViewById(R.id.bt_cancel)
        btConfirm = findViewById(R.id.bt_agree)

        //设置Dialog的样式和位置
        var window: Window? = getWindow()
        window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            setGravity(Gravity.CENTER)
        }
    }


}