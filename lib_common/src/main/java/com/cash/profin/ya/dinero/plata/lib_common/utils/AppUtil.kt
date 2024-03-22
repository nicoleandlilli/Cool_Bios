package com.linda.lib_common.utils

import android.content.Context
import android.content.pm.PackageInfo

import android.content.pm.PackageManager
import android.text.TextUtils
import com.cash.profin.ya.dinero.plata.lib_common.BuildConfig


class AppUtil {

    companion object {

        fun isDebug(): Boolean {

            return !TextUtils.equals(BuildConfig.BUILD_TYPE, "release")
        }

        /**
         * 获取版本名
         *
         * @param context
         * @return 获取失败则返回null
         */
        fun getVersionName(context: Context): String? {
            val mg: PackageManager = context.packageManager
            try {
                // getPackageInfo(packageName 包名, flags 标志位（表示要获取什么数据）);
                // 0表示获取基本数据
                val info: PackageInfo =
                    mg.getPackageInfo(context.packageName, 0)
                return info.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return null
        }

        /**
         * 获取版本号
         *
         * @param context
         * @return 获取失败则返回0
         */
        fun getVersionCode(context: Context): Int {
            val mg: PackageManager = context.packageManager
            try {
                val info: PackageInfo =
                    mg.getPackageInfo(context.packageName, 0)
                return info.versionCode
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return 0
        }
    }
}