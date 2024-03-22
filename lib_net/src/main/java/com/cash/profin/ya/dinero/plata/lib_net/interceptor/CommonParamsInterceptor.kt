package com.cash.profin.ya.dinero.plata.lib_net.interceptor


import com.cash.profin.ya.dinero.plata.lib_common.CommonApplication
import com.cash.profin.ya.dinero.plata.lib_common.utils.DeviceUtil
import com.cash.profin.ya.dinero.plata.lib_common.utils.DisplayUtil
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CommonParamsInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var originalRequest = chain.request()
        var request: Request
        val modifiedUrl = originalRequest.url.newBuilder()
            .addQueryParameter("udid", "6a6fa0cffa894788983cce8dc7d33cd7c508f3bb")
            .addQueryParameter("vc", "6030071")
            .addQueryParameter("vn", "6.3.7")
            .addQueryParameter(
                "size",
                DisplayUtil.getScreenRatio(CommonApplication.getContext())
            )
            .addQueryParameter("deviceModel", DeviceUtil.getMobileModel())
            .addQueryParameter("first_channel", DeviceUtil.getMobileBrand())
            .addQueryParameter("last_channel", DeviceUtil.getMobileBrand())
            .addQueryParameter("system_version_code", DeviceUtil.getSystemVersion())
            .build()

        request = originalRequest.newBuilder().url(modifiedUrl).build()
        return chain.proceed(request)
    }
}