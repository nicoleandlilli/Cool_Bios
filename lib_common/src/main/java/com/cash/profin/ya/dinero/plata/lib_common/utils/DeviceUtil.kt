package com.cash.profin.ya.dinero.plata.lib_common.utils

import android.os.Build

class DeviceUtil {

    companion object {

        /**
         *  获取手机品牌
         */
        fun getMobileBrand(): String {
            var model: String? = Build.BRAND
            model = model?.trim { it <= ' ' } ?: ""
            return model
        }

        /**
         *  获取手机型号
         */
        fun getMobileModel(): String {
            var model: String? = Build.MODEL
            model = model?.trim { it <= ' ' } ?: ""
            return model
        }

        /**
         * 获取当前手机系统版本号
         *
         * @return  系统版本号
         */
        fun getSystemVersion(): String? {
            return Build.VERSION.RELEASE
        }
    }
}