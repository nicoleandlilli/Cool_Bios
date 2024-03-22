package com.cash.profin.ya.dinero.plata.module_base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.cash.profin.ya.dinero.plata.lib_common.CommonApplication
import com.linda.lib_common.utils.AppUtil.Companion.isDebug

class BaseApplication: CommonApplication() {

    override fun init() {
        initARouter()
    }

    private fun initARouter(){
        if(isDebug()){
            ARouter.openLog()
            ARouter.openDebug()
        }

        ARouter.init(getContext() as Application?);

    }
}