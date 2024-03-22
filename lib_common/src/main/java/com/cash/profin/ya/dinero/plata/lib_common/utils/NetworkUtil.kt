package com.cash.profin.ya.dinero.plata.lib_common.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil {

    companion object {

        /**
         * 网络是否可用
         */
        fun isNetworkAvailable(context: Context): Boolean {
            val manager =
                context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = manager.activeNetworkInfo
            return info != null && info.isAvailable
        }
    }
}