package com.wgl.coolbios

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.cash.profin.ya.dinero.plata.lib_common.CommonApplication
import com.linda.lib_common.utils.AppUtil


class MyApplication:CommonApplication(){

    override fun onCreate() {
        super.onCreate()
    }

    override fun init() {
//        initARouter()
    }


    private fun initARouter(){
        if(AppUtil.isDebug()){
            ARouter.openLog()
            ARouter.openDebug()
        }

        ARouter.init(getContext() as Application?)

    }

}