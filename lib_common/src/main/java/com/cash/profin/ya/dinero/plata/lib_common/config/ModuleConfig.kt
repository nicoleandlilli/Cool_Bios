package com.cash.profin.ya.dinero.plata.lib_common.config

class ModuleConfig {

    companion object{
        private const val MODULE_BASE = "com.cash.profin.ya.dinero.plata.module_base.BaseApplication"
        private const val MODULE_APP = "com.cash.profin.ya.dinero.plata.credit.MyApplication"

        val modules =
            arrayOf(MODULE_BASE, MODULE_APP)
    }
}
